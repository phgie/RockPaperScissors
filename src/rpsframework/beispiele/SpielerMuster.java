package rpsframework.beispiele;

import rpsframework.basis.SteinScherePapierSpieler;
import rpsframework.basis.Symbol;
import rpsframework.strategie.Angriffsmuster;
import rpsframework.turnier.Duell;

/**
 * Ein einfacher Beispielgegner, der immer Stein, Schere und Papier abwechselnd in der selben Reihenfolge spielt.
 */
public class SpielerMuster implements SteinScherePapierSpieler {

    /**
     * Angriffsmuster
     */
    private Angriffsmuster muster;

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
        return "Max Muster";
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

        // Hole nächstes Symbol
        Symbol auswahl =  muster.gibNaechstesSymbol(runde);

        // Zähle Runde um eins hoch
        runde = runde + 1;

        return auswahl;
    }

    /**
     * Initialisiert ein neues Spiel und legt die Reihenfolge der
     * zurückgegebenen Symbole fest (Erst 2x Stein, dann 3x Schere, dann 4x Papier).
     *
     * @param runden Die Anzahl der Runden für das neue Spiel
     */
    @Override
    public void starteNeuesSpiel(int runden) {

        // Setze Rundenzähler zurück
        runde = 0;

        // Definiere ein Angriffsmuster
        muster = Angriffsmuster.zuErst(Symbol.STEIN).mehrmals(2)
                .dann(Symbol.SCHERE).mehrmals(3)
                .dann(Symbol.PAPIER).mehrmals(4)
                .undWiederVonVorne();
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
