package edu.gonzaga.ScoreCardTests.ScoreLineTests;

import org.junit.jupiter.api.Test;
import edu.gonzaga.Hand;
import edu.gonzaga.ScoreCard.ScoreLines.*;
import static org.junit.jupiter.api.Assertions.*;

public class OfAKindLineTest {

    @Test
    void test3OfAKind(){
        OfAKindLine dummyLine = new OfAKindLine("Dummy Name", "Dummy Explanation", 3, 1);
        int[] handValue = {1,1,1,2,2};
        dummyLine.calculateScore(new Hand(handValue));
        int expectedScore = 7;
        int actualScore = dummyLine.getPossibleScore(1);
        assertEquals(expectedScore, actualScore);
    }

    @Test
    void test3OfAKindNo3OfAKind(){
        OfAKindLine dummyLine = new OfAKindLine("Dummy Name", "Dummy Explanation", 3, 1);
        int[] handValue = {1,1,3,2,2};
        dummyLine.calculateScore(new Hand(handValue));
        int expectedScore = 0;
        int actualScore = dummyLine.getPossibleScore(1);
        assertEquals(expectedScore, actualScore);
    }

    @Test
    void test4OfAKind(){
        OfAKindLine dummyLine = new OfAKindLine("Dummy Name", "Dummy Explanation", 4, 1);
        int[] handValue = {1,1,1,1,2};
        dummyLine.calculateScore(new Hand(handValue));
        int expectedScore = 6;
        int actualScore = dummyLine.getPossibleScore(1);
        assertEquals(expectedScore, actualScore);
    }

    @Test
    void test4OfAKindNo4OfAKind(){
        OfAKindLine dummyLine = new OfAKindLine("Dummy Name", "Dummy Explanation", 4, 1);
        int[] handValue = {1,1,1,2,2};
        dummyLine.calculateScore(new Hand(handValue));
        int expectedScore = 0;
        int actualScore = dummyLine.getPossibleScore(1);
        assertEquals(expectedScore, actualScore);
    }

    @Test
    void testYahtzee(){
        OfAKindLine dummyLine = new OfAKindLine("Dummy Name", "Dummy Explanation", 5, 1);
        int[] handValue = {1,1,1,1,1};
        dummyLine.calculateScore(new Hand(handValue));
        int expectedScore = 50;
        int actualScore = dummyLine.getPossibleScore(1);
        assertEquals(expectedScore, actualScore);
    }

    @Test
    void testYahtzeeNoYahtzee(){
        OfAKindLine dummyLine = new OfAKindLine("Dummy Name", "Dummy Explanation", 5, 1);
        int[] handValue = {1,1,1,1,2};
        dummyLine.calculateScore(new Hand(handValue));
        int expectedScore = 0;
        int actualScore = dummyLine.getPossibleScore(1);
        assertEquals(expectedScore, actualScore);
    }
    
}
