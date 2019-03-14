package rpsframework.strategie;

import rpsframework.basis.Symbol;

import java.util.ArrayList;

public class Angriffsmuster {

    private Symbol[] symbole;

    private WiederholungsTaktik wiederholungsTaktik;

    private enum WiederholungsTaktik {
        WIEDER_VON_VORNE, ENDLOSE_WIEDERHOLUNG_DES_LETZTEN_SYMBOLS;
    }

    private Angriffsmuster(WiederholungsTaktik wiederholungsTaktik, Symbol ...symbole) {
        this.wiederholungsTaktik = wiederholungsTaktik;
        this.symbole = symbole;
    }

    public Symbol gibNaechstesSymbol(int wievielteRunde) {
        switch (wiederholungsTaktik) {
            default:
            case WIEDER_VON_VORNE:
                return symbole[wievielteRunde % symbole.length];
            case ENDLOSE_WIEDERHOLUNG_DES_LETZTEN_SYMBOLS:
                return symbole[Math.min(wievielteRunde, symbole.length - 1)];
        }
    }

    public static AngriffsmusterBuilder zuErst(Symbol erstesSymbol) {
        return new AngriffsmusterBuilder().symbolHinzufuegen(erstesSymbol);
    }

    public static class AngriffsmusterBuilder {
        private ArrayList<Symbol> symbole = new ArrayList<>();
        private Symbol zuletztHinzugefuegtesSymbol = null;

        private AngriffsmusterBuilder() {}

        AngriffsmusterBuilder symbolHinzufuegen(Symbol naechstesSymbol) {
            symbole.add(naechstesSymbol);
            zuletztHinzugefuegtesSymbol = naechstesSymbol;
            return this;
        }

        public AngriffsmusterBuilder dann(Symbol naechstesSymbol) {
            return this.symbolHinzufuegen(naechstesSymbol);
        }

        public AngriffsmusterBuilder mehrmals(int anzahlWiederholungen) {
            for (int i = 1; i < anzahlWiederholungen; ++i)
                symbole.add(zuletztHinzugefuegtesSymbol);
            return this;
        }

        public Angriffsmuster undWiederVonVorne() {
            return new Angriffsmuster(WiederholungsTaktik.WIEDER_VON_VORNE, symbole.toArray(new Symbol[0]));
        }

        public Angriffsmuster bisZumSchluss() {
            return new Angriffsmuster(WiederholungsTaktik.ENDLOSE_WIEDERHOLUNG_DES_LETZTEN_SYMBOLS, symbole.toArray(new Symbol[0]));
        }
    }
}
