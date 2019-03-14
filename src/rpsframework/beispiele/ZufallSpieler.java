package rpsframework.beispiele;

import rpsframework.basis.SteinScherePapierSpieler;
import rpsframework.basis.Symbol;

public class ZufallSpieler implements SteinScherePapierSpieler {

    @Override
    public String getName() {

        return "ZufallSpieler";
    }

    @Override
    public Symbol gibSymbol() {

        // Hole ein zufälliges Symbol
        return Symbol.getRandom();
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
