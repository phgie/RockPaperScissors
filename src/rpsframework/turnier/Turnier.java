package rpsframework.turnier;

import rpsframework.basis.Spiel;
import rpsframework.basis.SteinScherePapierSpieler;
import rpsframework.basis.Symbol;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/**
 * Ein Turnier, bestehend aus mehreren Spielen mit jeweils mehreren Duellen
 */
public class Turnier {

    /* Die Standard-Anzahl an Runden, falls kein eigener Wert gesetzt wurde. */
    private static final int standardRundenZahl = 100;

    /* Wir speichern hier die Teilnehmer des Turniers */
    private List<SteinScherePapierSpieler> teilnehmer;

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

        if (turnierTeilnehmer != null && !this.teilnehmer.contains(turnierTeilnehmer)) {

            this.teilnehmer.add(turnierTeilnehmer);
        }
    }

    /**
     * Entfernt den übergebenen Teilnehmer aus dem Turnier zusammen mit allen Spielen, an denen der Spieler teilgenommen hat
     * @param turnierTeilnehmer Der Spieler, der aus dem Turnier entfernt werden soll.
     */
    public void entferneTeilnehmer(SteinScherePapierSpieler turnierTeilnehmer) {

        if (this.teilnehmer.contains(turnierTeilnehmer)) {

            this.teilnehmer.remove(turnierTeilnehmer);

            Iterator<Spiel> spieleIterator = this.spiele.iterator();
            HashSet<Spiel> neuesSpieleSet = new HashSet<>();

            while (spieleIterator.hasNext()) {

                Spiel aktuellesSpiel = spieleIterator.next();

                if (!aktuellesSpiel.istTeilnehmer(turnierTeilnehmer)) {

                    neuesSpieleSet.add(aktuellesSpiel);
                }
            }

            this.spiele = neuesSpieleSet;
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

            //Für alle weiteren verbleibenden Teilnehmer...
            for (int j = i + 1; j < teilnehmer.size(); j++) {

                Spiel spiel = new Spiel(this.rundenProSpiel);
                spiel.fuegeSpielerHinzu(teilnehmer.get(i));
                spiel.fuegeSpielerHinzu(teilnehmer.get(j));

                // Gibt es bereits ein Spiel zwischen beiden Teilnehmern?
                if (!this.spiele.contains(spiel)) {

                    spiele.add(spiel);
                    spiel.starteSpiel();
                }
            }
        }
    }

    public List<SteinScherePapierSpieler> gibTeilnehmer() {

        return this.teilnehmer;
    }

    /**
     * Gibt die Anzahl der Teilnehmer dieses Turniers zurück.
     * @return Die Anzahl der Teilnehmer
     */
    public int gibAnzahlSpieler() {

        return this.teilnehmer.size();
    }

    /**
     * Gibt die Anzahl der gespielten Spiele zurück.
     * @return Die Anzahl der Spiele, die bisher gespielt wurden.
     */
    public int gibAnzahlSpiele() {

        return this.spiele.size();
    }

    /**
     * Gibt das Spiel zwischen den beiden übergebenen Teilnehmern zurück, falls es bereits eine Begegnung zwischen
     * diesen beiden Spielern gibt, sonst null.
     * @param spieler1 Der erste an dem zu suchenden Spiel beteiligte Spieler
     * @param spieler2 Der zweite an dem zu suchenden Spiel beteiligte Spieler
     * @return Das Spiel zwischen den beiden übergeben Spieler oder null, falls kein solches Spiel existiert
     */
    public Spiel gibSpiel(SteinScherePapierSpieler spieler1, SteinScherePapierSpieler spieler2) {

        Spiel gefundenesSpiel = null;

        if (this.teilnehmer.contains(spieler1) && this.teilnehmer.contains(spieler2)) {

            //Beide Teilnehmer sind im Turnier, wir suchen nun nach dem Spiel zwischen beiden
            for (Spiel aktuellesSpiel : this.spiele) {

                if (aktuellesSpiel.istTeilnehmer(spieler1) && aktuellesSpiel.istTeilnehmer(spieler2)) {

                    // Spiel gefunden, speichern und zurückgeben
                    gefundenesSpiel = aktuellesSpiel;
                    break;
                }
            }
        }

        return gefundenesSpiel;
    }

    /**
     * Addiert alle Punkte aller Spiele des übergebenen Spielers bzw. die Anzahl der Unentschieden, falls der
     * übergebene Spieler "null" ist.
     * @param spieler Der Spieler, dessen Gesamtpunkte ermittelt werden sollen oder "null" falls die Anzahl der
     *                Unentschieden ermittelt werden soll.
     * @return Alle Punkte aus allen Spielen, an denen der Spieler teilgenommen hat bzw. alle Unentschieden aus
     * allen Spielen, falls der übergebene Spieler "null" ist.
     */
    public int zaehleSpielerPunkte(SteinScherePapierSpieler spieler) {

        int punkte = 0;

        for (Spiel aktuellesSpiel : this.spiele) {

            if (aktuellesSpiel.istTeilnehmer(spieler) || spieler == null) {

                punkte += aktuellesSpiel.gibSpielerPunkte(spieler);
            }
        }

        return punkte;
    }

    /**
     * Zählt die Häufigkeit des übergebenen Symbols für einen Spieler
     * @param spieler Der Spieler, für den gezählt werden soll
     * @param symbol Das Symbol, welches für den Spieler gesucht werden soll
     * @return Die Anzahl, wie oft der Spieler das Symbol gewählt hat
     */
    public int zaehleSymbolFuerSpieler(SteinScherePapierSpieler spieler, Symbol symbol) {

        int anzahlSymbole = 0;

        for (Spiel aktuellesSpiel: this.spiele) {

            if (aktuellesSpiel.istTeilnehmer(spieler)) {

                anzahlSymbole += aktuellesSpiel.zaehleSymbolFuerSpieler(spieler, symbol);
            }
        }

        return anzahlSymbole;
    }

    /**
     * Zählt die Häufigkeit des übergebenen Symbols für alle Spieler.
     * @param symbol Das Symbol, welches gezählt werden soll.
     * @return Wie oft das Symbol gespielt wurde
     */
    public int zaehleSymbol(Symbol symbol) {

        int anzahlSymbol = 0;

        for (SteinScherePapierSpieler spieler : this.teilnehmer) {

            anzahlSymbol += zaehleSymbolFuerSpieler(spieler, symbol);
        }

        return anzahlSymbol;
    }
}
