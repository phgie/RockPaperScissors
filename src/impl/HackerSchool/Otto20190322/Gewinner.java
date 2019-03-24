package impl.HackerSchool.Otto20190322;

import rpsframework.basis.SteinScherePapierSpieler;
import rpsframework.basis.Symbol;

/**
 * Ein Spieler kann...
 *
 * ... an einem Spiel gegen einen anderen Spieler teilnehmen
 * ....an einem Turnier teilnehmen und dabei gegen mehrere Spieler ein Spiel bestreiten
 */
public class Gewinner extends SteinScherePapierSpieler {

    int zahl = 0;
    Symbol gegnerSymbol = Symbol.SCHERE;

    /**
     * Erzeugt ein neues Objekt dieser Klasse.
     *
     * @param spielernummer Die Spielernummer des Spielers in einem Spiel bzw. Turnier. Die Spielernummer muss für jeden
     *                      Spieler verschieden sein.
     */
    public Gewinner(int spielernummer) {

        super(spielernummer);
    }

    @Override
    public Symbol gibSymbol() {

        if (gegnerSymbol == Symbol.STEIN) {
            return Symbol.PAPIER;
        }

        if (gegnerSymbol == Symbol.PAPIER) {
            return Symbol.SCHERE;
        }

        if (gegnerSymbol == Symbol.SCHERE) {
                        return Symbol.STEIN;

        } else {
            return Symbol.SCHERE;
        }
//
//
//
//        zahl = zahl + 1;
//
//        if (zahl == 1) {
//            return Symbol.PAPIER;
//        } else if (zahl == 2) {
//            return Symbol.STEIN;
//        } else if (zahl == 3) {
//            return Symbol.STEIN;
//        } else if (zahl == 4) {
//            return Symbol.PAPIER;
//        } else if (zahl == 5) {
//            return Symbol.SCHERE;
//        } else if (zahl == 6) {
//            return Symbol.PAPIER;
//        } else if (zahl == 7) {
//            zahl=0;
//            return Symbol.SCHERE;
//
//        } else {
//            return Symbol.STEIN;
//
//        }
//    }

                }
                // Füge hier drunter die fehlende Methode ein

                public void nimmGegnerSymbol(Symbol symbol, int runden) {

                    gegnerSymbol = symbol;
                }
            }