package rpsframework.basis;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import rpsframework.basis.Duell;
import rpsframework.basis.Symbol;

import static org.junit.jupiter.api.Assertions.*;

class DuellTest {

    @Test
    void papierBesiegtStein() {
        Assertions.assertEquals(1, new Duell(Symbol.PAPIER, Symbol.STEIN).gibErgebnis());
        assertEquals(-1, new Duell(Symbol.STEIN, Symbol.PAPIER).gibErgebnis());
    }

    @Test
    void steinBesiegtSchere() {
        Assertions.assertEquals(1, new Duell(Symbol.STEIN, Symbol.SCHERE).gibErgebnis());
        assertEquals(-1, new Duell(Symbol.SCHERE, Symbol.STEIN).gibErgebnis());
    }

    @Test
    void schereBesiegtPapier() {
        Assertions.assertEquals(1, new Duell(Symbol.SCHERE, Symbol.PAPIER).gibErgebnis());
        assertEquals(-1, new Duell(Symbol.PAPIER, Symbol.SCHERE).gibErgebnis());
    }
}