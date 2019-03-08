package rpsframework.basis;

import impl.Spieler;

public class Spiel {

    private Spieler spieler1;
    private Spieler spieler2;

    private int runden;

    private int spieler1siege;
    private int spieler2siege;
    private int unentschieden;


    public Spiel(Spieler spieler1, Spieler spieler2, int runden) {

        this.spieler1 = spieler1;
        this.spieler2 = spieler2;

        this.runden = runden;
    }

    public void starteDuell() {

        Symbol spieler1symbol;
        Symbol spieler2symbol;

        for (int i = 0; i < runden; i++) {

            spieler1symbol = spieler1.gibSymbol();
            spieler2symbol = spieler2.gibSymbol();

            Duell duell = new Duell(spieler1symbol, spieler2symbol);
            String ergebnis = duell.gibErgebnis();
        }
    }

    //TODO unschoen ;-)
    public int gibErgebnis(Spieler spieler) {

        if (spieler == null) {

            return unentschieden;
        } else if (spieler.equals(spieler1)) {

            return spieler1siege;
        } else if (spieler.equals(spieler2)) {

            return spieler2siege;
        } else {

            //doof
            return -1;
        }
    }
}
