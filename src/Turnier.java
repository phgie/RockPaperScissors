import java.util.ArrayList;

/**
 * TODO: Das eigentliche Turnier implementieren
 */
public class Turnier {

    private ArrayList<Spieler> teilnehmer;

    public Turnier() {

        this.teilnehmer = new ArrayList<>();
    }

    public void fuegeTeilnehmerHinzu(Spieler teilnehmer) {

        this.teilnehmer.add(teilnehmer);
    }
}
