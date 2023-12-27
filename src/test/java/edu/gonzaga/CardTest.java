package edu.gonzaga;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

class CardTest {
    @Test
    void testScoreCount() {
        Integer expectedValue = 13;
        Player player = new Player(new Game(), null);
        Scorecard scorecard = new Scorecard(player.getHand(), null);
        assertEquals(expectedValue, scorecard.getScorelines().size());
    }

    @Test
    void testScorelines() {
        ArrayList<Integer> initialScores = new ArrayList<Integer>();
        Player player = new Player(new Game(), null);
        Scorecard scorecard = new Scorecard(player.getHand(), null);
        for (int i = 0; i < scorecard.getScorelines().size(); i++) {
            initialScores.add(0);
        }
        scorecard.computePossibleScores(player.rollHand());
        for (int i = 0; i < scorecard.getScorelines().size(); i++) {
            assertEquals(initialScores.get(i), scorecard.getScorelines().get(i).getScore());
        }
    }

    @Test
    void testMaxFoundCount() {
        Integer expectedValue = 5;
        ArrayList<Die> hand = new ArrayList<Die>();
        hand.add(0, new Die(expectedValue));
        hand.add(1, new Die(3));
        hand.add(2, new Die(expectedValue));
        hand.add(3, new Die(5));
        hand.add(4, new Die(expectedValue));
        Scorecard scorecard = new Scorecard(hand, null);
        Integer actualValue = scorecard.findMaxOfAKind(hand);
        assertEquals(expectedValue, actualValue);
    }

    @Test
    void testSmlStraightSearch() {
        ArrayList<Die> hand = new ArrayList<Die>();
        hand.add(new Die(6, 2));
        hand.add(new Die(6, 3));
        hand.add(new Die(6, 4));
        hand.add(new Die(6, 5));
        hand.add(new Die(6, 4));
        Scorecard scorecard = new Scorecard(hand, null);
        assertTrue(scorecard.findSmlStraight(hand));
    }

    @Test
    void testLrgStraightSearch() {
        ArrayList<Die> hand = new ArrayList<Die>();
        hand.add(new Die(6, 1));
        hand.add(new Die(6, 2));
        hand.add(new Die(6, 3));
        hand.add(new Die(6, 4));
        hand.add(new Die(6, 5));
        Scorecard scorecard = new Scorecard(hand, null);
        assertTrue(scorecard.findLrgStraight(hand));
    }

    @Test
    void testFullHouseSearch() {
        ArrayList<Die> hand = new ArrayList<Die>();
        hand.add(new Die(6, 2));
        hand.add(new Die(6, 2));
        hand.add(new Die(6, 3));
        hand.add(new Die(6, 3));
        hand.add(new Die(6, 3));
        Scorecard scorecard = new Scorecard(hand, null);
        assertTrue(scorecard.findFullHouse(hand));
    }

    @Test
    void testYahtzeeSearch() {
        ArrayList<Die> hand = new ArrayList<Die>();
        hand.add(new Die(6, 4));
        hand.add(new Die(6, 4));
        hand.add(new Die(6, 4));
        hand.add(new Die(6, 4));
        hand.add(new Die(6, 4));
        Scorecard scorecard = new Scorecard(hand, null);
        assertTrue(scorecard.findYahtzee(hand));
    }

    @Test
    void testSumOfDice() {
        Integer expectedValue = 16;
        ArrayList<Die> hand = new ArrayList<Die>();
        hand.add(new Die(6, 2));
        hand.add(new Die(6, 3));
        hand.add(new Die(6, 4));
        hand.add(new Die(6, 5));
        hand.add(new Die(6, 2));
        Scorecard scorecard = new Scorecard(hand, null);
        assertEquals(expectedValue, scorecard.totalAllDice(hand));
    }
}
