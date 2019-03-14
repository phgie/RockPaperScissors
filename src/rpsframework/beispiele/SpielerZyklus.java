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
     * Liste mit Symbolen, welche abwechselnd gespielt werden sollen
     */
    private ArrayList<Symbol> symbolListe = new ArrayList<>();

    /**
     * Rundenzaehler
     */
    private int runde;

    /**
     * Gibt den Namen dieses Spielers zurück
     *
     * @return Name des Spielers
     */
    @Override
    public String getName() {
        return "Frank Dreher";
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

    /**
     * Nimmt das aktuelle Duell entgegen um Zugriff auf die gespielten Symbole beider Spieler zu haben.
     * Wird in dieser Implementierung nicht verwendet.
     *
     * @param duell Das Duell. Es beinhaltet Informationen über die von den Spielern in dieser Runde gespielten Symbole.
     * @param runde Die Runde, in der das Duell gespielt wurde
     */
    @Override
    public void nimmDuell(Duell duell, int runde) {
        // Wird nicht verwendet
    }
}
