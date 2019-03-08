package rpsframework.basis;

public class Duell {

    private Symbol spieler1Symbol;
    private Symbol spieler2Symbol;

    public Duell(Symbol spieler1Symbol, Symbol spieler2Symbol) {

        this.spieler1Symbol = spieler1Symbol;
        this.spieler2Symbol = spieler2Symbol;
    }

    public String gibErgebnis() {

        String ergebnis = "";

        //TODO schoener machen
        switch(spieler1Symbol) {

            case STEIN:

                switch (spieler2Symbol) {

                    case STEIN:
                        //unentschieden
                        ergebnis = "Unentschieden";
                        break;
                    case PAPIER:
                        //Spieler 1 gewinnt
                        ergebnis = "Spieler 1 gewinnt";
                        break;
                    case SCHERE:
                        //Spieler 2 gewinnt
                        ergebnis = "Spieler 2 gewinnt";
                        break;
                }
                break;
            case PAPIER:

                switch (spieler2Symbol) {

                    case STEIN:
                        //Spieler 1 gewinnt
                        ergebnis = "Spieler 1 gewinnt";
                        break;
                    case PAPIER:
                        //unentschieden
                        ergebnis = "Unentschieden";
                        break;
                    case SCHERE:
                        //Spieler 2 gewinnt
                        ergebnis = "Spieler 2 gewinnt";
                        break;
                }
                break;
            case SCHERE:

                switch (spieler2Symbol) {

                    case STEIN:
                        //Spieler 2 gewinnt
                        ergebnis = "Spieler 2 gewinnt";
                        break;
                    case PAPIER:
                        //Spieler 1 gewinnt
                        ergebnis = "Spieler 1 gewinnt";
                        break;
                    case SCHERE:
                        //unentschieden
                        ergebnis = "Unentschieden";
                        break;
                }
        }

        return ergebnis;
    }
}
