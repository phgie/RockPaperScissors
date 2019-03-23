package impl;

import rpsframework.basis.SteinScherePapierSpieler;
import rpsframework.basis.Symbol;

/**
 * Ein Spieler kann...
 *
 * ... an einem Spiel gegen einen anderen Spieler teilnehmen
 * ....an einem Turnier teilnehmen und dabei gegen mehrere Spieler ein Spiel bestreiten
 */
public class Spieler extends SteinScherePapierSpieler {

    int zahl = 0;

    /**
     * Erzeugt ein neues Objekt dieser Klasse.
     * @param spielernummer Die Spielernummer des Spielers in einem Spiel bzw. Turnier. Die Spielernummer muss für jeden
     *                      Spieler verschieden sein.
     */
    public Spieler(int spielernummer) {

        super(spielernummer);
    }

    @Override
    public Symbol gibSymbol() {

        if(zahl == 1) {
            return Symbol.STEIN;
        }
        else {
            return Symbol.SCHERE;
        }
    }
}
