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
    private Symbol spielerEinsSymbol;
    private Symbol spielerZweiSymbol;

    /**
     * Erzeugt ein neues Duell mit den zwei gegebenen Spielersymbolen. Die Symbole sollten nicht leer sein.
     * @param spielerEinsSymbol Das Symbol von Spieler 1, Objekt Enum-Klasse Symbol
     * @param spielerZweiSymbol Das Symbol von Spieler 2, Objekt Enum-Klasse Symbol
     */
    public Duell(Symbol spielerEinsSymbol, Symbol spielerZweiSymbol) {

        this.spielerEinsSymbol = spielerEinsSymbol;
        this.spielerZweiSymbol = spielerZweiSymbol;
    }

    /**
     * Gibt das von Spieler 1 gewählte Symbol zurück.
     * @return Ein Symbol der Klasse Symbol.
     */
    public Symbol gibSpielerEinsSymbol() {

        return this.spielerEinsSymbol;
    }

    /**
     * Gibt das von Spieler 2 gewählte Symbol zurück.
     * @return Ein Symbol der Klasse Symbol.
     */
    public Symbol gibSpielerZweiSymbol() {

        return this.spielerZweiSymbol;
    }

    /**
     * Gibt das Ergebnis des Duells zurück.
     * @return 1, falls Spieler 1 gewinnt, 2, falls Spieler gewinnt, 0 bei unentschieden.
     */
    public int gibErgebnis() {

        int ergebnis;

        if (Symbol.symbolEinsSchlaegtSymbolZwei(spielerEinsSymbol, spielerZweiSymbol)) {

            // Spieler 1 gewinnt
            ergebnis = rueckgabewertSpielerEinsGewinnt;
        } else if (Symbol.symbolEinsSchlaegtSymbolZwei(spielerZweiSymbol, spielerEinsSymbol)) {

            // Spieler 2 gewinnt
            ergebnis = rueckgabewertSpielerZweiGewinnt;
        } else {

            // Unentschieden
            ergebnis = rueckgabewertUnentschieden;
        }

        //TODO REMOVE
        System.out.println("Duell: " + spielerEinsSymbol + " vs. " + spielerZweiSymbol);

        return ergebnis;
    }
}
