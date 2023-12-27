package edu.gonzaga;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    @Test
    void testNumDiceSetAndGet() {
        int expectedValue = 5;
        Game game = new Game();
        game.setNumDice(5);
        assertEquals(expectedValue, game.getDice());
    }

    @Test
    void testNumRollsSetAndGet() {
        int expectedValue = 3;
        Game game = new Game();
        game.setNumRolls(3);
        assertEquals(expectedValue, game.getRolls());
    }

    @Test
    void testNumSidesSetAndGet() {
        int expectedValue = 6;
        Game game = new Game();
        game.setNumSides(6);
        assertEquals(expectedValue, game.getSides());
    }
}
