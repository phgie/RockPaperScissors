package rpsframework.basis;

import static rpsframework.basis.Symbol.*;

/**
 * Ein Duell ist ein einzelnes Aufeinandertreffen zweier Spielersymbole. In einem Duell wird ein Gewinner (falls es einen gibt) ermittelt.
 */
public class Duell {

    private Symbol spieler1Symbol;
    private Symbol spieler2Symbol;

    public Duell(Symbol spieler1Symbol, Symbol spieler2Symbol) {
        this.spieler1Symbol = spieler1Symbol;
        this.spieler2Symbol = spieler2Symbol;
    }

    public int gibErgebnis() {
        if (spieler1Symbol.equals(STEIN) && spieler2Symbol.equals(PAPIER))
            return 1;
        if (spieler1Symbol.equals(STEIN) && spieler2Symbol.equals(SCHERE))
            return -1;
        if (spieler1Symbol.equals(PAPIER) && spieler2Symbol.equals(STEIN))
            return 1;
        if (spieler1Symbol.equals(PAPIER) && spieler2Symbol.equals(SCHERE))
            return -1;
        if (spieler1Symbol.equals(SCHERE) && spieler2Symbol.equals(STEIN))
            return 1;
        if (spieler1Symbol.equals(SCHERE) && spieler2Symbol.equals(PAPIER))
            return -1;

        return 0;
    }
}
