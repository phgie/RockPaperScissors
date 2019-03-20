package rpsframework.turnier;

import rpsframework.basis.Spiel;
import rpsframework.basis.SteinScherePapierSpieler;
import rpsframework.basis.Symbol;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;

public class TurnierExporter {

    private static final String DEFAULT_HTML_TO_FORMAT = "<html>" +
            "<head><link rel=\"stylesheet\" href=\"style.css\"/></head>" +
            "<body><h1 align=\"center\">Stein, Schere, Papier Turnier</h1><br>%s</body>" +
            "</html>";

    public void schreibeHtmlMitAuswerung(Turnier turnier) {
        try {
            // Schreibe zu erst eine Gesamtauswertung für das Turnier
            BufferedWriter writer = new BufferedWriter(new FileWriter("static/Turnier.html"));
            writer.write(gibTurnierAuswertung(turnier));
            writer.close();

            // anschließend schreibe für jedes Spiel eine eigene Auswertung
            for (int i = 0; i < turnier.gibAnzahlSpieler(); ++i) {
                for (int j = 0; j < turnier.gibAnzahlSpieler(); ++j) {
                    if (i != j) {
                        writer = new BufferedWriter(new FileWriter("static/begegnung/" + i + "_vs_" + j + ".html"));
                        List<SteinScherePapierSpieler> teilnehmerListe = turnier.gibTeilnehmer();
                        writer.write(gibSpielAuswertung(turnier, teilnehmerListe.get(i), teilnehmerListe.get(j)));
                        writer.close();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private String gibSpielAuswertung(Turnier turnier, SteinScherePapierSpieler spieler1, SteinScherePapierSpieler spieler2) {
        Spiel begegnung = turnier.gibSpiel(spieler1, spieler2);

        StringBuilder builder = new StringBuilder();

        builder.append("<table>");
        builder.append("<tr>")
                .append("<td>").append("Runde").append("</td>")
                .append("<td>").append("Symbol von ").append(spieler1.getName()).append("</td>")
                .append("<td>").append("Symbol von ").append(spieler2.getName()).append("</td>")
                .append("</tr>");

        for (int i = 1; i <= begegnung.gibAnzahlRunden(); ++i) {
            Symbol spieler1Symbol = begegnung.gibVonSpielerGespieltesSymbol(spieler1, i);
            Symbol spieler2Symbol = begegnung.gibVonSpielerGespieltesSymbol(spieler2, i);

            String className;
            if (spieler1Symbol.equals(spieler2Symbol))
                className = "draw";
            else if (Symbol.symbolEinsSchlaegtSymbolZwei(spieler1Symbol, spieler2Symbol))
                className = "win-round";
            else
                className = "lose-round";

            builder.append("<tr>");
            builder.append("<td>").append(i).append("</td>");
            builder.append(String.format("<td class=\"%s\">", className))
                    .append(String.format("<img src=\"/RockPaperScissors/static/begegnung/%s.svg\"/>", spieler1Symbol))
                    .append("</td>");
            builder.append("<td>")
                    .append(String.format("<img src=\"/RockPaperScissors/static/begegnung/%s.svg\"/>", spieler2Symbol))
                    .append("</td>");
            builder.append("</tr>");
        }

        builder.append("</table>");
        return String.format(DEFAULT_HTML_TO_FORMAT, builder.toString());
    }

    private String gibSpieleMatrix(Turnier turnier) {
        List<SteinScherePapierSpieler> teilnehmerListe = turnier.gibTeilnehmer();
        StringBuilder builder = new StringBuilder();
        builder.append("<div id=\"content\">");
        builder.append("<table>");

        builder.append("<tr>").append("<td/>");
        for (SteinScherePapierSpieler spieler : teilnehmerListe)
            builder.append("<td>").append(spieler.getName()).append("</td>");
        builder.append("</tr>");

        for (int spielerIndex = 0; spielerIndex < teilnehmerListe.size(); ++spielerIndex) {
            SteinScherePapierSpieler teilnehmer = teilnehmerListe.get(spielerIndex);
            builder.append("<tr>");
            builder.append("<td>").append(teilnehmer.getName()).append("</td>");
            for (int gegnerIndex = 0; gegnerIndex < teilnehmerListe.size(); ++gegnerIndex) {
                SteinScherePapierSpieler gegner = teilnehmerListe.get(gegnerIndex);
                if (spielerIndex <= gegnerIndex)
                    builder.append("<td class=\"no-match\"/>");
                else {
                    Spiel begegnung = turnier.gibSpiel(teilnehmer, gegner);
                    int punkteTeilnehmer = begegnung.gibSpielerPunkte(teilnehmer);
                    int punkteGegner = begegnung.gibSpielerPunkte(gegner);
                    boolean teilnehmerHatGewonnen = punkteTeilnehmer > punkteGegner;
                    builder.append("<td class=\"").append(teilnehmerHatGewonnen ? "win-match" : "lose-match").append("\">")
                            .append(String.format("<a href=\"/RockPaperScissors/static/begegnung/%d_vs_%d.html\">", spielerIndex, gegnerIndex))
                            .append("(S")
                            .append(teilnehmer.getSpielernummer())
                            .append(") ")
                            .append(punkteTeilnehmer)
                            .append(":")
                            .append(punkteGegner)
                            .append(" (S")
                            .append(gegner.getSpielernummer())
                            .append(")")
                            .append("</a>")
                            .append("</td>");
                }
            }
            builder.append("</tr>");
        }
        builder.append("</table>");
        builder.append("</div>");

        return builder.toString();
    }

    public String gibTurnierAuswertung(Turnier turnier) {

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

        return String.format(DEFAULT_HTML_TO_FORMAT, gibSpieleMatrix(turnier) + gibSpielerPunkte(turnier));
    }

    private String gibSpielerPunkte(Turnier turnier) {
        StringBuilder builder = new StringBuilder();
        builder.append("<div id=\"content\">");
        builder.append("<table>");
        builder.append("<tr>")
                .append("<td>").append("Spielername").append("</td>")
                .append("<td>").append("Gesamtpunktzahl").append("</td>")
                .append("<td>").append("Stein gespielt").append("</td>")
                .append("<td>").append("Papier gespielt").append("</td>")
                .append("<td>").append("Schere gespielt").append("</td>")
                .append("</tr>");

        List<SteinScherePapierSpieler> teilnehmerListe = turnier.gibTeilnehmer();
        teilnehmerListe.sort(Comparator.comparing(turnier::zaehleSpielerPunkte).reversed());

        for (int i = 0; i < turnier.gibAnzahlSpieler(); ++i) {
            SteinScherePapierSpieler teilnehmer = teilnehmerListe.get(i);
            builder.append("<tr>");
            builder.append("<td>").append(teilnehmer.getName()).append("</td>");
            builder.append("<td>").append(turnier.zaehleSpielerPunkte(teilnehmer)).append("</td>");
            builder.append("<td>").append(turnier.zaehleSymbolFuerSpieler(teilnehmer, Symbol.STEIN)).append("</td>");
            builder.append("<td>").append(turnier.zaehleSymbolFuerSpieler(teilnehmer, Symbol.PAPIER)).append("</td>");
            builder.append("<td>").append(turnier.zaehleSymbolFuerSpieler(teilnehmer, Symbol.SCHERE)).append("</td>");
            builder.append("</tr>");
        }

        builder.append("</table>");
        builder.append("</div>");
        return builder.toString();
    }
}
