import rpsframework.basis.SteinScherePapierSpieler;
import rpsframework.beispiele.SpielerStein;
import rpsframework.beispiele.SpielerZyklus;
import rpsframework.beispiele.SpielerZufall;
import rpsframework.turnier.Turnier;

public class Main {

    public static void main(String[] args) {

        // Spieler erstellen
        SteinScherePapierSpieler spieler1 = new SpielerStein(0);
        SteinScherePapierSpieler spieler2 = new SpielerZufall(1);
        SteinScherePapierSpieler spieler3 = new SpielerZyklus(2);
        SteinScherePapierSpieler spieler4 = new SpielerZufall(3);
        SteinScherePapierSpieler spieler5 = new SpielerZyklus(4);

        Turnier turnier = new Turnier();
        turnier.fuegeTeilnehmerHinzu(spieler1);
        turnier.fuegeTeilnehmerHinzu(spieler2);
        turnier.fuegeTeilnehmerHinzu(spieler3);
        turnier.fuegeTeilnehmerHinzu(spieler4);
        turnier.fuegeTeilnehmerHinzu(spieler5);

        turnier.setzeRundenProSpiel(10);

        turnier.starteTurnier();

        System.out.println("Punkte für " + spieler1.getName() + " : " + turnier.zaehleSpielerPunkte(spieler1));
        System.out.println("Punkte für " + spieler2.getName() + " : " + turnier.zaehleSpielerPunkte(spieler2));
        System.out.println("Punkte für " + spieler3.getName() + " : " + turnier.zaehleSpielerPunkte(spieler3));
        System.out.println("Punkte für " + spieler4.getName() + " : " + turnier.zaehleSpielerPunkte(spieler4));
        System.out.println("Punkte für " + spieler5.getName() + " : " + turnier.zaehleSpielerPunkte(spieler5));
        System.out.println("Punkte für " + "Unentschieden" + " : " + turnier.zaehleSpielerPunkte(null));

    }
}
