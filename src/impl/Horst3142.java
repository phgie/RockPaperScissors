package impl;

import rpsframework.basis.SteinScherePapierSpieler;
import rpsframework.basis.Symbol;

/**
 * Ein Horst3142 kann...
 *
 * ... an einem Spiel gegen einen anderen Horst3142 teilnehmen
 * ....an einem Turnier teilnehmen und dabei gegen mehrere Horst3142 ein Spiel bestreiten
 */
public class Horst3142 extends SteinScherePapierSpieler {

    public int runde = 1;
    public Symbol letztesSymbol;
    public Symbol vorletztesSymbol;

    /**
     * Erzeugt ein neues Objekt dieser Klasse.
     *
     * @param spielernummer Die Spielernummer des Spielers in einem Spiel bzw. Turnier. Die Spielernummer muss für jeden
     *                      Horst3142 verschieden sein.
     */
    public Horst3142(int spielernummer) {

        super(spielernummer);
    }


    @Override
    public Symbol gibSymbol() {
        if(vorletztesSymbol == letztesSymbol) {
            if(vorletztesSymbol == Symbol.SCHERE) {
                return Symbol.STEIN;
            }
        }
        if(vorletztesSymbol == letztesSymbol) {
            if(vorletztesSymbol == Symbol.STEIN) {
                return Symbol.PAPIER;
            }
        }
        if(vorletztesSymbol == letztesSymbol) {
            if(vorletztesSymbol == Symbol.PAPIER) {
                return Symbol.SCHERE;
            }
        }
         if(letztesSymbol == Symbol.SCHERE) {
              return Symbol.PAPIER;
            }
         if(letztesSymbol == Symbol.PAPIER) {
             return Symbol.STEIN;
         }
         if(letztesSymbol == Symbol.STEIN) {
             return Symbol.SCHERE;
         }
            else {
                runde = runde + 1;
                return Symbol.SCHERE;
            }
        }

        @Override
        public void nimmGegnerSymbol(Symbol symbol, int runde) {
           vorletztesSymbol = letztesSymbol;
           letztesSymbol = symbol;
        }


    }







    // Füge hier drunter die fehlende Methode ein

