package impl;

import rpsframework.basis.SteinScherePapierSpieler;
import rpsframework.basis.Symbol;

/**
 * Ein Spieler kann...
 *
 * ... an einem Duell gegen einen anderen Spieler teilnehmen
 * ....an einem Turnier teilnehmen und dabei gegen mehrere Spieler ein Duell bestreiten
 */
public class Spieler implements SteinScherePapierSpieler {

    @Override
    public Symbol gibSymbol() {

        return Symbol.STEIN;
    }

    @Override
    public void starteNeuesDuell() {

    }
}
