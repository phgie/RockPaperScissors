import rpsframework.basis.SteinScherePapierSpieler;
import rpsframework.beispiele.SpielerZufall;
import rpsframework.turnier.Turnier;
import rpsframework.turnier.TurnierExporter;

public class Main {

    public static void main(String[] args) {

        // Spieler erstellen
        SteinScherePapierSpieler spieler1 = new SpielerZufall(1);
        SteinScherePapierSpieler spieler2 = new SpielerZufall(2);
        SteinScherePapierSpieler spieler3 = new SpielerZufall(3);


        Turnier turnier = new Turnier();
        turnier.fuegeTeilnehmerHinzu(spieler1);
        turnier.fuegeTeilnehmerHinzu(spieler2);
        turnier.fuegeTeilnehmerHinzu(spieler3);


        turnier.setzeRundenProSpiel(10);

        turnier.starteTurnier();

        System.out.println("Punkte für " + spieler1.getName() + " : " + turnier.zaehleSpielerPunkte(spieler1));
        System.out.println("Punkte für " + spieler2.getName() + " : " + turnier.zaehleSpielerPunkte(spieler2));
        System.out.println("Punkte für " + spieler3.getName() + " : " + turnier.zaehleSpielerPunkte(spieler3));
        System.out.println("Punkte für " + "Unentschieden" + " : " + turnier.zaehleSpielerPunkte(null));

        turnierZuHtml(turnier);
    }

    private static void turnierZuHtml(Turnier turnier) {

        new TurnierExporter().schreibeHtmlMitAuswerung(turnier);
    }
}
