import rpsframework.basis.SteinScherePapierSpieler;
import rpsframework.beispiele.SpielerMuster;
import rpsframework.beispiele.SpielerStein;
import rpsframework.beispiele.SpielerZufall;
import rpsframework.beispiele.SpielerZyklus;
import rpsframework.turnier.Turnier;
import rpsframework.turnier.TurnierExporter;

public class Main {

    public static void main(String[] args) {

        // Spieler erstellen
        SteinScherePapierSpieler spieler1 = new SpielerStein(10);
        SteinScherePapierSpieler spieler2 = new SpielerZufall(1);
        SteinScherePapierSpieler spieler3 = new SpielerZyklus(2);
        SteinScherePapierSpieler spieler4 = new SpielerZufall(3);
        SteinScherePapierSpieler spieler5 = new SpielerMuster(4);
        SteinScherePapierSpieler spieler6 = new SpielerMuster(5);
        SteinScherePapierSpieler spieler7 = new SpielerMuster(6);
        SteinScherePapierSpieler spieler8 = new SpielerMuster(7);
        SteinScherePapierSpieler spieler9 = new SpielerMuster(8);
        SteinScherePapierSpieler spieler10 = new SpielerMuster(9);

        Turnier turnier = new Turnier();
        turnier.fuegeTeilnehmerHinzu(spieler1);
        turnier.fuegeTeilnehmerHinzu(spieler2);
        turnier.fuegeTeilnehmerHinzu(spieler3);
        turnier.fuegeTeilnehmerHinzu(spieler4);
        turnier.fuegeTeilnehmerHinzu(spieler5);
        turnier.fuegeTeilnehmerHinzu(spieler6);
        turnier.fuegeTeilnehmerHinzu(spieler7);
        turnier.fuegeTeilnehmerHinzu(spieler8);
        turnier.fuegeTeilnehmerHinzu(spieler9);
        turnier.fuegeTeilnehmerHinzu(spieler10);

        turnier.setzeRundenProSpiel(10);

        turnier.starteTurnier();

        System.out.println("Punkte für " + spieler1.getName() + " : " + turnier.zaehleSpielerPunkte(spieler1));
        System.out.println("Punkte für " + spieler2.getName() + " : " + turnier.zaehleSpielerPunkte(spieler2));
        System.out.println("Punkte für " + spieler3.getName() + " : " + turnier.zaehleSpielerPunkte(spieler3));
        System.out.println("Punkte für " + spieler4.getName() + " : " + turnier.zaehleSpielerPunkte(spieler4));
        System.out.println("Punkte für " + spieler5.getName() + " : " + turnier.zaehleSpielerPunkte(spieler5));
        System.out.println("Punkte für " + "Unentschieden" + " : " + turnier.zaehleSpielerPunkte(null));

        turnierZuHtml(turnier);
    }

    private static void turnierZuHtml(Turnier turnier) {
        new TurnierExporter().schreibeHtmlMitAuswerung(turnier);
    }
}
