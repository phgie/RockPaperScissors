package test.rpsframework.basis;

import org.junit.jupiter.api.Test;
import rpsframework.basis.SteinScherePapierSpieler;
import rpsframework.basis.Symbol;
import rpsframework.strategie.Angriffsmuster;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SteinScherePapierSpielerTest {

    @Test
    void spieltImmerPapier_mitFestemSymbol() {
        TestSpieler spieler = new TestSpieler(0, Symbol.PAPIER);

        // "IMMER" == 1000 Runden lang
        for (int i = 0; i < 1000; ++i)
            assertEquals(Symbol.PAPIER, spieler.gibSymbol(), "Fehler in Runde " + i);
    }

    @Test
    void spieltImmerPapier_mitAngriffsmuster() {
        TestSpieler spieler = new TestSpieler(0, Angriffsmuster.zuErst(Symbol.PAPIER).undWiederVonVorne());

        // "IMMER" == 1000 Runden lang
        for (int i = 0; i < 1000; ++i)
            assertEquals(Symbol.PAPIER, spieler.gibSymbol(), "Fehler in Runde " + i);
    }

    @Test
    void spieltImmerAbwechselndSchereSteinPapier() {
        TestSpieler spieler = new TestSpieler(0, Angriffsmuster
                .zuErst(Symbol.SCHERE)
                .dann(Symbol.STEIN)
                .dann(Symbol.PAPIER).undWiederVonVorne());

        // "IMMER" == 1000 Runden lang
        for (int i = 0; i < 1000; ++i)
            if (i % 3 == 0)
                assertEquals(Symbol.SCHERE, spieler.gibSymbol());
            else if (i % 3 == 1)
                assertEquals(Symbol.STEIN, spieler.gibSymbol());
            else
                assertEquals(Symbol.PAPIER, spieler.gibSymbol());
    }

    public class TestSpieler extends SteinScherePapierSpieler {
        Symbol zuSpielendesSymbol;

        int rundenZaehler = 0;
        Angriffsmuster angriffsmuster;

        TestSpieler(int spielernummer, Symbol symbol) {
            super(spielernummer);
            zuSpielendesSymbol = symbol;
        }

        TestSpieler(int spielernummer, Angriffsmuster angriffsmuster) {
            super(spielernummer);
            this.angriffsmuster = angriffsmuster;
        }

        @Override
        public Symbol gibSymbol() {
            if (zuSpielendesSymbol != null)
                return zuSpielendesSymbol;

            return angriffsmuster.gibNaechstesSymbol(rundenZaehler++);
        }

        @Override
        public void starteNeuesSpiel(int runden) {

        }

        @Override
        public void nimmGegnerSymbol(Symbol symbol, int runde) {

        }
    }
}