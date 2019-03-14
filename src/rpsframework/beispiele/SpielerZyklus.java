package rpsframework.beispiele;

import java.util.ArrayList;
import rpsframework.basis.SteinScherePapierSpieler;
import rpsframework.basis.Symbol;
import rpsframework.turnier.Duell;

/**
 * Ein einfacher Beispielgegner, der immer Stein, Schere und Papier abwechselnd in der selben Reihenfolge spielt.
 */
public class SpielerZyklus implements SteinScherePapierSpieler {

    /**
     * Liste mit Symbolen welche abwechselnd gespielt werden sollen
     */
    private ArrayList<Symbol> symbolListe = new ArrayList<>();

    /**
     * Rundenzaehler
     */
    private int runde;

    @Override
    public String getName() {
        return "Frank Dreher";
    }

    @Override
    public Symbol gibSymbol() {

        // Runde hochzählen
        runde = runde + 1;

        // Naechstes Symbol zurueckgeben
        return  symbolListe.get(runde%3);
    }

    @Override
    public void starteNeuesSpiel(int runden) {
        // Rundenzaehler zuruecksetzen
        runde = 0;

        // Reihenfolge der Symbole festlegen
        symbolListe.clear();
        symbolListe.add(Symbol.SCHERE);
        symbolListe.add(Symbol.STEIN);
        symbolListe.add(Symbol.PAPIER);
    }

    @Override
    public void nimmDuell(Duell duell, int runde) {
        // Wird nicht verwendet
    }
}
