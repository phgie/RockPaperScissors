public class Duell {

    private Spieler spieler1;
    private Spieler spieler2;

    private int runden;

    private int spieler1siege;
    private int spieler2siege;
    private int unentschieden;


    public Duell(Spieler spieler1, Spieler spieler2, int runden) {

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

            //TODO schoener machen und ggf. auslagern
            switch(spieler1symbol) {

                case STEIN:

                    switch (spieler2symbol) {

                        case STEIN:
                            //unentschieden
                            unentschieden++;
                            break;
                        case PAPIER:
                            //Spieler 1 gewinnt
                            spieler1siege++;
                            break;
                        case SCHERE:
                            //Spieler 2 gewinnt
                            spieler2siege++;
                            break;
                    }
                    break;
                case PAPIER:

                    switch (spieler2symbol) {

                        case STEIN:
                            //Spieler 1 gewinnt
                            spieler1siege++;
                            break;
                        case PAPIER:
                            //unentschieden
                            unentschieden++;
                            break;
                        case SCHERE:
                            //Spieler 2 gewinnt
                            spieler2siege++;
                            break;
                    }
                    break;
                case SCHERE:

                    switch (spieler2symbol) {

                        case STEIN:
                            //Spieler 2 gewinnt
                            spieler2siege++;
                            break;
                        case PAPIER:
                            //Spieler 1 gewinnt
                            spieler1siege++;
                            break;
                        case SCHERE:
                            //unentschieden
                            unentschieden++;
                            break;
                    }
            }
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
