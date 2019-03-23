package impl;

import rpsframework.basis.SteinScherePapierSpieler;
import rpsframework.basis.Symbol;

/**
 * Ein Spieler kann...
 *
 * ... an einem Spiel gegen einen anderen Spieler teilnehmen
 * ....an einem Turnier teilnehmen und dabei gegen mehrere Spieler ein Spiel bestreiten
 */
public class SimonAlt extends SteinScherePapierSpieler {

    int zahl = 0;
    /**
     * Erzeugt ein neues Objekt dieser Klasse.
     *
     * @param spielernummer Die Spielernummer des Spielers in einem Spiel bzw. Turnier. Die Spielernummer muss für jeden
     *                      Spieler verschieden sein.
     */
    public SimonAlt(int spielernummer) {

        super(spielernummer);
    }



    @Override
    public Symbol gibSymbol() {
   zahl=zahl +1;
   if (zahl == 5) {

       zahl = 0;
   }

        if (zahl == 1) {
            return Symbol.PAPIER;
        } if(zahl ==3) {
            return Symbol.SCHERE;
        }

        else {
         return Symbol.STEIN;
        }

        // Füge hier drunter die fehlende Methode ein
    }
}