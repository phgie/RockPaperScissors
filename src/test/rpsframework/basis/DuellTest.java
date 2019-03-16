package test.rpsframework.basis;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import rpsframework.basis.SteinScherePapierSpieler;
import rpsframework.basis.Symbol;
import rpsframework.basis.Duell;
import rpsframework.turnier.SpielerMock;

class DuellTest {

    private Duell duell;
    private SteinScherePapierSpieler spieler1;
    private SteinScherePapierSpieler spieler2;

    @BeforeEach
    void setUp() {

        this.duell = new Duell();
        this.spieler1 = new SpielerMock(1);
        this.spieler2 = new SpielerMock(2);
    }

    @Test
    void papierBesiegtStein() {

        duell.fuegeSpielerSymbolHinzu(spieler1, Symbol.STEIN);
        duell.fuegeSpielerSymbolHinzu(spieler2, Symbol.PAPIER);

        Assertions.assertEquals(duell.gibGewinner(), spieler2);
        Assertions.assertNotEquals(duell.gibGewinner(), spieler1);
        Assertions.assertNotEquals(duell.gibGewinner(), null);
    }

    @Test
    void steinBesiegtSchere() {

        duell.fuegeSpielerSymbolHinzu(spieler1, Symbol.STEIN);
        duell.fuegeSpielerSymbolHinzu(spieler2, Symbol.SCHERE);

        Assertions.assertEquals(duell.gibGewinner(), spieler1);
        Assertions.assertNotEquals(duell.gibGewinner(), spieler2);
        Assertions.assertNotEquals(duell.gibGewinner(), null);
    }

    @Test
    void schereBesiegtPapier() {

        duell.fuegeSpielerSymbolHinzu(spieler1, Symbol.PAPIER);
        duell.fuegeSpielerSymbolHinzu(spieler2, Symbol.SCHERE);

        Assertions.assertEquals(duell.gibGewinner(), spieler2);
        Assertions.assertNotEquals(duell.gibGewinner(), spieler1);
        Assertions.assertNotEquals(duell.gibGewinner(), null);
    }

    @Test
    void testAufUnentschieden() {

        duell.fuegeSpielerSymbolHinzu(spieler1, Symbol.STEIN);
        duell.fuegeSpielerSymbolHinzu(spieler2, Symbol.STEIN);

        Assertions.assertNull(duell.gibGewinner());
        Assertions.assertNotEquals(duell.gibGewinner(), spieler2);
        Assertions.assertNotEquals(duell.gibGewinner(), spieler1);
    }
}