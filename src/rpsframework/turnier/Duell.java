package rpsframework.turnier;

import rpsframework.basis.Symbol;

/**
 * Ein Duell ist ein einzelnes Aufeinandertreffen zweier Spielersymbole. In einem Duell wird ein Gewinner (falls es einen gibt) ermittelt.
 */
public class Duell {

    /* Rückgabewerte für die Gewinnfälle. */
    public static final int rueckgabewertSpielerEinsGewinnt = 1;
    public static final int rueckgabewertSpielerZweiGewinnt = 2;
    public static final int rueckgabewertUnentschieden = 0;

    /* Die von den Spielern in diesem einen Duell gespielten Symbole */
    private Symbol spieler1Symbol;
    private Symbol spieler2Symbol;

    /**
     * Erzeugt ein neues Duell mit den zwei gegebenen Spielersymbolen. Die Symbole sollten nicht leer sein.
     * @param spieler1Symbol Das Symbol von Spieler 1, Objekt Enum-Klasse Symbol
     * @param spieler2Symbol Das Symbol von Spieler 2, Objekt Enum-Klasse Symbol
     */
    public Duell(Symbol spieler1Symbol, Symbol spieler2Symbol) {

        this.spieler1Symbol = spieler1Symbol;
        this.spieler2Symbol = spieler2Symbol;
    }

    /**
     * Gibt das Ergebnis des Duells zurück.
     * @return 1, falls Spieler 1 gewinnt, 2, falls Spieler gewinnt, 0 bei unentschieden.
     */
    public int gibErgebnis() {

        int ergebnis;

        if (Symbol.symbolEinsSchlaegtSymbolZwei(spieler1Symbol, spieler2Symbol)) {

            // Spieler 1 gewinnt
            ergebnis = rueckgabewertSpielerEinsGewinnt;
        } else if (Symbol.symbolEinsSchlaegtSymbolZwei(spieler2Symbol, spieler1Symbol)) {

            // Spieler 2 gewinnt
            ergebnis = rueckgabewertSpielerZweiGewinnt;
        } else {

            // Unentschieden
            ergebnis = rueckgabewertUnentschieden;
        }

        return ergebnis;
    }
}
