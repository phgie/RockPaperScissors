import impl.*;
import rpsframework.basis.SteinScherePapierSpieler;
import rpsframework.turnier.Turnier;
import rpsframework.turnier.TurnierExporter;

import java.util.concurrent.ScheduledExecutorService;

public class ErstesTurnier {

    public static void main(String[] args) {

        Turnier turnier = new Turnier();
        SteinScherePapierSpieler spieler1 = new Bladlen(1);
        SteinScherePapierSpieler spieler2 = new Gewinner(2);
        SteinScherePapierSpieler spieler3 = new Horst3142(3);
        SteinScherePapierSpieler spieler4 = new SandB(4);
        SteinScherePapierSpieler spieler5 = new Simon(5);
        SteinScherePapierSpieler spieler6 = new SpielerHaufigkeitsSchlagend(6);
        SteinScherePapierSpieler spieler7 = new SpielerMusterErkenner(7);
        SteinScherePapierSpieler spieler8 = new SpielerSchlagend(8);
        SteinScherePapierSpieler spieler9 = new BladlenAlt(9);
        SteinScherePapierSpieler spieler10 = new GewinnerAlt(10);
        SteinScherePapierSpieler spieler11 = new SandBAlt(11);
        SteinScherePapierSpieler spieler12 = new SimonAlt(12);
        SteinScherePapierSpieler spieler13 = new Horst3142Alt(13);


        turnier.fuegeTeilnehmerHinzu(spieler1);
        turnier.fuegeTeilnehmerHinzu(spieler2);
        turnier.fuegeTeilnehmerHinzu(spieler3);
        turnier.fuegeTeilnehmerHinzu(spieler4);
        turnier.fuegeTeilnehmerHinzu(spieler5);
        turnier.fuegeTeilnehmerHinzu(spieler6);
        turnier.fuegeTeilnehmerHinzu(spieler7);
        turnier.fuegeTeilnehmerHinzu(spieler8);
        //turnier.fuegeTeilnehmerHinzu(spieler9);
        //turnier.fuegeTeilnehmerHinzu(spieler10);
        //turnier.fuegeTeilnehmerHinzu(spieler11);
        //turnier.fuegeTeilnehmerHinzu(spieler12);
        //turnier.fuegeTeilnehmerHinzu(spieler13);

        turnier.setzeRundenProSpiel(20);
        turnier.starteTurnier();

        TurnierExporter exporter = new TurnierExporter();
        exporter.schreibeHtmlMitAuswerung(turnier);
    }
}
