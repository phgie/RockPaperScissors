package test.rpsframework.turnier;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import rpsframework.turnier.SpielerMock;
import rpsframework.turnier.Turnier;

class TurnierTest {

    private Turnier turnier;
    private SpielerMock spieler1;
    private SpielerMock spieler2;

    @BeforeEach
    void setUp() {

        this.turnier = new Turnier();
        this.spieler1 = new SpielerMock(1);
        this.spieler2 = new SpielerMock(2);

        this.turnier.fuegeTeilnehmerHinzu(this.spieler1);
        this.turnier.fuegeTeilnehmerHinzu(this.spieler2);
    }

    @Test
    void testeAnzahlSpiele() {

        //TODO
    }

    @Test
    void keinGewinnerWennAlleSpielerDieselbePunktzahlHaben() {

        //TODO
    }
}
