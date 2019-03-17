package test.rpsframework.basis;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import rpsframework.basis.Duell;
import rpsframework.basis.SteinScherePapierSpieler;
import rpsframework.basis.Symbol;
import test.rpsframework.mocks.SpielerMock;

class DuellTest {

    private Duell duell;
    private SteinScherePapierSpieler spieler1;
    private SteinScherePapierSpieler spieler2;

    @BeforeEach
    void setUp() {

        this.duell = new Duell();
    }

    @Test
    void papierBesiegtStein() {

        this.spieler1 = new SpielerMock(1, Symbol.STEIN);
        this.spieler2 = new SpielerMock(2, Symbol.PAPIER);

        duell.fuegeSpielerSymbolHinzu(spieler1, spieler1.gibSymbol());
        duell.fuegeSpielerSymbolHinzu(spieler2, spieler2.gibSymbol());

        Assertions.assertEquals(duell.gibGewinner(), spieler2);
        Assertions.assertNotEquals(duell.gibGewinner(), spieler1);
        Assertions.assertNotEquals(duell.gibGewinner(), null);
    }

    @Test
    void steinBesiegtSchere() {

        this.spieler1 = new SpielerMock(1, Symbol.STEIN);
        this.spieler2 = new SpielerMock(2, Symbol.SCHERE);

        duell.fuegeSpielerSymbolHinzu(spieler1, spieler1.gibSymbol());
        duell.fuegeSpielerSymbolHinzu(spieler2, spieler2.gibSymbol());

        Assertions.assertEquals(duell.gibGewinner(), spieler1);
        Assertions.assertNotEquals(duell.gibGewinner(), spieler2);
        Assertions.assertNotEquals(duell.gibGewinner(), null);
    }

    @Test
    void schereBesiegtPapier() {

        this.spieler1 = new SpielerMock(1, Symbol.PAPIER);
        this.spieler2 = new SpielerMock(2, Symbol.SCHERE);

        duell.fuegeSpielerSymbolHinzu(spieler1, spieler1.gibSymbol());
        duell.fuegeSpielerSymbolHinzu(spieler2, spieler2.gibSymbol());

        Assertions.assertEquals(duell.gibGewinner(), spieler2);
        Assertions.assertNotEquals(duell.gibGewinner(), spieler1);
        Assertions.assertNotEquals(duell.gibGewinner(), null);
    }

    @Test
    void testAufUnentschieden() {

        this.spieler1 = new SpielerMock(1, Symbol.STEIN);
        this.spieler2 = new SpielerMock(2, Symbol.STEIN);

        duell.fuegeSpielerSymbolHinzu(spieler1, spieler1.gibSymbol());
        duell.fuegeSpielerSymbolHinzu(spieler2, spieler2.gibSymbol());

        Assertions.assertNull(duell.gibGewinner());
        Assertions.assertNotEquals(duell.gibGewinner(), spieler2);
        Assertions.assertNotEquals(duell.gibGewinner(), spieler1);
    }
}