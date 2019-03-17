package rpsframework.beispiele;

import rpsframework.basis.SteinScherePapierSpieler;
import rpsframework.basis.Symbol;

import java.security.SecureRandom;

/**
 * Ein Beispielgegner, der ein zufälliges Symbol spielt.
 */
public class SpielerZufall extends SteinScherePapierSpieler {

    /* Java bietet einen Standard-Mechanismus, um zufällige Werte zu erzeugen. */
    private final SecureRandom randomMechanism = new SecureRandom();

    /**
     * Erstellt einen neuen Zufallspieler
     * @param spielernummer Die notwendige Spielernummer
     */
    public SpielerZufall(int spielernummer) {

        // Wir verwenden den Konstruktor der übergeordneten Klasse
        super(spielernummer);
    }

    @Override
    public Symbol gibSymbol() {

        // Berechne ein zufälliges Symbol auf Basis der zur Verfügung stehenden Symbole.
        return Symbol.values()[this.randomMechanism.nextInt(Symbol.values().length)];
    }
}
