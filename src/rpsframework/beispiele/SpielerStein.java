package rpsframework.beispiele;

import rpsframework.basis.SteinScherePapierSpieler;
import rpsframework.basis.Symbol;

/**
 * Ein einfacher Beispielgegner, der immer Stein spielt
 */
public class SpielerStein implements SteinScherePapierSpieler {

    @Override
    public String getName() {
        return null;
    }

    @Override
    public Symbol gibSymbol() {

        return Symbol.STEIN;
    }

    @Override
    public void vorbereitenAufNeuesSpiel() {

    }
}
