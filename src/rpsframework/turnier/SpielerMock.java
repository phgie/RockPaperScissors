package rpsframework.turnier;

import rpsframework.basis.SteinScherePapierSpieler;
import rpsframework.basis.Symbol;

public class SpielerMock implements SteinScherePapierSpieler {

    private String name;
    private Symbol symbol;

    public SpielerMock(String name) {

        this.name = name;
    }

    public void setSymbol(Symbol symbol) {

        this.symbol = symbol;
    }

    @Override
    public String getName() {

        return this.name;
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
