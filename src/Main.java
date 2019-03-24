import impl.Spieler;
import rpsframework.basis.SteinScherePapierSpieler;
import rpsframework.turnier.Turnier;

public class Main {

    public static void main(String[] args) {

        SteinScherePapierSpieler spieler1 = new Spieler(1);
        SteinScherePapierSpieler spieler2 = new Spieler(2);

        Turnier turnier = new Turnier();
        turnier.fuegeTeilnehmerHinzu(spieler1);
        turnier.fuegeTeilnehmerHinzu(spieler2);

        turnier.starteTurnier();
    }
}
