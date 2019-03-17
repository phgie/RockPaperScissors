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

    public Spieler(int spielernummer) {

        super(spielernummer);
    }

    @Override
    public Symbol gibSymbol() {

        return Symbol.STEIN;
    }
}
