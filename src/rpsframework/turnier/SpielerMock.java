package rpsframework.turnier;

import rpsframework.basis.SteinScherePapierSpieler;
import rpsframework.basis.Symbol;

public class SpielerMock extends SteinScherePapierSpieler {

    private String name;
    private Symbol symbol;

    public SpielerMock(int spielernummer) {
        super(spielernummer);
    }

    public void setSymbol(Symbol symbol) {

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
