package aufgaben.aufgabe1;

public class Aufgabe1 {

    public static void main(String[] args) {

        /* Aufgabe 1 */

        System.out.println("Hallo Welt!");
        System.out.println(32523 + 312556 * 2);
        System.out.println(32523 + (312556 * 2)); // Java berücksichtigt automatisch Punkt- vor Strichrechnung
        System.out.println(1 > 2);
        System.out.println("Spieler 1 (Stein) vs. Spieler 2 (Schere): Spieler 1 gewinnt!");
        String text = "Spieler 1 (Stein) vs. Spieler 2 (Schere): Spieler 1 gewinnt!";
        System.out.println(text);
        String a = "HalloWelt!";
        int b = 5;
        System.out.println(a + b);




        /* Aufgabe 1 für Fortgeschrittene */

        // Es gibt mehrere Möglichkeiten, diese Aufgabe zu lösen. Eine Möglichkeit sieht so aus:
        String halloWelt = "Hallo Welt!";
        for (int i = halloWelt.length(); i > 0; i--){

            System.out.println(halloWelt.charAt(i -1));
            halloWelt = halloWelt.substring(0, halloWelt.length() - 1);
        }

        /* Das Problem für die Multiplikation ist die Größe eines Integers. Die größte mögliche Zahl im Datentyp Integer
         * ist 2147483647. Addiert man jetzt noch 1 dazu, läuft der Datentyp über und springt zu -2147483648.
         * Man braucht also einen anderen Datentyp (long).
         */
        System.out.println(2147483647 * 2); // Überlauf
        System.out.println(2147483647l * 2); // kein Überlauf, korrektes Ergebnis

        /* == testet auf Objektgleichheit. equals testet anhand bestimmter Eigenschaften (hier: alle Zeichen dieselben)
         * des Objekts auf Gleichheit.
         */
        String string1 = "hallo";
        String string2 = "hallo";
        String string3 = "hallohallo";

        System.out.println(string1 + string2);
        System.out.println(string3);

        System.out.println((string1 + string2) == string3);
        System.out.println((string1 + string2).equals(string3));
    }
}
