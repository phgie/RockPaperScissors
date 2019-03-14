package rpsframework.beispiele;

import rpsframework.basis.SteinScherePapierSpieler;
import rpsframework.basis.Symbol;
import rpsframework.turnier.Duell;

/**
 * Ein einfacher Beispielgegner, der immer Stein spielt
 */
public class SpielerStein implements SteinScherePapierSpieler {

    /**
     * Gibt den Namen dieses Spielers zurück
     *
     * @return Name des Spielers
     */
    @Override
    public String getName() {

        return "Stefan Stein";
    }

    /**
     * Gibt immer das Symbol Stein zurück.
     *
     * @return Symbol Stein
     */
    @Override
    public Symbol gibSymbol() {
        return Symbol.STEIN;
    }

    @Override
    public void starteNeuesSpiel(int runden) {

        // Wird nicht verwendet
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
