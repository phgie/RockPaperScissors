package test.rpsframework.basis;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import rpsframework.turnier.Duell;
import rpsframework.basis.Symbol;

class DuellTest {

    @Test
    void papierBesiegtStein() {

        Assertions.assertEquals(Duell.rueckgabewertSpielerEinsGewinnt, new Duell(Symbol.PAPIER, Symbol.STEIN).gibErgebnis());
        Assertions.assertEquals(Duell.rueckgabewertSpielerZweiGewinnt, new Duell(Symbol.STEIN, Symbol.PAPIER).gibErgebnis());
    }

    @Test
    void steinBesiegtSchere() {

        Assertions.assertEquals(Duell.rueckgabewertSpielerEinsGewinnt, new Duell(Symbol.STEIN, Symbol.SCHERE).gibErgebnis());
        Assertions.assertEquals(Duell.rueckgabewertSpielerZweiGewinnt, new Duell(Symbol.SCHERE, Symbol.STEIN).gibErgebnis());
    }

    @Test
    void schereBesiegtPapier() {

        Assertions.assertEquals(Duell.rueckgabewertSpielerEinsGewinnt, new Duell(Symbol.SCHERE, Symbol.PAPIER).gibErgebnis());
        Assertions.assertEquals(Duell.rueckgabewertSpielerZweiGewinnt, new Duell(Symbol.PAPIER, Symbol.SCHERE).gibErgebnis());
    }

    @Test
    void testAufUnentschieden() {

        Assertions.assertEquals(Duell.rueckgabewertUnentschieden, new Duell(Symbol.SCHERE, Symbol.SCHERE).gibErgebnis());
        Assertions.assertEquals(Duell.rueckgabewertUnentschieden, new Duell(Symbol.PAPIER, Symbol.PAPIER).gibErgebnis());
        Assertions.assertEquals(Duell.rueckgabewertUnentschieden, new Duell(Symbol.STEIN, Symbol.STEIN).gibErgebnis());
    }
}