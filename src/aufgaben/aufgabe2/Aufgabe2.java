package aufgaben.aufgabe2;

public class Aufgabe2 {

    public static void main(String[] args) {

        /* Aufgabe 2 */
        for (int i = 1; i <= 10; i++) {

            System.out.println(i);
        }

        String name = "Philipp";
        for (int i = 0; i < 7; i++) {

            System.out.println(name.charAt(i));
        }

        for (int i = 1; i <= 10; i++) {

            for (int j = 1; j <= 3; j++) {

                System.out.println(i);
            }
        }

        for (int i = 0; i < 8; i++) { // führt zu einer Exception. Das 8. Zeichen gibt es im String nicht

            System.out.println(name.charAt(i));
        }
    }
}
