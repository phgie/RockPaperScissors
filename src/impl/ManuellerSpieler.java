package impl;

import rpsframework.basis.SteinScherePapierSpieler;
import rpsframework.basis.Symbol;
import rpsframework.turnier.Duell;

import java.util.*;

/**
 * Ein Spieler kann...
 *
 * ... an einem Spiel gegen einen anderen Spieler teilnehmen
 * ....an einem Turnier teilnehmen und dabei gegen mehrere Spieler ein Spiel bestreiten
 */
public class ManuellerSpieler implements SteinScherePapierSpieler {

    @Override
    public String getName() {
        return "Du";
    }

    @Override
    public Symbol gibSymbol() {
        System.out.println("Welches Symbol möchtest du spielen?");
        System.out.println("[1] Stein");
        System.out.println("[2] Schere");
        System.out.println("[3] Papier");

        Scanner sc = new Scanner(System.in);
        int eingabe = sc.nextInt();

        Symbol auswahl;
        switch (eingabe) {
            case 1:
                auswahl = Symbol.STEIN;
                break;
            case 2:
                auswahl = Symbol.SCHERE;
                break;
            case 3:
                auswahl = Symbol.PAPIER;
                break;
            default:
                auswahl = Symbol.STEIN;
                break;
        }

        return auswahl;
    }

    @Override
    public void starteNeuesSpiel(int runden) {
        System.out.println("Ein neue Spiel beginnt!");
    }

    @Override
    public void nimmDuell(Duell duell, int runde) {

    }
}
