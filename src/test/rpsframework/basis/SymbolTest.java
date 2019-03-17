package test.rpsframework.basis;

import org.junit.jupiter.api.Test;
import rpsframework.basis.Symbol;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SymbolTest {

    @Test
    void testSymbolEinsSchlaegtSymbolZwei() {

        assertTrue(Symbol.symbolEinsSchlaegtSymbolZwei(Symbol.PAPIER, Symbol.STEIN));
        assertTrue(Symbol.symbolEinsSchlaegtSymbolZwei(Symbol.STEIN, Symbol.SCHERE));
        assertTrue(Symbol.symbolEinsSchlaegtSymbolZwei(Symbol.SCHERE, Symbol.PAPIER));

        assertFalse(Symbol.symbolEinsSchlaegtSymbolZwei(Symbol.STEIN, Symbol.PAPIER));
        assertFalse(Symbol.symbolEinsSchlaegtSymbolZwei(Symbol.SCHERE, Symbol.STEIN));
        assertFalse(Symbol.symbolEinsSchlaegtSymbolZwei(Symbol.PAPIER, Symbol.SCHERE));

        assertFalse(Symbol.symbolEinsSchlaegtSymbolZwei(Symbol.PAPIER, Symbol.PAPIER));
        assertFalse(Symbol.symbolEinsSchlaegtSymbolZwei(Symbol.STEIN, Symbol.STEIN));
        assertFalse(Symbol.symbolEinsSchlaegtSymbolZwei(Symbol.SCHERE, Symbol.SCHERE));

        assertFalse(Symbol.symbolEinsSchlaegtSymbolZwei(null, null));
    }
}
