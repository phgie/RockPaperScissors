package rpsframework.turnier;

import rpsframework.basis.SteinScherePapierSpieler;

import java.util.ArrayList;

/**
 * TODO: Das eigentliche rpsframework.turnier.Turnier implementieren
 */
public class Turnier {

    private ArrayList<SteinScherePapierSpieler> teilnehmer;

    public Turnier() {

        this.teilnehmer = new ArrayList<>();
    }

    public void fuegeTeilnehmerHinzu(SteinScherePapierSpieler teilnehmer) {

        this.teilnehmer.add(teilnehmer);
    }

    public void starteTurnier() {

        // Ueber alle Spieler iterieren und jeden gegen jeden spielen lassen

        // Fuer jede Begegnung ein neues Spiel erstellen und die Spieler initialisieren
    }
}
