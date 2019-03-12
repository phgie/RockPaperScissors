import org.junit.jupiter.api.Test;
import rpsframework.basis.SteinScherePapierSpieler;
import rpsframework.basis.Symbol;
import rpsframework.turnier.Turnier;

import static org.junit.jupiter.api.Assertions.*;

class TurnierTest extends Turnier {

    @Test
    void PAPIERSpielerGewinntGegenSteinSpieler() {

        Turnier turnier = new Turnier();
        turnier.fuegeTeilnehmerHinzu(new TestSpieler(Symbol.STEIN), new TestSpieler(Symbol.PAPIER));
        turnier.starteTurnier();

        assertEquals("PAPIER Spieler", turnier.ermittleGesamtGewinner().getName());
    }

    @Test
    void keinGewinnerWennAlleSpielerDieselbePunktzahlHaben() {

        Turnier turnier = new Turnier();
        turnier.fuegeTeilnehmerHinzu(new TestSpieler(Symbol.STEIN), new TestSpieler(Symbol.PAPIER), new TestSpieler(Symbol.SCHERE));
        turnier.starteTurnier();

        assertNull(turnier.ermittleGesamtGewinner());
    }

    class TestSpieler implements SteinScherePapierSpieler {
        Symbol symbol;

        int bisherGespieltRunden = 0;

        TestSpieler(Symbol symbol) {
            this.symbol = symbol;
        }

        @Override
        public String getName() {
            return symbol.toString() + " Spieler";
        }

        @Override
        public Symbol gibSymbol() {
            bisherGespieltRunden++;
            return symbol;
        }

        @Override
        public void vorbereitenAufNeuesSpiel() {

        }
    }
}
