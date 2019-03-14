package rpsframework.turnier;

import rpsframework.basis.SteinScherePapierSpieler;
import rpsframework.basis.Symbol;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Ein Spiel ist eine Begegnung zwischen zwei Spielern und läuft über eine vorgegebene Zahl von Runden. Jede Runde ist
 * ein Duell, dessen Ausgang abgefragt werden kann
 */
class Spiel {

    private SteinScherePapierSpieler spieler1;
    private SteinScherePapierSpieler spieler2;

    /* Die Duelle in diesem Spiel. */
    private ArrayList<Duell> duelle;

    private int runden;

    private int spieler1siege;
    private int spieler2siege;


    /**
     * Erzeugt ein neues Spiel. Das Spiel kann anschließend gestartet und nach seinem Ergebnis gefragt werden.
     * @param spieler1 Spieler 1
     * @param spieler2 Spieler 2
     * @param runden Die Anzahl der Duelle, die die beiden Spieler austragen sollen.
     */
    Spiel(SteinScherePapierSpieler spieler1, SteinScherePapierSpieler spieler2, int runden) {

        this.spieler1 = spieler1;
        this.spieler2 = spieler2;

        this.duelle = new ArrayList<>();

        this.runden = runden;
    }

    /**
     * Startet das Spiel und löst die einzelnen Begegnungen aus
     */
    void starteSpiel() {

        // Wir informieren die Spieler darüber, dass ein neues Spiel beginnt.
        spieler1.starteNeuesSpiel(this.runden);
        spieler2.starteNeuesSpiel(this.runden);

        Symbol aktuellesSymbolSpieler1;
        Symbol aktuellesSymbolSpieler2;

        //Für jede Runde bis zur letzten ...
        for (int i = 0; i < this.runden; i++) {

            aktuellesSymbolSpieler1 = spieler1.gibSymbol();
            aktuellesSymbolSpieler2 = spieler2.gibSymbol();

            Duell aktuellesDuell = new Duell(aktuellesSymbolSpieler1, aktuellesSymbolSpieler2);

            // Wir müssen den Spielern die Informationen des Duells in der aktuellen Runde mitteilen
            spieler1.nimmDuell(aktuellesDuell, i + 1);
            spieler2.nimmDuell(aktuellesDuell, i + 1);

            //Die Ergebnisse der einzelnen Duelle merken wir uns direkt
            switch (aktuellesDuell.gibErgebnis()) {

                case Duell.rueckgabewertSpielerEinsGewinnt:

                    // Spieler 1 gewinnt
                    spieler1siege++;
                    break;
                case Duell.rueckgabewertSpielerZweiGewinnt:

                    // Spieler 2 gewinnt
                    spieler2siege++;
                    break;
                case Duell.rueckgabewertUnentschieden:

                    /* Unentschieden. Wir notieren hier nichts, da sich die Anzahl der Unentschieden auch anders
                       ermitteln lässt (Anzahl der Runden insgesamt minus die Siege von beiden Spielern) */
                    break;
            }
        }

        //TODO REMOVE
        System.out.println("Spiel zwischen " + spieler1.getName() + " und " + spieler2.getName() + ": Ergebnis ist " + gibErgebnis());
    }

    /**
     * Gibt das Ergebnis des Spiels zurück.
     * @return 1, falls Spieler 1 gewinnt, 2, falls Spieler gewinnt, 0 bei unentschieden.
     */
    int gibErgebnis() {

        return spieler1siege > spieler2siege
                ? Duell.rueckgabewertSpielerEinsGewinnt
                : spieler2siege > spieler1siege
                ? Duell.rueckgabewertSpielerZweiGewinnt
                : Duell.rueckgabewertUnentschieden;
    }

    @Override
    public boolean equals(Object object) {

        boolean istGleich = false;

        if (object != null && this.getClass() == object.getClass()) {

            Spiel spiel = (Spiel) object;
            istGleich = this.runden == spiel.runden
                    && (spieler1.equals(spiel.spieler1) && spieler2.equals(spiel.spieler2))
                    || (spieler1.equals(spiel.spieler2) && spieler2.equals(spiel.spieler1));
        }

        return istGleich;
    }

    @Override
    public int hashCode() {

        return Objects.hash(spieler1, spieler2, runden);
    }
}
