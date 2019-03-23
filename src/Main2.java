import impl.Spieler;
import rpsframework.basis.Spiel;

public class Main2 {

    public static void main(String[] args) {

        Spieler spieler1 = new Spieler(1);
        Spieler spieler2 = new Spieler(2);

        Spiel neuesSpiel = new Spiel(20);
        neuesSpiel.fuegeSpielerHinzu(spieler1);
        neuesSpiel.fuegeSpielerHinzu(spieler2);

        neuesSpiel.starteSpiel();

        int punkteSpieler1 = neuesSpiel.gibSpielerPunkte(spieler1);
        int punkteSpieler2 = neuesSpiel.gibSpielerPunkte(spieler2);

        System.out.println("Spieler 1: " + punkteSpieler1 + " --- Spieler 2: " + punkteSpieler2);
    }
}
