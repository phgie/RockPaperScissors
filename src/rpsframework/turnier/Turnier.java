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


    }
}
