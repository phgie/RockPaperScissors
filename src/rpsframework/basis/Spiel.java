package rpsframework.basis;

import impl.Spieler;

public class Spiel {

    private SteinScherePapierSpieler spieler1;
    private SteinScherePapierSpieler spieler2;

    private int runden;

    private int spieler1siege;
    private int spieler2siege;
    private int unentschieden;


    public Spiel(SteinScherePapierSpieler spieler1, SteinScherePapierSpieler spieler2, int runden) {

        this.spieler1 = spieler1;
        this.spieler2 = spieler2;

        this.runden = runden;
    }

    public void starteSpiel() {

        Symbol spieler1symbol;
        Symbol spieler2symbol;

        for (int i = 0; i < runden; i++) {

            spieler1symbol = spieler1.gibSymbol();
            spieler2symbol = spieler2.gibSymbol();

            Duell duell = new Duell(spieler1symbol, spieler2symbol);
            spieler1.siehtSymbolVonGegner(spieler2symbol);
            spieler2.siehtSymbolVonGegner(spieler1symbol);

            int ergebnis = duell.gibErgebnis();
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
