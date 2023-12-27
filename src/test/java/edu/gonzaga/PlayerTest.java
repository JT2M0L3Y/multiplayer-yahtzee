package edu.gonzaga;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

class PlayerTest {
    @Test
    void testCompleteRoll() {
        Player player = new Player(new Game(), null);
        assertNotEquals(player.getHand(), player.rollHand());
    }

    @Test
    void testDieRoll() {
        Player player = new Player(new Game(), null);
        Integer unrolledSide = player.getHand().get(0).getSideUp();
        Integer rolledSide = player.rollHand().get(0).getSideUp();
        assertNotEquals(unrolledSide, rolledSide);
    }

    @Test
    void testSorting() {
        Game game = new Game();
        Player player = new Player(game, null);
        ArrayList<Die> hand = new ArrayList<Die>();
        ArrayList<Die> expectedHand = new ArrayList<Die>();
        for (int i = 0; i < game.getDice(); i++) {
            expectedHand.add(new Die(game.getSides(), i + 1));
        }
        hand.add(new Die(game.getSides(), 4));
        hand.add(new Die(game.getSides(), 2));
        hand.add(new Die(game.getSides(), 1));
        hand.add(new Die(game.getSides(), 5));
        hand.add(new Die(game.getSides(), 3));
        player.sortHand(hand);
        for (int i = 0; i < hand.size(); i++) {
            assertEquals(expectedHand.get(i).getSideUp(), hand.get(i).getSideUp());
        }
    }
}
