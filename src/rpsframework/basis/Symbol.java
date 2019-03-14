package rpsframework.basis;

import java.security.SecureRandom;

/**
 * Die Basissymbole, mit denen wir spielen
 */
public enum Symbol {

    /* Die eigentlichen Symbole als enumeration Konstante */
    STEIN, PAPIER, SCHERE;

    private static final SecureRandom randomMechanism = new SecureRandom();

    /**
     * Wahr, wenn das erste Symbol das zweite schlägt. In allen anderen Fällen gewinnt entweder das zweite Symbol oder
     * das Ergebnis ist unentschieden.
     * @param symbol1 Das erste zu prüfende Symbol. Die Methode gibt wahr zurück, wenn dieses Symbol gewinnt.
     * @param symbol2 Das zweite zu prüfende Symbol.
     * @return Die Methode gibt wahr zurück, wenn das erste Symbol gewinnt. Sie gibt falsch zurück, wenn entweder das
     * zweite Symbol gewinnt oder beide Symbole gleich sind (unentschieden).
     */
    public static boolean symbolEinsSchlaegtSymbolZwei(Symbol symbol1, Symbol symbol2) {

        // Wir prüfen nur die Gewinnfälle für das erste Symbol ab und unterscheiden nicht zwischen Unentschieden und Sieg für Symbol 2.
        return (symbol1.equals(STEIN) && symbol2.equals(SCHERE))
                || (symbol1.equals(PAPIER) && symbol2.equals(STEIN))
                || (symbol1.equals(SCHERE) && symbol2.equals(PAPIER));
    }

    public static Symbol getRandom() {

        return Symbol.values()[randomMechanism.nextInt(Symbol.values().length)];
    }
}
