package impl;

import java.util.ArrayList;
import java.util.List;

import rpsframework.basis.SteinScherePapierSpieler;
import rpsframework.basis.Symbol;

/**
 * Ein Spieler kann...
 *
 * ... an einem Spiel gegen einen anderen Spieler teilnehmen
 * ....an einem Turnier teilnehmen und dabei gegen mehrere Spieler ein Spiel bestreiten
 */
public class SpielerSchlagend extends SteinScherePapierSpieler {
	private List<Symbol> enemySymbols = new ArrayList<Symbol>();
	private int round = 0;

    public SpielerSchlagend(int spielernummer) {
        super(spielernummer);
        
        
    }

    @Override
    public Symbol gibSymbol() {
    	Symbol returnSymbol = Symbol.PAPIER;
    	
    	if(enemySymbols.size() > 0){
    		Symbol lastPlayed = enemySymbols.get(enemySymbols.size() - 1);
    		
    		returnSymbol = getSchlagenden(lastPlayed);
    	}
    	
    	
    	//System.out.println("Spieler" + getSpielernummer() + " - " + returnSymbol);
        return returnSymbol;
    }
    
    @Override
    public void nimmGegnerSymbol(Symbol symbol, int runde) {
    	if(runde == 1){
    		enemySymbols.clear();
    	}
    	
    	this.enemySymbols.add(symbol);
    	
    	this.round = runde;
    }
    
    private Symbol getSchlagenden(Symbol symbol){
    	for(Symbol s : Symbol.values()){
    		if(Symbol.symbolEinsSchlaegtSymbolZwei(s, symbol)){
    			return s;
    		}
    	}
    	
    	return null;
    }
}
