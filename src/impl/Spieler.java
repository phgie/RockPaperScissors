package impl;

import rpsframework.basis.SteinScherePapierSpieler;
import rpsframework.basis.Symbol;
import rpsframework.turnier.Duell;

/**
 * Ein Spieler kann...
 *
 * ... an einem Spiel gegen einen anderen Spieler teilnehmen
 * ....an einem Turnier teilnehmen und dabei gegen mehrere Spieler ein Spiel bestreiten
 */
public class Spieler implements SteinScherePapierSpieler {

    @Override
    public String getName() {
        return "Dummfred";
    }

    @Override
    public Symbol gibSymbol() {
        return Symbol.STEIN;
    }

    @Override
    public void starteNeuesSpiel(int runden) { }

    @Override
    public void nimmDuell(Duell duell, int runde) { }
}
