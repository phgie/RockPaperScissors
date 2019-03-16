import rpsframework.basis.SteinScherePapierSpieler;
import rpsframework.beispiele.SpielerStein;
import rpsframework.beispiele.SpielerZyklus;
import rpsframework.beispiele.ZufallSpieler;
import rpsframework.turnier.Turnier;

public class Main {

    public static void main(String[] args) {

        // Spieler erstellen
        SteinScherePapierSpieler spieler1 = new SpielerStein(0);
        SteinScherePapierSpieler spieler2 = new ZufallSpieler(1);
        SteinScherePapierSpieler spieler3 = new SpielerZyklus(2);
        SteinScherePapierSpieler spieler4 = new ZufallSpieler(3);
        SteinScherePapierSpieler spieler5 = new SpielerZyklus(4);

        Turnier turnier = new Turnier();
        turnier.fuegeTeilnehmerHinzu(spieler1);
        turnier.fuegeTeilnehmerHinzu(spieler2);
        turnier.fuegeTeilnehmerHinzu(spieler3);
        turnier.fuegeTeilnehmerHinzu(spieler4);
        turnier.fuegeTeilnehmerHinzu(spieler5);

        turnier.setzeRundenProSpiel(100);

        turnier.starteTurnier();

        System.out.println(turnier.addiereSpielerPunkte(spieler1));
    }
}
