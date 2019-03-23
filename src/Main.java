import impl.Spieler;
import rpsframework.basis.Symbol;

public class Main {

    public static void main(String[] args) {

        // Spieler 1 erstellen
        Spieler spieler1 = new Spieler(1);
        Symbol symbol = spieler1.gibSymbol();

        System.out.println("Spieler 1 spielt: " + symbol);

        // Erstelle hier drunter einen weiteren Spieler


    }
}
