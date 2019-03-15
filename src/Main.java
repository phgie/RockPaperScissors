import rpsframework.basis.SteinScherePapierSpieler;
import rpsframework.beispiele.SpielerStein;
import rpsframework.beispiele.SpielerZyklus;
import rpsframework.beispiele.ZufallSpieler;
import rpsframework.turnier.Turnier;

public class Main {

    public static void main(String[] args) {

        // Spieler erstellen
        SteinScherePapierSpieler spieler1 = new SpielerStein();
        SteinScherePapierSpieler spieler2 = new ZufallSpieler();
        SteinScherePapierSpieler spieler3 = new SpielerZyklus();

        Turnier turnier = new Turnier();
        turnier.fuegeTeilnehmerHinzu(spieler1);
        turnier.fuegeTeilnehmerHinzu(spieler2);
        turnier.fuegeTeilnehmerHinzu(spieler3);

        turnier.setzeRundenProSpiel(100);

        turnier.starteTurnier();
    }
}
