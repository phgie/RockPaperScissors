package test.rpsframework.basis;

import org.junit.jupiter.api.Test;
import rpsframework.basis.SteinScherePapierSpieler;
import rpsframework.basis.Symbol;
import rpsframework.strategie.Angriffsmuster;
import rpsframework.turnier.Duell;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SteinScherePapierSpielerTest {

    @Test
    void spieltImmerPapier_mitFestemSymbol() {
        TestSpieler spieler = new TestSpieler(Symbol.PAPIER);

        // "IMMER" == 1000 Runden lang
        for (int i = 0; i < 1000; ++i)
            assertEquals(Symbol.PAPIER, spieler.gibSymbol(), "Fehler in Runde " + i);
    }

    @Test
    void spieltImmerPapier_mitAngriffsmuster() {
        TestSpieler spieler = new TestSpieler(Angriffsmuster.zuErst(Symbol.PAPIER).undWiederVonVorne());

        // "IMMER" == 1000 Runden lang
        for (int i = 0; i < 1000; ++i)
            assertEquals(Symbol.PAPIER, spieler.gibSymbol(), "Fehler in Runde " + i);
    }

    @Test
    void spieltImmerAbwechselndSchereSteinPapier() {
        TestSpieler spieler = new TestSpieler(Angriffsmuster
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

    public class TestSpieler implements SteinScherePapierSpieler {
        Symbol zuSpielendesSymbol;

        int rundenZaehler = 0;
        Angriffsmuster angriffsmuster;

        TestSpieler(Symbol symbol) {
            zuSpielendesSymbol = symbol;
        }

        TestSpieler(Angriffsmuster angriffsmuster) {
            this.angriffsmuster = angriffsmuster;
        }

        @Override
        public String getName() {
            return null;
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
        public void nimmDuell(Duell duell, int runde) {

        }
    }
}