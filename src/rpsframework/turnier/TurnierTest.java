package rpsframework.turnier;

import org.junit.jupiter.api.Test;
import rpsframework.basis.SteinScherePapierSpieler;
import rpsframework.basis.Symbol;

import static org.junit.jupiter.api.Assertions.*;

class TurnierTest extends Turnier {

    @Test
    void steinGegenSchereGegenPapier() {

        Turnier turnier = new Turnier(
                new SteinScherePapierSpieler() {

                    @Override
                    public String getName() {
                        return null;
                    }

                    @Override
                    public Symbol gibSymbol() {
                        return null;
                    }

                    @Override
                    public void vorbereitenAufNeuesSpiel() {

                    }
                },
        )
    }
}