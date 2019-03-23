package aufgaben;

public class Aufgabe2 {

    public static void main(String[] args) {

        /* Aufgabe 2 */

        //------------------------------
        // Aufgabe: Gib die Zahlen von 1 bis 10 zeilenweise aus. Benutze dafür eine Schleife.

        for (int i = 1; i <= 10; i++) {

            System.out.println(i);
        }

        //------------------------------
        // Aufgabe: Speichere deinen Namen in einer Variablen. Gib nun jeden Buchstaben einzeln zeilenweise aus.
        // Benutze dafür eine Schleife und die Methode charAt(int) der Klasse String (z.B. "Philipp".charAt(2) gibt 'i' zurück).

        String name = "Philipp";

        for (int i = 0; i < 7; i++) {

            System.out.println(name.charAt(i));
        }

        //------------------------------
        // Aufgabe: Gib die Zahlen von 1 bis 10 zeilenweise aus, aber gib jede Zahl jeweils dreimal aus. Du darfst
        // System.out.println() nur einmal verwenden! Nutze dafür eine Schleife in einer Schleife.

        for (int i = 1; i <= 10; i++) {

            for (int j = 1; j <= 3; j++) {

                System.out.println(i);
            }
        }

        //------------------------------
        // Aufgabe: Bei Schleifen muss man aufpassen, dass man nicht "über das Ziel hinaus läuft". Nimm wieder deinen
        // Namen als Variable wie oben, aber lasse die Schleife diesmal weiter laufen. Was wird dir in der Kommandozeile
        // angezeigt? Weißt du, warum das passiert? Warum ist das ein Problem?

        for (int i = 0; i < 8; i++) { // führt zu einer Exception. Das 8. Zeichen gibt es im String nicht

            System.out.println(name.charAt(i));
        }
    }
}
