package test.rpsframework.basis;

import org.junit.jupiter.api.Test;
import rpsframework.basis.Symbol;

class SymbolTest {

    @Test
    void testSymbolEinsSchlaegtSymbolZwei() {

        assert(Symbol.symbolEinsSchlaegtSymbolZwei(Symbol.PAPIER, Symbol.STEIN));
        assert(Symbol.symbolEinsSchlaegtSymbolZwei(Symbol.STEIN, Symbol.SCHERE));
        assert(Symbol.symbolEinsSchlaegtSymbolZwei(Symbol.SCHERE, Symbol.PAPIER));

        assert(!Symbol.symbolEinsSchlaegtSymbolZwei(Symbol.STEIN, Symbol.PAPIER));
        assert(!Symbol.symbolEinsSchlaegtSymbolZwei(Symbol.SCHERE, Symbol.STEIN));
        assert(!Symbol.symbolEinsSchlaegtSymbolZwei(Symbol.PAPIER, Symbol.SCHERE));

        assert(!Symbol.symbolEinsSchlaegtSymbolZwei(Symbol.PAPIER, Symbol.PAPIER));
        assert(!Symbol.symbolEinsSchlaegtSymbolZwei(Symbol.STEIN, Symbol.STEIN));
        assert(!Symbol.symbolEinsSchlaegtSymbolZwei(Symbol.SCHERE, Symbol.SCHERE));

        assert(!Symbol.symbolEinsSchlaegtSymbolZwei(null, null));
    }
}
