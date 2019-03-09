package rpsframework.turnier;

import org.junit.jupiter.api.Test;
import rpsframework.basis.SteinScherePapierSpieler;
import rpsframework.basis.Symbol;

import static org.junit.jupiter.api.Assertions.*;

class TurnierTest extends Turnier {

    @Test
    void steinGegenSchereGegenPapier() {

        Turnier turnier = new Turnier();
        turnier.fuegeTeilnehmerHinzu(new TestSpieler(Symbol.STEIN), new TestSpieler(Symbol.PAPIER));
        turnier.starteTurnier();

        assertEquals("PAPIER Spieler", turnier.ermittleGesamtGewinner().getName());
    }

    class TestSpieler implements SteinScherePapierSpieler {
        Symbol symbol;

        TestSpieler(Symbol symbol) {
            this.symbol = symbol;
        }

        @Override
        public String getName() {
            return symbol.toString() + " Spisler";
        }

        @Override
        public Symbol gibSymbol() {
            return null;
        }

        @Override
        public void vorbereitenAufNeuesSpiel() {

        }
    }
}
