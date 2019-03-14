package rpsframework.beispiele;

import rpsframework.basis.SteinScherePapierSpieler;
import rpsframework.basis.Symbol;

/**
 * Ein einfacher Beispielgegner, der immer Stein spielt
 */
public class SpielerStein implements SteinScherePapierSpieler {

    @Override
    public String getName() {

        return "SteinSpieler";
    }

    @Override
    public Symbol gibSymbol() {

        // Spielt immer Stein
        return Symbol.STEIN;
    }

    @Override
    public void starteNeuesSpiel(int runden) {

        // Wird nicht verwendet
    }

    @Override
    public void nimmGegnerSymbol(Symbol symbol, int runde) {

        // Wird nicht verwendet
    }
}
