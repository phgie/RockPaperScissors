package test.rpsframework.basis;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import rpsframework.basis.Spiel;
import rpsframework.basis.SteinScherePapierSpieler;
import rpsframework.basis.Symbol;
import test.rpsframework.mocks.SpielerMock;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SpielTest {

    private ArrayList<SteinScherePapierSpieler> spieler;

    @BeforeEach
    void setUp() {

        this.spieler = new ArrayList<>();

        this.spieler.add(new SpielerMock(1, Symbol.PAPIER));
        this.spieler.add(new SpielerMock(2, Symbol.STEIN));
        this.spieler.add(new SpielerMock(3, Symbol.SCHERE));
        this.spieler.add(new SpielerMock(4, Symbol.STEIN));
        this.spieler.add(new SpielerMock(5, Symbol.SCHERE));
        this.spieler.add(new SpielerMock(6, Symbol.STEIN));
    }


    @Test
    void testIstTeilnehmer() {

        Spiel spiel = new Spiel(10);

        spiel.fuegeSpielerHinzu(null);
        assertFalse(spiel.istTeilnehmer(null));

        spiel.fuegeSpielerHinzu(this.spieler.get(0));
        spiel.fuegeSpielerHinzu(this.spieler.get(1));

        assertTrue(spiel.istTeilnehmer(this.spieler.get(0)));
        assertTrue(spiel.istTeilnehmer(this.spieler.get(1)));

        assertFalse(spiel.istTeilnehmer(this.spieler.get(2)));
        assertFalse(spiel.istTeilnehmer(null));
    }

    @Test
    void testStarteSpiel() {

        Spiel spiel = new Spiel(10);
        spiel.starteSpiel();

        assertEquals(0, spiel.gibSpielerPunkte(null));
        assertEquals(0, spiel.zaehleSymbolFuerSpieler(null, null));
        assertEquals(0, spiel.zaehleSymbolFuerSpieler(null, Symbol.PAPIER));
        assertEquals(0, spiel.zaehleSymbolFuerSpieler(this.spieler.get(0), null));
        assertEquals(0, spiel.zaehleSymbolFuerSpieler(this.spieler.get(0), Symbol.PAPIER));

        assertEquals(0, spiel.gibSpielerPunkte(null));
        assertEquals(0, spiel.gibSpielerPunkte(this.spieler.get(0)));
        assertEquals(0, spiel.gibSpielerPunkte(this.spieler.get(1)));

        spiel.fuegeSpielerHinzu(this.spieler.get(0));
        spiel.starteSpiel();

        assertEquals(0, spiel.gibSpielerPunkte(null));
        assertEquals(0, spiel.zaehleSymbolFuerSpieler(null, null));
        assertEquals(0, spiel.zaehleSymbolFuerSpieler(null, Symbol.PAPIER));
        assertEquals(0, spiel.zaehleSymbolFuerSpieler(this.spieler.get(0), null));
        assertEquals(0, spiel.zaehleSymbolFuerSpieler(this.spieler.get(0), Symbol.PAPIER));

        assertEquals(0, spiel.gibSpielerPunkte(null));
        assertEquals(0, spiel.gibSpielerPunkte(this.spieler.get(0)));
        assertEquals(0, spiel.gibSpielerPunkte(this.spieler.get(1)));

        spiel.fuegeSpielerHinzu(this.spieler.get(0));
        spiel.starteSpiel();

        assertEquals(0, spiel.gibSpielerPunkte(null));
        assertEquals(0, spiel.zaehleSymbolFuerSpieler(null, null));
        assertEquals(0, spiel.zaehleSymbolFuerSpieler(null, Symbol.PAPIER));
        assertEquals(0, spiel.zaehleSymbolFuerSpieler(this.spieler.get(0), null));
        assertEquals(0, spiel.zaehleSymbolFuerSpieler(this.spieler.get(0), Symbol.PAPIER));

        assertEquals(0, spiel.gibSpielerPunkte(null));
        assertEquals(0, spiel.gibSpielerPunkte(this.spieler.get(0)));
        assertEquals(0, spiel.gibSpielerPunkte(this.spieler.get(1)));

        spiel.fuegeSpielerHinzu(this.spieler.get(1));
        spiel.starteSpiel();

        assertEquals(0, spiel.gibSpielerPunkte(null));
        assertEquals(0, spiel.zaehleSymbolFuerSpieler(null, null));
        assertEquals(0, spiel.zaehleSymbolFuerSpieler(null, Symbol.PAPIER));
        assertEquals(0, spiel.zaehleSymbolFuerSpieler(this.spieler.get(0), null));
        assertEquals(10, spiel.zaehleSymbolFuerSpieler(this.spieler.get(0), Symbol.PAPIER));

        assertEquals(0, spiel.zaehleSymbolFuerSpieler(this.spieler.get(1), Symbol.PAPIER));
        assertEquals(0, spiel.zaehleSymbolFuerSpieler(this.spieler.get(1), null));
        assertEquals(10, spiel.zaehleSymbolFuerSpieler(this.spieler.get(1), Symbol.STEIN));

        assertEquals(0, spiel.gibSpielerPunkte(null));
        assertEquals(10, spiel.gibSpielerPunkte(this.spieler.get(0)));
        assertEquals(0, spiel.gibSpielerPunkte(this.spieler.get(1)));

        spiel.fuegeSpielerHinzu(this.spieler.get(1));
        spiel.starteSpiel();

        assertEquals(0, spiel.gibSpielerPunkte(null));
        assertEquals(0, spiel.zaehleSymbolFuerSpieler(null, null));
        assertEquals(0, spiel.zaehleSymbolFuerSpieler(null, Symbol.PAPIER));
        assertEquals(0, spiel.zaehleSymbolFuerSpieler(this.spieler.get(0), null));
        assertEquals(10, spiel.zaehleSymbolFuerSpieler(this.spieler.get(0), Symbol.PAPIER));

        assertEquals(0, spiel.zaehleSymbolFuerSpieler(this.spieler.get(1), Symbol.PAPIER));
        assertEquals(0, spiel.zaehleSymbolFuerSpieler(this.spieler.get(1), null));
        assertEquals(10, spiel.zaehleSymbolFuerSpieler(this.spieler.get(1), Symbol.STEIN));

        assertEquals(0, spiel.gibSpielerPunkte(null));
        assertEquals(10, spiel.gibSpielerPunkte(this.spieler.get(0)));
        assertEquals(0, spiel.gibSpielerPunkte(this.spieler.get(1)));
    }
}
