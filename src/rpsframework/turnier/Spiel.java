package rpsframework.turnier;

import rpsframework.basis.SteinScherePapierSpieler;
import rpsframework.basis.Symbol;

/**
 * Ein Spiel ist eine Begegnung zwischen zwei Spielern und laeuft ueber eine vorgegebene Zahl von Runden. Jede Runde ist
 * ein Duell, dessen Ausgang abgefragt werden kann
 */
class Spiel {

    private SteinScherePapierSpieler spieler1;
    private SteinScherePapierSpieler spieler2;

    /* Die Duelle in diesem Spiel. Die Anzahl von Runden bestimmt die Laenge des Arrays */
    private Duell[] duelle;

    private int spieler1siege;
    private int spieler2siege;
    private int unentschieden;


    Spiel(SteinScherePapierSpieler spieler1, SteinScherePapierSpieler spieler2, int runden) {

        this.spieler1 = spieler1;
        this.spieler2 = spieler2;

        this.duelle = new Duell[runden];

        spieler1.vorbereitenAufNeuesSpiel();
        spieler2.vorbereitenAufNeuesSpiel();
    }

    /**
     * Startet das Spiel und loest die einzelnen Begegnungen aus
     */
    void starteSpiel() {

        Symbol spieler1symbol;
        Symbol spieler2symbol;

        for (int i = 0; i < duelle.length; i++) {

            spieler1symbol = spieler1.gibSymbol();
            spieler2symbol = spieler2.gibSymbol();

            duelle[i] = new Duell(spieler1symbol, spieler2symbol);

            switch (duelle[i].gibErgebnis()) {

                case Duell.rueckgabewertSpielerEinsGewinnt:
                    // Spieler 1 gewinnt
                    spieler1siege++;
                    break;
                case Duell.rueckgabewertSpielerZweiGewinnt:
                    // Spieler 2 gewinnt
                    spieler2siege++;
                    break;
                case Duell.rueckgabewertUnentschieden:
                    // Unentschieden
                    unentschieden++;
            }
        }
    }

    SteinScherePapierSpieler gibGewinner() {

        return spieler1siege > spieler2siege
                ? spieler1
                : spieler2siege > spieler1siege
                    ? spieler2
                    : null;
    }
}
