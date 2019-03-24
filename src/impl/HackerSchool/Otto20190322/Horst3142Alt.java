package impl.HackerSchool.Otto20190322;

import rpsframework.basis.SteinScherePapierSpieler;
import rpsframework.basis.Symbol;

/**
 * Ein Horst3142 kann...
 *
 * ... an einem Spiel gegen einen anderen Horst3142 teilnehmen
 * ....an einem Turnier teilnehmen und dabei gegen mehrere Horst3142 ein Spiel bestreiten
 */
public class Horst3142Alt extends SteinScherePapierSpieler {

    public int runde = 1;

    /**
     * Erzeugt ein neues Objekt dieser Klasse.
     *
     * @param spielernummer Die Spielernummer des Spielers in einem Spiel bzw. Turnier. Die Spielernummer muss für jeden
     *                      Horst3142 verschieden sein.
     */
    public Horst3142Alt(int spielernummer) {

        super(spielernummer);
    }


    @Override
    public Symbol gibSymbol() {
        if (runde == 1) {
            runde = runde + 1;
            return Symbol.PAPIER;
        }
        if (runde == 2) {
            runde = runde + 1;
            return Symbol.STEIN;
        }
        if (runde == 3) {
            runde = runde + 1;
            return Symbol.PAPIER;
        }

        if (runde == 4) {
            runde = runde + 1;
            return Symbol.STEIN;
        }

        if (runde == 5) {
            runde = -6;
            return Symbol.PAPIER;
        }

            if (runde == -6) {
                runde = runde + 1;
                return Symbol.SCHERE;
            }

            if (runde == -5) {
                runde = runde + 1;
                return Symbol.STEIN;
            }
            if (runde == -4) {
                runde = runde + 1;
                return Symbol.SCHERE;
            }
            if (runde == -3) {
                runde = runde + 1;
                return Symbol.STEIN;
            }
            if (runde == -2) {
                runde = runde + 1;
                return Symbol.PAPIER;
            }
            else {
                runde = runde + 1;
                return Symbol.SCHERE;
            }
        }
    }







    // Füge hier drunter die fehlende Methode ein

