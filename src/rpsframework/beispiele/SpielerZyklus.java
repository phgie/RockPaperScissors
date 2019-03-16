package rpsframework.beispiele;

import rpsframework.basis.SteinScherePapierSpieler;
import rpsframework.basis.Symbol;

import java.util.ArrayList;

/**
 * Ein einfacher Beispielgegner, der immer Stein, Schere und Papier abwechselnd in der selben Reihenfolge spielt.
 */
public class SpielerZyklus extends SteinScherePapierSpieler {

    /**
     * Liste mit Symbolen, welche abwechselnd gespielt werden sollen
     */
    private ArrayList<Symbol> symbolListe = new ArrayList<>();

    /**
     * Rundenzaehler
     */
    private int runde;

    public SpielerZyklus(int spielernummer) {
        super(spielernummer);
    }

    /**
     * Gibt das aktuelle Symbol zurük. Nimmt dazu die aktuelle
     * Nummer der Runde modulo 3 und wechselt so nacheinander
     * durch Schere, Stein und Papier.
     *
     * @return Aktuelles Symbol
     */
    @Override
    public Symbol gibSymbol() {

        // Runde hochzählen
        runde = runde + 1;

        // Naechstes Symbol zurueckgeben
        return  symbolListe.get(runde%3);
    }

    /**
     * Initialisiert ein neues Spiel. Setzt den Rundenzähler auf 0
     * und legt die Reihenfolge der zurückgegebenen Symbole fest
     * (Erst Schere, dann Stein, dann Papier).
     *
     * @param runden Die Anzahl der Runden für das neue Spiel
     */
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
    public void nimmGegnerSymbol(Symbol symbol, int runde) {

        // Wird nicht verwendet
    }
}
