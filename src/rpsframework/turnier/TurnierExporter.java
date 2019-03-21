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
            List<SteinScherePapierSpieler> teilnehmerListe = turnier.gibTeilnehmer();
            for (int i = 0; i < turnier.gibAnzahlSpieler(); ++i) {
                SteinScherePapierSpieler spieler1 = teilnehmerListe.get(i);
                for (int j = 0; j < turnier.gibAnzahlSpieler(); ++j) {
                    if (i != j) {
                        SteinScherePapierSpieler spieler2 = teilnehmerListe.get(j);
                        writer = new BufferedWriter(new FileWriter("static/begegnung/" + gibBegegnungstitel(spieler1, spieler2) + ".html"));
                        writer.write(gibSpielAuswertung(turnier, spieler1, spieler2));
                        writer.close();
                    }
                }
                writer = new BufferedWriter(new FileWriter("static/teilnehmer/" + gibSpielerID(spieler1) + ".html"));
                writer.write(gibSpielerStatistik(turnier, spieler1));
                writer.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String gibSpielerID(SteinScherePapierSpieler spieler1) {
        return spieler1.getClass().getSimpleName() + +spieler1.getSpielernummer();
    }

    private String gibBegegnungstitel(SteinScherePapierSpieler spieler1, SteinScherePapierSpieler spieler2) {
        return spieler1.getClass().getSimpleName() + spieler1.getSpielernummer()
                + "_vs_" +
                spieler2.getClass().getSimpleName() + spieler2.getSpielernummer();
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
        return gibSpieleMatrix(turnier, turnier.gibTeilnehmer().toArray(new SteinScherePapierSpieler[0]));
    }

    private String gibSpieleMatrix(Turnier turnier, SteinScherePapierSpieler... abgefragteSpieler) {
        StringBuilder builder = new StringBuilder();
        builder.append("<div id=\"content\">");
        builder.append("<table class=\"").append("result-matrix").append("\">");

        List<SteinScherePapierSpieler> alleTeilnehmer = turnier.gibTeilnehmer();
        builder.append("<tr>").append("<td/>");
        for (SteinScherePapierSpieler spieler : alleTeilnehmer)
            builder.append("<td>").append(spieler.getName()).append("</td>");
        builder.append("</tr>");

        for (SteinScherePapierSpieler teilnehmer : abgefragteSpieler) {
            builder.append("<tr>");
            builder.append("<td>").append(teilnehmer.getName()).append("</td>");
            for (SteinScherePapierSpieler gegner : alleTeilnehmer) {
                if (teilnehmer.equals(gegner))
                    builder.append("<td class=\"no-match\"/>");
                else {
                    Spiel begegnung = turnier.gibSpiel(teilnehmer, gegner);
                    int punkteTeilnehmer = begegnung.gibSpielerPunkte(teilnehmer);
                    int punkteGegner = begegnung.gibSpielerPunkte(gegner);
                    String tdClass;
                    if (punkteTeilnehmer > punkteGegner)
                        tdClass = "win-match";
                    else if (punkteTeilnehmer < punkteGegner)
                        tdClass = "lose-match";
                    else
                        tdClass = "draw-match";
                    builder.append("<td class=\"").append(tdClass).append("\">")
                            .append(String.format("<a href=\"/RockPaperScissors/static/begegnung/%s.html\">", gibBegegnungstitel(teilnehmer, gegner)))
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

        return String.format(DEFAULT_HTML_TO_FORMAT, gibSpieleMatrix(turnier) + gibPunkteAllerSpieler(turnier));
    }

    private String gibSpielerStatistik(Turnier turnier, SteinScherePapierSpieler spieler) {
        StringBuilder builder = new StringBuilder().append(gibSpieleMatrix(turnier, spieler));
        builder.append("<div id=\"content\">");
        builder.append("<table class=\"").append("points-by-player").append("\">");
        builder.append("<tr>")
                .append("<td>").append("Gegner").append("</td>")
                .append("<td>").append("Duell gewonnen").append("</td>")
                .append("<td>").append("Unentschieden gespielt").append("</td>")
                .append("<td>").append("Duell verloren").append("</td>")
                .append("<td>").append("Stein gespielt").append("</td>")
                .append("<td>").append("Papier gespielt").append("</td>")
                .append("<td>").append("Schere gespielt").append("</td>")
                .append("</tr>");

        List<SteinScherePapierSpieler> teilnehmerListe = turnier.gibTeilnehmer();
        teilnehmerListe.sort(Comparator.comparing(turnier::zaehleSpielerPunkte).reversed());


        for (int i = 0; i < turnier.gibAnzahlSpieler(); ++i) {
            SteinScherePapierSpieler gegner = teilnehmerListe.get(i);

            if (!gegner.equals(spieler)) {
                Spiel begegnung = turnier.gibSpiel(spieler, gegner);
                builder.append("<tr>");
                builder.append("<td>").append(gegner.getName()).append("</td>");
                int spielerPunkte = begegnung.gibSpielerPunkte(spieler);
                int gegnerPunkte = begegnung.gibSpielerPunkte(gegner);
                builder.append("<td>").append(spielerPunkte).append("</td>");
                builder.append("<td>").append(begegnung.gibAnzahlRunden() - spielerPunkte - gegnerPunkte).append("</td>");
                builder.append("<td>").append(gegnerPunkte).append("</td>");
                builder.append("<td>").append(begegnung.zaehleSymbolFuerSpieler(spieler, Symbol.STEIN)).append("</td>");
                builder.append("<td>").append(begegnung.zaehleSymbolFuerSpieler(spieler, Symbol.PAPIER)).append("</td>");
                builder.append("<td>").append(begegnung.zaehleSymbolFuerSpieler(spieler, Symbol.SCHERE)).append("</td>");
                builder.append("</tr>");
            }
        }

        builder.append("</table>");
        builder.append("</div>");

        return String.format(DEFAULT_HTML_TO_FORMAT, builder.toString());
    }

    private String gibPunkteAllerSpieler(Turnier turnier) {
        StringBuilder builder = new StringBuilder();
        builder.append("<div id=\"content\">");
        builder.append("<table class=\"").append("points-by-player").append("\">");
        builder.append("<tr>")
                .append("<td>").append("Spielername").append("</td>")
                .append("<td>").append("Gesamtpunktzahl").append("</td>")
                .append("<td>").append("Gewonnen").append("</td>")
                .append("<td>").append("Unentschieden").append("</td>")
                .append("<td>").append("Verloren").append("</td>")
                .append("<td>").append("Stein gespielt").append("</td>")
                .append("<td>").append("Papier gespielt").append("</td>")
                .append("<td>").append("Schere gespielt").append("</td>")
                .append("</tr>");

        List<SteinScherePapierSpieler> teilnehmerListe = turnier.gibTeilnehmer();
        teilnehmerListe.sort(Comparator.comparing(turnier::zaehleSpielerPunkte).reversed());


        for (int i = 0; i < turnier.gibAnzahlSpieler(); ++i) {
            SteinScherePapierSpieler teilnehmer = teilnehmerListe.get(i);
            int siege = 0, unentschieden = 0, verloren = 0;
            for (SteinScherePapierSpieler gegner : teilnehmerListe) {
                if (!gegner.equals(teilnehmer)) {
                    Spiel begegnung = turnier.gibSpiel(teilnehmer, gegner);
                    int punkteTeilnehmer = begegnung.gibSpielerPunkte(teilnehmer);
                    int punkteGegner = begegnung.gibSpielerPunkte(gegner);

                    if (punkteTeilnehmer > punkteGegner)
                        siege++;
                    else if (punkteTeilnehmer < punkteGegner)
                        verloren++;
                    else
                        unentschieden++;
                }
            }
            builder.append("<tr>");
            builder.append("<td>")
                    .append("<a href=\"").append("/RockPaperScissors/static/teilnehmer/").append(gibSpielerID(teilnehmer)).append(".html\">")
                    .append(teilnehmer.getName())
                    .append("</a>")
                    .append("</td>");
            builder.append("<td>").append(turnier.zaehleSpielerPunkte(teilnehmer)).append("</td>");
            builder.append("<td>").append(siege).append("</td>");
            builder.append("<td>").append(unentschieden).append("</td>");
            builder.append("<td>").append(verloren).append("</td>");
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
