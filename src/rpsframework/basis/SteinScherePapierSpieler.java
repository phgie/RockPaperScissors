package rpsframework.basis;

/**
 * Die Vorgabe für einen SteinScherePapierSpieler.
 *
 * Ein Spieler kann jederzeit innerhalb einer Spielrunde nach einem Symbol gefragt werden und muss dieses dann zurückgeben.
 * Ein Spieler sollte sich die aktuelle Spielrunde merken, um seine Taktik während des Spiels gegen einen Gegner anzupassen.
 *
 */
public interface SteinScherePapierSpieler {

    /**
     * Gibt den Namen des Spielers zurück.
     * @return Der Name des Spielers als String
     */
    public String getName();

    /**
     * Fragt den Spieler nach dem nächsten Symbol, welches er spielen möchte.
     * @return Das nächste Symbol
     */
    public Symbol gibSymbol();

    /**
     * Teil dem Spieler mit, dass ein neues Spiel gegen einen neuen Gegner beginnt. Es ist ratsam, alle Informationen für
     * das vorherige Spiel zu verwerfen, da nicht garantiert wird, dass man direkt wieder gegen denselben Spieler spielt.
     * @param runden Die Anzahl der Runden für das neue Spiel
     */
    public void starteNeuesSpiel(int runden);

    /**
     * Teilt dem Spieler das Symbol mit, welches der Gegner in der angegebenen Runde gespielt hat.
     * @param symbol Das vom Gegner gespielte Symbol in der angegebenen Runde
     * @param runde Die Spielrunde
     */
    public void nimmGegnerSymbol(Symbol symbol, int runde);
}
