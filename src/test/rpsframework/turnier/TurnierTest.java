package test.rpsframework.turnier;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import rpsframework.basis.SteinScherePapierSpieler;
import rpsframework.basis.Symbol;
import rpsframework.turnier.Turnier;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TurnierTest {

    private Turnier turnier;
    private ArrayList<SteinScherePapierSpieler> spieler;

    @BeforeEach
    void setUp() {

        this.spieler = new ArrayList<>();
        this.turnier = new Turnier();

        this.spieler.add(new SpielerMock(1, Symbol.PAPIER));
        this.spieler.add(new SpielerMock(2, Symbol.STEIN));
        this.spieler.add(new SpielerMock(3, Symbol.SCHERE));
        this.spieler.add(new SpielerMock(4, Symbol.STEIN));
        this.spieler.add(new SpielerMock(5, Symbol.SCHERE));
        this.spieler.add(new SpielerMock(6, Symbol.STEIN));

        for (SteinScherePapierSpieler spieler : this.spieler) {

            this.turnier.fuegeTeilnehmerHinzu(spieler);
        }

        this.turnier.starteTurnier();
    }

    @Test
    void testeAnzahlTeilnehmer() {

        assertEquals(6, this.turnier.gibAnzahlSpieler());

        this.turnier.fuegeTeilnehmerHinzu(new SpielerMock(1, Symbol.STEIN));

        assertEquals(6, this.turnier.gibAnzahlSpieler());
    }

    @Test
    void testeAnzahlSpiele() {

        assertEquals(15, this.turnier.gibAnzahlSpiele());

        this.turnier.fuegeTeilnehmerHinzu(new SpielerMock(7, Symbol.PAPIER));

        this.turnier.starteTurnier();

        assertEquals(21, this.turnier.gibAnzahlSpiele());
    }

    @Test
    void testeAnzahlSymbolFuerSpieler() {

        assertEquals(500, this.turnier.zaehleSymbolFuerSpieler(this.spieler.get(0), Symbol.PAPIER));
        assertEquals(500, this.turnier.zaehleSymbolFuerSpieler(this.spieler.get(1), Symbol.STEIN));
        assertEquals(500, this.turnier.zaehleSymbolFuerSpieler(this.spieler.get(2), Symbol.SCHERE));
        assertEquals(500, this.turnier.zaehleSymbolFuerSpieler(this.spieler.get(3), Symbol.STEIN));
        assertEquals(500, this.turnier.zaehleSymbolFuerSpieler(this.spieler.get(4), Symbol.SCHERE));
        assertEquals(500, this.turnier.zaehleSymbolFuerSpieler(this.spieler.get(5), Symbol.STEIN));
    }

    @Test
    void testeZaehleSpielerPunkte() {

        assertEquals(300, this.turnier.zaehleSpielerPunkte(this.spieler.get(0)));
        assertEquals(200, this.turnier.zaehleSpielerPunkte(this.spieler.get(1)));
        assertEquals(100, this.turnier.zaehleSpielerPunkte(this.spieler.get(2)));
        assertEquals(200, this.turnier.zaehleSpielerPunkte(this.spieler.get(3)));
        assertEquals(100, this.turnier.zaehleSpielerPunkte(this.spieler.get(4)));
        assertEquals(200, this.turnier.zaehleSpielerPunkte(this.spieler.get(5)));
    }

    @Test
    void testeZaehleSymbol() {

        assertEquals(500, this.turnier.zaehleSymbol(Symbol.PAPIER));
        assertEquals(1500, this.turnier.zaehleSymbol(Symbol.STEIN));
        assertEquals(1000, this.turnier.zaehleSymbol(Symbol.SCHERE));
    }

    @Test
    void keinGewinnerWennAlleSpielerDieselbePunktzahlHaben() {

        //TODO
    }
}
