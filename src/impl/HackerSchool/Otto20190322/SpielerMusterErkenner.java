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
public class SpielerMusterErkenner extends SteinScherePapierSpieler {
	private List<Symbol> enemySymbols = new ArrayList<Symbol>();
	private int round = 0;

    public SpielerMusterErkenner(int spielernummer) {
        super(spielernummer);
        
        
    }

    @Override
    public Symbol gibSymbol() {
    	Symbol returnSymbol = getSchlagenden(getWarscheinlichstenFolgenden());
    	
    	/*if(enemySymbols.size() > 0){
    		Symbol lastPlayed = enemySymbols.get(enemySymbols.size() - 1);
    		
    		returnSymbol = getSchlagenden(lastPlayed);
    	}*/
    	
    	
    	
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
    
    private Symbol getWarscheinlichstenFolgenden(){
    	List<Symbol> sl = new ArrayList<Symbol>();
    	Symbol returnSymbol = Symbol.STEIN;
    	
    	if(enemySymbols.size() > 2){
    		Symbol lastSymbol = enemySymbols.get(enemySymbols.size() - 1);
    		int index=0;
    		
    		for(Symbol s : enemySymbols){
    			if(s.equals(lastSymbol) && index != enemySymbols.size() - 1){
    				sl.add(enemySymbols.get(index + 1));
    			}
    			index++;
    		}
    		
    		returnSymbol = getHaufigstes(sl);
    	}
    	
    	return returnSymbol;
    }
    
    private Symbol getHaufigstes(List<Symbol> list){
    	Map<Symbol, Integer> symbolCount = new HashMap<Symbol, Integer>();
    	symbolCount.put(Symbol.STEIN, 0);
    	symbolCount.put(Symbol.SCHERE, 0);
    	symbolCount.put(Symbol.PAPIER, 0);
    	
    	//default
    	int highest=0;
    	Symbol returnSymbol = Symbol.STEIN;
    	
    	for(Symbol s : list){
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
