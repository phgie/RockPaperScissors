package rpsframework.basis;

/**
 * Die Vorgabe fuer einen SteinScherePapierSpieler.
 *
 * Ein Spieler kann jederzeit innerhalb einer Spielrunde nach einem Symbol gefragt werden und muss dieses dann zurückgeben.
 * Ein Spieler sollte sich die aktuelle Spielrunde merken, um seine Taktik während des Spiels gegen einen Gegner anzupassen.
 *
 */
public interface SteinScherePapierSpieler {

    /**
     * Fragt den Spieler nach dem naechsten Symbol, welches er spielen moechte.
     * @return Das naechste Symbol
     */
    Symbol gibSymbol();

    /**
     * Teil dem Spieler mit, dass ein neues Spiel gegen einen neuen Gegner beginnt. Es ist ratsam, alle Informationen fuer
     * das vorherige Spiel zu verwerfen, da nicht garantiert wird, dass man direkt wieder gegen denselben Spieler spielt.
     */
    void starteNeuesSpiel();
}
