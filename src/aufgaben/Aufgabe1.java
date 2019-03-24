package aufgaben;

public class Aufgabe1 {

    public static void main(String[] args) {

        /* Aufgabe 1 */
        System.out.println("------------------------");
        System.out.println("Aufgabe 1");
        System.out.println("------------------------");

        // Aufgabe: Gib "Hallo Welt!" auf der Kommandozeile aus. Tipp: Nutze den Befehl System.out.println();

        System.out.println("Hallo Welt!");

        //------------------------------
        // Aufgabe: Gib das Ergebnis von 32523 + 312556 * 2 auf der Kommandozeile aus.

        System.out.println(32523 + 312556 * 2);
        System.out.println(32523 + (312556 * 2)); // Java berücksichtigt automatisch Punkt- vor Strichrechnung

        //------------------------------
        // Aufgabe: Gib das Ergebnis von 1 > 2 auf der Kommandozeile aus.

        System.out.println(1 > 2);

        //------------------------------
        // Aufgabe: Gib einen Text aus, in dem zwei Spieler gegeneinander ein Symbol (Stein, Papier, Schere) spielen.

        System.out.println("Spieler 1 (Stein) vs. Spieler 2 (Schere): Spieler 1 gewinnt!");

        //------------------------------
        // Aufgabe: Speichere diesen Text nun in einer Variablen und gib den Inhalt der Variablen auf der Kommandozeile aus.
        String text = "Spieler 1 (Stein) vs. Spieler 2 (Schere): Spieler 1 gewinnt!";
        System.out.println(text);

        //------------------------------
        // Aufgabe: Speichere einen Text in einer Variablen a und eine Zahl in Variable b. Gib beides zusammen in einer
        // Zeile auf der Kommandozeile aus.

        String a = "HalloWelt!";
        int b = 5;
        System.out.println(a + b);

        //------------------------------


        /* Aufgabe 1 für Fortgeschrittene */

        // Aufgabe: Speichere den String "Hallo Welt" und gib jeden Buchstaben des Strings einzeln
        // (jeweils eine neue Zeile) und in umgekehrter Reihenfolge aus. Nutze dafür Methoden der Klasse String.
        // Es gibt mehrere Möglichkeiten, diese Aufgabe zu lösen. Eine Möglichkeit sieht so aus:

        String halloWelt = "Hallo Welt!";
        for (int i = halloWelt.length(); i > 0; i--){

            System.out.println(halloWelt.charAt(i -1));
            halloWelt = halloWelt.substring(0, halloWelt.length() - 1);
        }

        //------------------------------

        // Aufgabe: Gib das (korrekte) Ergebnis von 2147483647 * 2 aus. Tipp: Das richtige Ergebnis ist nicht negativ. ;-)

        // Das Problem für die Multiplikation ist die Größe eines Integers. Die größte mögliche Zahl im Datentyp Integer
        // ist 2147483647. Addiert man jetzt noch 1 dazu, läuft der Datentyp über und springt zu -2147483648.
        // Man braucht also einen anderen Datentyp (long).

        System.out.println(2147483647 * 2); // Überlauf
        System.out.println(2147483647l * 2); // kein Überlauf, korrektes Ergebnis

        //------------------------------

        // Aufgabe: Zeige an einem Beispiel, dass das Vergleichen von Strings mit == keine gute Idee ist. Warum ist das
        // so? Was sollte man stattdessen verwenden?

        // == testet auf Objektgleichheit. equals testet anhand bestimmter Eigenschaften (hier: alle Zeichen dieselben)
        // des Objekts auf Gleichheit.

        String string1 = "hallo";
        String string2 = "hallo";
        String string3 = "hallohallo";

        System.out.println(string1 + string2);
        System.out.println(string3);


        System.out.println((string1 + string2) == string3); // behauptet, dass die Strings nicht gleich sind (sind sie aber)
        System.out.println((string1 + string2).equals(string3)); // korrekte Ausgabe
    }
}
