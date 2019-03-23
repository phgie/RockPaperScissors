package impl;

import rpsframework.basis.SteinScherePapierSpieler;
import rpsframework.basis.Symbol;

/**
 * Ein Spieler kann...
 *
 * ... an einem Spiel gegen einen anderen Spieler teilnehmen
 * ....an einem Turnier teilnehmen und dabei gegen mehrere Spieler ein Spiel bestreiten
 */
public class Spieler extends SteinScherePapierSpieler {

    /**
     * Erzeugt ein neues Objekt dieser Klasse.
     * @param spielernummer Die Spielernummer des Spielers in einem Spiel bzw. Turnier. Die Spielernummer muss für jeden
     *                      Spieler verschieden sein.
     */
    public Spieler(int spielernummer) {

        super(spielernummer);
    }

    // Füge hier drunter die fehlende Methode ein
}
