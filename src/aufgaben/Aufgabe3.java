package aufgaben;

public class Aufgabe3 {

    public static void main(String[] args) {

        /* Aufgabe 3 */
        for (int i = 1; i <= 10; i++) {

            System.out.println(i);
            if (i % 2 == 1) {

                System.out.println(i);
            }
        }

        for (int i = 1; i <= 10; i++) {

            if (i % 2 == 0) {

                System.out.println(i);
            }
        }

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
        String hckrSchl = "";
        for (int i = 0; i < hackerSchool.length(); i++) {

            if (hackerSchool.charAt(i) != 'a' && hackerSchool.charAt(i) != 'e'
                    && hackerSchool.charAt(i) != 'u' && hackerSchool.charAt(i) != 'i' && hackerSchool.charAt(i) != 'o') {

                hckrSchl = hckrSchl + hackerSchool.charAt(i);
            }
        }

        System.out.println(hckrSchl);

    }
}
