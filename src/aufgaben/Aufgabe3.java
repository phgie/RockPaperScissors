package aufgaben;

public class Aufgabe3 {

    public static void main(String[] args) {

        /* Aufgabe 3 */
        System.out.println("------------------------");
        System.out.println("Aufgabe 3");
        System.out.println("------------------------");

        // Aufgabe: Nimm wieder deine Schleife, die Zahlen von 1 bis 10 ausgibt. Erweitere die Schleife so, dass alle
        // ungeraden Zahlen doppelt ausgegeben werden. Tipp: Eventuell ist der %-Operator hilfreich. ;-)
        for (int i = 1; i <= 10; i++) {

            System.out.println(i);
            if (i % 2 == 1) {

                System.out.println(i);
            }
        }

        //------------------------------
        // Aufgabe: Multipliziere jetzt alle geraden Zahlen mit 2 bevor du sie jeweils einmal ausgibst, die
        // ungeraden Zahlen sollen nach wie vor doppelt ausgegeben werden. (Also: 1 1 4 3 3 8 5 5 ..)

        for (int i = 1; i <= 10; i++) {

            if (i % 2 == 0) {

                System.out.println(i * 2);
            } else {

                System.out.println(i);
                System.out.println(i);
            }
        }

        //------------------------------
        // Aufgabe: Speichere deinen Namen in einer Variablen und lass diese in einer Schleife buchstabenweise ausgeben
        // (siehe Aufgabe 2). Gib aber keine Vokale (a, e, i, o, u) aus.

        String name = "Philipp";
        for (int i = 0; i < name.length(); i++) {

            if (name.charAt(i) == 'a') {


            } else if (name.charAt(i) == 'e') {


            } else if (name.charAt(i) == 'o') {


            } else if (name.charAt(i) == 'u') {


            } else if (name.charAt(i) == 'i') {


            } else {

                System.out.println(name.charAt(i));
            }
        }

        /* Es gibt auch folgende Möglichkeit: */

        String hackerSchool = "Hacker School";

        for (int i = 0; i < hackerSchool.length(); i++) {

            if (hackerSchool.charAt(i) != 'a' && hackerSchool.charAt(i) != 'e'
                    && hackerSchool.charAt(i) != 'u' && hackerSchool.charAt(i) != 'i' && hackerSchool.charAt(i) != 'o') {

                System.out.println(hackerSchool.charAt(i));
            }
        }
    }
}
