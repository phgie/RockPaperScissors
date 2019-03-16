package test.rpsframework.turnier;

import rpsframework.basis.SteinScherePapierSpieler;
import rpsframework.basis.Symbol;

public class SpielerMock extends SteinScherePapierSpieler {

    private String name;
    private Symbol symbol;

    public SpielerMock(int spielernummer, Symbol symbol) {

        super(spielernummer);
        this.symbol = symbol;
    }

    @Override
    public Symbol gibSymbol() {

        return this.symbol;
    }

    @Override
    public void starteNeuesSpiel(int runden) {

    }

    @Override
    public void nimmGegnerSymbol(Symbol symbol, int runde) {

    }
}
