package rpsframework.turnier;

import impl.Spieler;
import rpsframework.basis.Duell;
import rpsframework.basis.Symbol;

/**
 * Ein Spiel ist eine Begegnung zwischen zwei Spielern und laeuft ueber eine vorgegebene Zahl von Runden. Jede Runde ist
 * ein Duell, dessen Ausgang abgefragt werden kann
 */
public class Spiel {

    private Spieler spieler1;
    private Spieler spieler2;

    /* Die Duelle in diesem Spiel. Die Anzahl von Runden bestimmt die Laenge des Arrays */
    private Duell[] duelle;

    private int spieler1siege;
    private int spieler2siege;
    private int unentschieden;


    public Spiel(Spieler spieler1, Spieler spieler2, int runden) {

        this.spieler1 = spieler1;
        this.spieler2 = spieler2;

        this.duelle = new Duell[runden];
    }

    /**
     * Startet das Spiel und loest die einzelnen Begegnungen aus
     */
    public void starteSpiel() {

        Symbol spieler1symbol;
        Symbol spieler2symbol;

        for (int i = 0; i < duelle.length; i++) {

            spieler1symbol = spieler1.gibSymbol();
            spieler2symbol = spieler2.gibSymbol();

            duelle[i] = new Duell(spieler1symbol, spieler2symbol);

            switch (duelle[i].gibErgebnis()) {

                case -1:
                    //Spieler 2 gewinnt
                    spieler2siege++;
                    break;
                case 0:
                    //unentschieden
                    unentschieden++;
                    break;
                case 1:
                    //Spieler 1 gewinnt
                    spieler1siege++;
            }
        }
    }

    /**
     * Gibt das Ergebnis für einen Spieler zurück.
     * @param spieler
     * @return
     */
    public int gibErgebnis(Spieler spieler) {

        if (spieler == null) {

            return unentschieden;
        } else if (spieler.equals(spieler2)) {

            return spieler2siege
        } else if (spieler.equals(spieler1)) {

            return spieler1siege;
        }
    }
}
