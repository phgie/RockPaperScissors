package test.rpsframework.turnier;

import org.junit.jupiter.api.Test;
import rpsframework.basis.SteinScherePapierSpieler;
import rpsframework.basis.Symbol;
import rpsframework.strategie.Angriffsmuster;
import rpsframework.turnier.Duell;
import rpsframework.turnier.Turnier;

import static org.junit.jupiter.api.Assertions.*;

public class TurnierTest {

    @Test
    void testeTeilnehmerHinzufuegen() {

        Turnier turnier = new Turnier();


        turnier.fuegeTeilnehmerHinzu(new TestSpieler(Symbol.STEIN));
        turnier.fuegeTeilnehmerHinzu(new TestSpieler(Symbol.PAPIER));
        turnier.starteTurnier();

        //TODO broken: assertEquals("PAPIER Spieler", turnier.ermittleGesamtGewinner().getName());
    }

    @Test
    void keinGewinnerWennAlleSpielerDieselbePunktzahlHaben() {

        Turnier turnier = new Turnier();
        turnier.fuegeTeilnehmerHinzu(new TestSpieler(Symbol.STEIN));
        turnier.fuegeTeilnehmerHinzu(new TestSpieler(Symbol.PAPIER));
        turnier.fuegeTeilnehmerHinzu(new TestSpieler(Symbol.SCHERE));
        turnier.starteTurnier();

        //TODO broken: assertNull(turnier.ermittleGesamtGewinner());
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
            if (zuSpielendesSymbol != null)
                return zuSpielendesSymbol.toString();
            return this.angriffsmuster.toString();
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
