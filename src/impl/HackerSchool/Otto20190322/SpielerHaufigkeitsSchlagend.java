package impl.HackerSchool.Otto20190322;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import rpsframework.basis.SteinScherePapierSpieler;
import rpsframework.basis.Symbol;

/**
 * Ein Spieler kann...
 *
 * ... an einem Spiel gegen einen anderen Spieler teilnehmen
 * ....an einem Turnier teilnehmen und dabei gegen mehrere Spieler ein Spiel bestreiten
 */
public class SpielerHaufigkeitsSchlagend extends SteinScherePapierSpieler {
	private List<Symbol> enemySymbols = new ArrayList<Symbol>();
	private int round = 0;

    public SpielerHaufigkeitsSchlagend(int spielernummer) {
        super(spielernummer);
        
        
    }

    @Override
    public Symbol gibSymbol() {
    	Symbol returnSymbol = getSchlagenden(getHaufigstes());
    	
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
    
    private Symbol getHaufigstes(){
    	Map<Symbol, Integer> symbolCount = new HashMap<Symbol, Integer>();
    	symbolCount.put(Symbol.STEIN, 0);
    	symbolCount.put(Symbol.SCHERE, 0);
    	symbolCount.put(Symbol.PAPIER, 0);
    	
    	//default
    	int highest=0;
    	Symbol returnSymbol = Symbol.STEIN;
    	
    	for(Symbol s : enemySymbols){
    		symbolCount.replace(s, symbolCount.get(s).intValue() + 1);
    	}
    	
    	for(Entry<Symbol, Integer> es : symbolCount.entrySet()){
    		if(es.getValue() > highest){
    			returnSymbol = es.getKey();
    			highest = es.getValue();
    		}
    	}
    	
    	return returnSymbol;
    }
}
