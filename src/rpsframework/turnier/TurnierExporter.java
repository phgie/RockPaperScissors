package rpsframework.turnier;

import rpsframework.basis.Spiel;
import rpsframework.basis.SteinScherePapierSpieler;
import rpsframework.basis.Symbol;

import java.util.List;

public class TurnierExporter {

    public String gibAuswertung(Turnier turnier) {

        int anzahlSpieler = turnier.gibAnzahlSpieler();
        int anzahlSpiele = turnier.gibAnzahlSpiele();

        List<SteinScherePapierSpieler> teilnehmer = turnier.gibTeilnehmer();

        int punkte = turnier.zaehleSpielerPunkte(teilnehmer.get(0));
        int steinFuerSpieler = turnier.zaehleSymbolFuerSpieler(teilnehmer.get(0), Symbol.STEIN);

        int anzahlStein = turnier.zaehleSymbol(Symbol.SCHERE);

        Spiel begegnung = turnier.gibSpiel(teilnehmer.get(0), teilnehmer.get(1));
        int rundenInSpiel = begegnung.gibAnzahlRunden();
        int gespielteRunden = begegnung.gibGespielteRunden();

        Symbol gespieltesSymbol = begegnung.gibVonSpielerGespieltesSymbol(teilnehmer.get(0), 5);
        int steinFuerSpielerInSpiel = begegnung.zaehleSymbolFuerSpieler(teilnehmer.get(0), Symbol.STEIN);
        int punkteBegegnung = begegnung.gibSpielerPunkte(teilnehmer.get(0));

        return "";
    }
}
