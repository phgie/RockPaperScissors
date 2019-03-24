package test.rpsframework.basis;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import rpsframework.basis.Duell;
import rpsframework.basis.SteinScherePapierSpieler;
import rpsframework.basis.Symbol;
import test.rpsframework.mocks.SpielerMock;

import static org.junit.jupiter.api.Assertions.*;

class DuellTest {

    private Duell duell;
    private SteinScherePapierSpieler spieler1;
    private SteinScherePapierSpieler spieler2;

    @BeforeEach
    void setUp() {

        this.duell = new Duell();
    }

    @Test
    void testFuegeSpielerHinzu() {

        this.spieler1 = new SpielerMock(1, Symbol.SCHERE);
        this.spieler2 = new SpielerMock(2, Symbol.PAPIER);

        assertNull(this.duell.gibSpielerSymbol(spieler1));
        assertNull(this.duell.gibGewinner());

        this.duell.fuegeSpielerSymbolHinzu(null, null);

        assertNull(this.duell.gibSpielerSymbol(spieler1));
        assertNull(this.duell.gibGewinner());

        this.duell.fuegeSpielerSymbolHinzu(null, Symbol.PAPIER);

        assertNull(this.duell.gibSpielerSymbol(spieler1));
        assertNull(this.duell.gibGewinner());

        this.duell.fuegeSpielerSymbolHinzu(this.spieler1, null);

        assertNull(this.duell.gibSpielerSymbol(spieler1));
        assertEquals(this.spieler1, this.duell.gibGewinner());

        this.duell.fuegeSpielerSymbolHinzu(this.spieler2, this.spieler2.gibSymbol());

        assertEquals(this.spieler2.gibSymbol(), this.duell.gibSpielerSymbol(spieler2));
        assertEquals(this.spieler2, this.duell.gibGewinner());

        this.duell.fuegeSpielerSymbolHinzu(this.spieler1, this.spieler1.gibSymbol());

        assertNull(this.duell.gibSpielerSymbol(spieler1));
        assertEquals(this.spieler2, this.duell.gibGewinner());
    }

    @Test
    void testGibGewinner() {

        this.spieler1 = new SpielerMock(1, Symbol.STEIN);
        this.spieler2 = new SpielerMock(2, Symbol.PAPIER);

        assertNull(duell.gibGewinner());

        duell.fuegeSpielerSymbolHinzu(this.spieler1, spieler1.gibSymbol());

        assertEquals(this.spieler1, duell.gibGewinner());

        duell.fuegeSpielerSymbolHinzu(this.spieler2, spieler2.gibSymbol());

        assertEquals(this.spieler2, duell.gibGewinner());
    }

    @Test
    void papierBesiegtStein() {

        this.spieler1 = new SpielerMock(1, Symbol.STEIN);
        this.spieler2 = new SpielerMock(2, Symbol.PAPIER);

        duell.fuegeSpielerSymbolHinzu(spieler1, spieler1.gibSymbol());
        duell.fuegeSpielerSymbolHinzu(spieler2, spieler2.gibSymbol());

        assertEquals(duell.gibGewinner(), spieler2);
        assertNotEquals(duell.gibGewinner(), spieler1);
        assertNotEquals(duell.gibGewinner(), null);
    }

    @Test
    void steinBesiegtSchere() {

        this.spieler1 = new SpielerMock(1, Symbol.STEIN);
        this.spieler2 = new SpielerMock(2, Symbol.SCHERE);

        duell.fuegeSpielerSymbolHinzu(spieler1, spieler1.gibSymbol());
        duell.fuegeSpielerSymbolHinzu(spieler2, spieler2.gibSymbol());

        assertEquals(duell.gibGewinner(), spieler1);
        assertNotEquals(duell.gibGewinner(), spieler2);
        assertNotEquals(duell.gibGewinner(), null);
    }

    @Test
    void schereBesiegtPapier() {

        this.spieler1 = new SpielerMock(1, Symbol.PAPIER);
        this.spieler2 = new SpielerMock(2, Symbol.SCHERE);

        duell.fuegeSpielerSymbolHinzu(spieler1, spieler1.gibSymbol());
        duell.fuegeSpielerSymbolHinzu(spieler2, spieler2.gibSymbol());

        assertEquals(duell.gibGewinner(), spieler2);
        assertNotEquals(duell.gibGewinner(), spieler1);
        assertNotEquals(duell.gibGewinner(), null);
    }

    @Test
    void testAufUnentschieden() {

        this.spieler1 = new SpielerMock(1, Symbol.STEIN);
        this.spieler2 = new SpielerMock(2, Symbol.STEIN);

        duell.fuegeSpielerSymbolHinzu(spieler1, spieler1.gibSymbol());
        duell.fuegeSpielerSymbolHinzu(spieler2, spieler2.gibSymbol());

        assertNull(duell.gibGewinner());
        assertNotEquals(duell.gibGewinner(), spieler2);
        assertNotEquals(duell.gibGewinner(), spieler1);
    }
}