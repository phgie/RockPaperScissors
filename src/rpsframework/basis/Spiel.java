package rpsframework.basis;

import java.util.*;

/**
 * Ein Spiel ist eine Begegnung zwischen zwei Spielern und läuft über eine vorgegebene Zahl von Runden. Jede Runde ist
 * ein Duell, dessen Ausgang abgefragt werden kann
 */
public class Spiel {

    private int runden;

    /* Die Duelle in diesem Spiel. */
    private ArrayList<Duell> duelle;

    /* Speichert die Punkte der beiden Spieler und die Anzahl der Unentschieden */
    private HashMap<SteinScherePapierSpieler, Integer> punkte;

    /**
     * Erzeugt ein neues Spiel. Das Spiel kann anschließend gestartet und nach seinem Ergebnis gefragt werden.
     * @param runden Die Anzahl der Duelle, die die beiden Spieler austragen sollen.
     */
    public Spiel(int runden) {

        this.runden = runden;

        this.duelle = new ArrayList<>();
        this.punkte = new HashMap<>();

        // "null" speichert die Punkte für Unentschieden.
        this.punkte.put(null, 0);
    }

    /**
     * Fügt einen einzelnen Spieler dem Spiel hinzu, falls dieser noch nicht Teilnehmer des Spiels ist.
     * @param spieler Ein SteinScherePapierSpieler
     */
    public void fuegeSpielerHinzu(SteinScherePapierSpieler spieler) {

        if (spieler != null && !this.punkte.containsKey(spieler)) {

            this.punkte.put(spieler, 0);
        }
    }

    /**
     * Startet das Spiel und löst die einzelnen Begegnungen aus
     */
    public void starteSpiel() {

        // Wir starten das Spiel nur, wenn genau 2 Teilnehmer vorhanden sind (der Teilnehmer "null" ist
        // immer vorhanden) und wenn noch Runden zu spielen sind
        if (this.punkte.size() == 3 && duelle.size() < runden) {

            // Wir lassen uns die Spieler aus der Punktetafel geben und entfernen den "Spieler" für Unentschieden
            Set<SteinScherePapierSpieler> spielerSet = new HashSet<>(this.punkte.keySet());
            spielerSet.remove(null);

            // Jetzt lassen wir uns die übrig bebliebenen Spieler ausgeben
            Iterator<SteinScherePapierSpieler> spielerIterator = spielerSet.iterator();

            // Wir wissen, dass es genau noch zwei Spieler gibt
            SteinScherePapierSpieler spieler1 = spielerIterator.next();
            SteinScherePapierSpieler spieler2 = spielerIterator.next();

            // Wir informieren die Spieler darüber, dass ein neues Spiel beginnt.
            spieler1.starteNeuesSpiel(this.runden);
            spieler2.starteNeuesSpiel(this.runden);

            // Für jede Runde angefangen bei der letzten, die gespielt wurde bis zur letzten geplanten Runde...
            for (int i = duelle.size(); i < this.runden; i++) {

                Symbol aktuellesSymbolSpieler1 = spieler1.gibSymbol();
                Symbol aktuellesSymbolSpieler2 = spieler2.gibSymbol();

                // Neues Duell für die beiden Spieler erstellen
                Duell aktuellesDuell = new Duell();
                aktuellesDuell.fuegeSpielerSymbolHinzu(spieler1, aktuellesSymbolSpieler1);
                aktuellesDuell.fuegeSpielerSymbolHinzu(spieler2, aktuellesSymbolSpieler2);
                this.duelle.add(aktuellesDuell);

                // Wir müssen den Spielern die Informationen des Duells in der aktuellen Runde mitteilen
                spieler1.nimmGegnerSymbol(aktuellesSymbolSpieler2, i + 1);
                spieler2.nimmGegnerSymbol(aktuellesSymbolSpieler1, i + 1);

            /* Wir holen uns den Gewinner des Duells und erhöhen seinen Punktestand. Sollte das Duell unentschieden sein,
               speichern wir auch diese Punkte (unter dem "Spieler" null). */
                SteinScherePapierSpieler duellGewinner = aktuellesDuell.gibGewinner();
                this.punkte.put(duellGewinner, this.punkte.get(duellGewinner) + 1);
            }
        }
    }

    /**
     * Gibt die Punktzahl des angegebenen Spielers zurück bzw. die Anzahl von Unentschieden, falls der angegebene Spieler "null" ist.
     * @param spieler Der Spieler, dessen Punktzahl zurückgegeben werden soll.
     * @return Die aktuelle Punktzahl des Spielers.
     */
    public int gibSpielerPunkte(SteinScherePapierSpieler spieler) {

        int ergebnis = 0;

        if (this.punkte.containsKey(spieler)) {

            ergebnis = this.punkte.get(spieler);
        }

        return ergebnis;
    }

    /**
     * Zählt, wie oft der übergebene Spieler das übergebene Symbol gewählt hat.
     * @param spieler Der Spieler
     * @param symbol Das Symbol
     * @return Die Anzahl der Duelle dieses Spiels, in denen der Spieler das Symbol gespielt hat.
     */
    public int zaehleSymbolFuerSpieler(SteinScherePapierSpieler spieler, Symbol symbol) {

        int ergebnis = 0;

        if (spieler != null) {

            // Gehe über alle bisher gespielten Duelle..
            for (Duell aktuellesDuell : this.duelle) {

                if ((aktuellesDuell.gibSpielerSymbol(spieler) == null && symbol == null)
                    || aktuellesDuell.gibSpielerSymbol(spieler).equals(symbol)) {

                    ergebnis++;
                }
            }
        }

        return ergebnis;
    }

    /**
     * Gibt das vom uebergebenen Spieler in der angegebenen Runde gespielte Symbol zurück, falls die Runde bereits
     * gespielt wurde. Falls nicht wird kein Symbol zurückgegeben
     * @param spieler Der Spieler, dessen gespieltes Symbol gesucht wird
     * @param runde Die Runde, in der das Symbol gespielt wurde
     * @return Das Symbol oder null, falls die Runde noch nicht gespielt wurde oder der Spieler kein Symbol gespielt hat.
     */
    public Symbol gibVonSpielerGespieltesSymbol(SteinScherePapierSpieler spieler, int runde) {

        Symbol gespieltesSymbol = null;

        if (this.duelle.size() >= runde) {

            gespieltesSymbol = this.duelle.get(runde - 1).gibSpielerSymbol(spieler);
        }

        return gespieltesSymbol;
    }

    /**
     * Gibt die Anzahl der bereits in diesem Spiel gespielten Runden zurück.
     * @return Die Anzahl Runden, die bereits gespielt wurden
     */
    public int gibGespielteRunden() {

        return this.duelle.size();
    }

    /**
     * Gibt die Gesamtzahl an Runden für dieses Spiel zurück.
     * @return Die gesamte Rundenzahl, die für dieses Spiel gespielt werden soll.
     */
    public int gibAnzahlRunden() {

        return this.runden;
    }

    /**
     * Prüft, ob der angegebene Spieler Teilnehmer dieses Spiels ist.
     * @param spieler Der zu prüfende Spieler
     * @return Wahr, wenn der Spieler Teilnehmer dieses Spiels ist, sonst falsch.
     */
    public boolean istTeilnehmer(SteinScherePapierSpieler spieler) {

        return spieler != null && this.punkte.containsKey(spieler);
    }

    @Override
    public boolean equals(Object object) {

        boolean istGleich = false;

        if (object != null && this.getClass() == object.getClass() && this.hashCode() == object.hashCode()) {

            Spiel anderesSpiel = (Spiel) object;

            // Beide Spiele sind gleich, wenn die Spieler identisch sind.
            istGleich = this.punkte.keySet().equals(anderesSpiel.punkte.keySet());
        }

        return istGleich;
    }

    @Override
    public int hashCode() {

        return Objects.hash(this.punkte.keySet());
    }
}
