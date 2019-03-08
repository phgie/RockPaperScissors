import impl.Spieler;
import rpsframework.basis.SteinScherePapierSpieler;
import rpsframework.beispiele.SpielerStein;
import rpsframework.turnier.Turnier;

public class Main {

    public static void main(String[] args) {

        // Spieler erstellen
        SteinScherePapierSpieler spieler1 = new SpielerStein();
        SteinScherePapierSpieler spieler2 = new Spieler();

        Turnier turnier = new Turnier();
        turnier.fuegeTeilnehmerHinzu(spieler1);
        turnier.fuegeTeilnehmerHinzu(spieler2);

        turnier.starteTurnier();
    }
}
