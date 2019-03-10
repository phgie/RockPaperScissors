package rpsframework.basis;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AngriffsmusterTest {

    @Test
    void bautAbwechselndesAgriffsmuster() {
        Angriffsmuster papierSchere = Angriffsmuster.zuErst(Symbol.PAPIER).dann(Symbol.SCHERE).undWiederVonVorne();

        assertEquals(Symbol.PAPIER, papierSchere.gibNaechstesSymbol(0));
        assertEquals(Symbol.SCHERE, papierSchere.gibNaechstesSymbol(1));
        // teste den Modulo-basierten Aufruf
        assertEquals(Symbol.PAPIER, papierSchere.gibNaechstesSymbol(2));
        assertEquals(Symbol.SCHERE, papierSchere.gibNaechstesSymbol(3));
    }

    @Test
    void bautWiederholendesMuster() {
        Angriffsmuster papierSchere = Angriffsmuster
                .zuErst(Symbol.PAPIER)
                .mehrmals(2)
                .dann(Symbol.SCHERE).undWiederVonVorne();

        assertEquals(Symbol.PAPIER, papierSchere.gibNaechstesSymbol(0));
        assertEquals(Symbol.PAPIER, papierSchere.gibNaechstesSymbol(1));
        assertEquals(Symbol.SCHERE, papierSchere.gibNaechstesSymbol(2));
        // teste den Modulo-basierten Aufruf
        assertEquals(Symbol.PAPIER, papierSchere.gibNaechstesSymbol(3));
        assertEquals(Symbol.PAPIER, papierSchere.gibNaechstesSymbol(4));
        assertEquals(Symbol.SCHERE, papierSchere.gibNaechstesSymbol(5));
    }

    @Test
    void bautPapierUndDannEndlosSteinMuster() {
        Angriffsmuster papierDannImmerStein = Angriffsmuster
                .zuErst(Symbol.PAPIER).dann(Symbol.STEIN).bisZumSchluss();

        assertEquals(Symbol.PAPIER, papierDannImmerStein.gibNaechstesSymbol(0));
        // "IMMER" == 1000 Runden
        for (int i = 1; i < 1000; ++i)
            assertEquals(Symbol.STEIN, papierDannImmerStein.gibNaechstesSymbol(i));
    }
}