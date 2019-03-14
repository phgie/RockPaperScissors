package rpsframework.beispiele;

import rpsframework.basis.SteinScherePapierSpieler;
import rpsframework.basis.Symbol;
import rpsframework.turnier.Duell;

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
    public void nimmDuell(Duell duell, int runde) {

        // Wird nicht verwendet
    }
}
