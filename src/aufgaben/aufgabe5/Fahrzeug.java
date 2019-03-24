package aufgaben.aufgabe5;

import aufgaben.aufgabe4.Lampe;

public class Fahrzeug {

    private String farbe;
    private int anzahlRaeder;
    private Lampe beleuchtung;

    public Fahrzeug(String farbe, int anzahlRaeder) {

        this.farbe = farbe;
        this.anzahlRaeder = anzahlRaeder;
        this.beleuchtung = new Lampe();
    }

    public String gibFarbe() {

        return this.farbe;
    }

    public int gibAnzahlRaeder() {

        return this.anzahlRaeder;
    }

    public Lampe gibBeleuchtung() {

        return this.beleuchtung;
    }
}
