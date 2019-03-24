package aufgaben;

import aufgaben.aufgabe6.Auto;
import aufgaben.aufgabe6.Fahrrad;

public class Main {

    public static void main(String[] args) {

        //Aufgabe 4
        System.out.println("------------------------");
        System.out.println("Aufgabe 4");
        System.out.println("------------------------");

        aufgaben.aufgabe4.Fahrzeug fahrzeug = new aufgaben.aufgabe4.Fahrzeug();
        System.out.println(fahrzeug.gibFarbe());
        System.out.println(fahrzeug.gibAnzahlRaeder());

        //Aufgabe 5
        System.out.println("------------------------");
        System.out.println("Aufgabe 5");
        System.out.println("------------------------");

        aufgaben.aufgabe5.Fahrzeug fahrzeug2 = new aufgaben.aufgabe5.Fahrzeug("Gelb", 4);
        aufgaben.aufgabe5.Fahrzeug fahrzeug3 = new aufgaben.aufgabe5.Fahrzeug("Grün", 2);
        System.out.println("Fahrzeug 1 ist " + fahrzeug2.gibFarbe() + " und hat " + fahrzeug2.gibAnzahlRaeder() + " Räder");
        System.out.println("Fahrzeug 2 ist " + fahrzeug3.gibFarbe() + " und hat " + fahrzeug3.gibAnzahlRaeder() + " Räder");

        //Aufgabe 6
        System.out.println("------------------------");
        System.out.println("Aufgabe 6");
        System.out.println("------------------------");

        Auto auto = new Auto("Gelb");
        Fahrrad fahrrad = new Fahrrad("Grün");

        System.out.println("Das Auto ist " + auto.gibFarbe() + " und hat " + auto.gibAnzahlRaeder() + " Räder");
        System.out.println("Das Fahrrad ist " + fahrrad.gibFarbe() + " und hat " + fahrrad.gibAnzahlRaeder() + " Räder");
    }
}
