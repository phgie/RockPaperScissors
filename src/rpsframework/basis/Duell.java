package rpsframework.basis;

import java.util.HashMap;
import java.util.Iterator;

/**
 * Ein Duell ist ein einzelnes Aufeinandertreffen zweier Spielersymbole. In einem Duell wird ein Gewinner (falls es einen gibt) ermittelt.
 */
public class Duell {

    /* Die von den Spielern in diesem einen Duell gespielten Symbole */
    private HashMap<SteinScherePapierSpieler, Symbol> symbole;

    /**
     * Erzeugt ein neues Duell für zwei Spieler
     */
    public Duell() {

        this.symbole = new HashMap<>();
    }

    /**
     * Fügt das vom übergebenen Spieler gewählte Symbol dem Duell hinzu.
     * @param spieler Der Spieler, der das Symbol gespielt hat.
     * @param symbol Das Symbol, welches der Spieler gewählt hat.
     */
    public void fuegeSpielerSymbolHinzu(SteinScherePapierSpieler spieler, Symbol symbol) {

        if (spieler != null && this.symbole.size() < 2 && !this.symbole.containsKey(spieler)) {

            this.symbole.put(spieler, symbol);
        }
    }

    /**
     * Gibt das vom angegebenen Spieler gewählte Symbol zurück
     * @param spieler Der Spieler, dessen gewähltes Symbol zurückgegeben werden soll.
     * @return Das vom Spieler gewählte Symbol
     */
    public Symbol gibSpielerSymbol(SteinScherePapierSpieler spieler) {

        return this.symbole.get(spieler);
    }

    /**
     * Gibt den Gewinner dieses Duells zurück oder Null, wenn es ein Unentschieden gab.
     * @return Den Gewinner des Duells, oder Null, wenn es ein Unentschieden gab.
     */
    public SteinScherePapierSpieler gibGewinner() {

        SteinScherePapierSpieler gewinner;

        if (this.symbole.size() == 0) {

            gewinner = null;
        } else if (this.symbole.size() == 1) {

            // Da es nur einen Spieler im Duell gibt, können wir direkt diesen als Gewinner ausgeben
            gewinner = this.symbole.keySet().iterator().next();
        } else {

            // Wir müssen zuerst beide Spieler kennen..
            Iterator<SteinScherePapierSpieler> spielerIter = this.symbole.keySet().iterator();
            SteinScherePapierSpieler spieler1 = spielerIter.next();
            SteinScherePapierSpieler spieler2 = spielerIter.next();

            if (Symbol.symbolEinsSchlaegtSymbolZwei(this.symbole.get(spieler1), this.symbole.get(spieler2))) {

                // Spieler 1 gewinnt
                gewinner = spieler1;
            } else if (Symbol.symbolEinsSchlaegtSymbolZwei(this.symbole.get(spieler2), this.symbole.get(spieler1))) {

                // Spieler 2 gewinnt
                gewinner = spieler2;
            } else {

                // Unentschieden
                gewinner = null;
            }
        }

        return gewinner;
    }
}
