package rpsframework.turnier;

import impl.Spieler;
import rpsframework.basis.Spiel;
import rpsframework.basis.SteinScherePapierSpieler;

import java.util.ArrayList;
import java.util.Collections;

/**
 * TODO: Das eigentliche rpsframework.turnier.Turnier implementieren
 */
public class Turnier {

    private ArrayList<SteinScherePapierSpieler> teilnehmer;
    private Spiel[][] spiele;

    private static final int runden = 100;

    public Turnier() {
        this.teilnehmer = new ArrayList<>();
    }

    public void fuegeTeilnehmerHinzu(SteinScherePapierSpieler ...turnierTeilnehmer) {
        Collections.addAll(this.teilnehmer, turnierTeilnehmer);
        spiele = new Spiel[this.teilnehmer.size()][this.teilnehmer.size()];
    }

    public void starteTurnier() {
        for (int i = 0; i < teilnehmer.size(); ++i) {
            for (int j = i + 1; j < teilnehmer.size(); ++j) {
                //this.spiele.push(new Spiel(teilnehmer[i], teilnehmer[j])
                spiele[i][j] = new Spiel(teilnehmer.get(i), teilnehmer.get(j), runden);
                spiele[j][i] = spiele[i][j];

                spiele[i][j].starteSpiel();
            }
        }
    }

    public SteinScherePapierSpieler ermittleGesamtGewinner() {
        int[] punkte = new int[teilnehmer.size()];
        int maximalePunktzahl = 0;
        SteinScherePapierSpieler aktuellerGewinner = null;

        for (int i = 0; i < spiele.length; ++i) {
            for (int j = i + 1; j < spiele.length; ++j) {
                int indexDesGewinners;
                if (spiele[i][j].getGewinner() == teilnehmer.get(i))
                    indexDesGewinners = i;
                else
                    indexDesGewinners = j;
                punkte[indexDesGewinners] += 1;

                if (maximalePunktzahl < punkte[indexDesGewinners]) {
                    maximalePunktzahl = punkte[indexDesGewinners];
                    aktuellerGewinner = teilnehmer.get(indexDesGewinners);
                }
            }
        }

        return aktuellerGewinner;
    }
}
