package rpsframework.turnier;

import rpsframework.basis.SteinScherePapierSpieler;

import java.util.*;

/**
 * Ein Turnier, bestehend aus mehreren Spielen mit jeweils mehreren Duellen
 */
public class Turnier {

    /* Die Standard-Anzahl an Runden, falls kein eigener Wert gesetzt wurde. */
    private static final int standardRundenZahl = 100;

    /* Wir speichern hier die Teilnehmer des Turniers */
    private ArrayList<SteinScherePapierSpieler> teilnehmer;

    /* Wir speichern die Spiele des Turniers in einem HashSet */
    private HashSet<Spiel> spiele;

    private int rundenProSpiel;

    /**
     * Erzeugt ein neues Turnier
     */
    public Turnier() {

        this.teilnehmer = new ArrayList<>();
        this.spiele = new HashSet<>();
        this.rundenProSpiel = standardRundenZahl;
    }


    /**
     * Fügt einen einzelnen Teilnehmer dem Turnier hinzu, falls dieser noch nicht Teilnehmer des Turniers ist.
     * @param turnierTeilnehmer Der Turnierteilnehmer, ein SteinScherePapierSpieler
     */
    public void fuegeTeilnehmerHinzu(SteinScherePapierSpieler turnierTeilnehmer) {

        if (!this.teilnehmer.contains(turnierTeilnehmer)) {

            this.teilnehmer.add(turnierTeilnehmer);
        }
    }

    /**
     * Setzt die Anzahl der Runden pro Spiel für das Turnier fest.
     * @param runden Die Rundenzahl
     */
    public void setzeRundenProSpiel(int runden) {

        this.rundenProSpiel = runden;
    }


    /**
     * Startet das Turnier mit den vorhandenen Teilnehmern und der eingestellten Anzahl Runden pro Spiel.
     */
    public void starteTurnier() {

        //Für jeden Teilnehmer ...
        for (int i = 0; i < teilnehmer.size(); i++) {

            //Für alle verbleibenden Teilnehmer...
            for (int j = i + 1; j < teilnehmer.size(); j++) {

                Spiel spiel = new Spiel(teilnehmer.get(i), teilnehmer.get(j), this.rundenProSpiel);

                spiel.starteSpiel();
                spiele.add(spiel);
            }
        }
    }

    /**
     * Addiert alle Punkte aller Spiele des übergebenen Spielers.
     * @param spieler
     * @return
     */
    public int addiereSpielerPunkte(SteinScherePapierSpieler spieler) {

        int punkte = 0;

        for (Spiel aktuellesSpiel : this.spiele) {

            if (aktuellesSpiel.istTeilnehmer(spieler)) {

                punkte += aktuellesSpiel.gibSpielerPunkte(spieler);
            }
        }

        return punkte;
    }

    //TODO
    public SteinScherePapierSpieler starteAuswertung() {

//        HashMap<SteinScherePapierSpieler, Integer> ergebnisse = new HashMap<>();
//
//
//        int[] punkte = new int[teilnehmer.size()];
//        int maximalePunktzahl = 0;
//        SteinScherePapierSpieler aktuellerGewinner = null;
//
//        for (int i = 0; i < spiele.length; ++i) {
//            for (int j = i + 1; j < spiele.length; ++j) {
//                Integer indexDesGewinners;
//                SteinScherePapierSpieler gewinner = spiele[i][j].gibGewinner();
//                if (gewinner == teilnehmer.get(i))
//                    indexDesGewinners = i;
//                else if (gewinner == teilnehmer.get(j))
//                    indexDesGewinners = j;
//                else
//                    indexDesGewinners = null;
//
//                if (indexDesGewinners != null) {
//                    punkte[indexDesGewinners] += 1;
//
//                    if (maximalePunktzahl < punkte[indexDesGewinners]) {
//                        maximalePunktzahl = punkte[indexDesGewinners];
//                        aktuellerGewinner = teilnehmer.get(indexDesGewinners);
//                    } else if (maximalePunktzahl == punkte[indexDesGewinners])
//                        aktuellerGewinner = null;
//                }
//            }
//        }

        return null;
    }
}
