package edu.gonzaga.ScoreCardTests.ScoreLineTests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import edu.gonzaga.*;
import edu.gonzaga.ScoreCard.ScoreLines.UpperScoreLine;

public class UpperScoreLineTest {
    
    @Test
    void testOnesRowAllOnesCalcScore(){
        UpperScoreLine dummyLine = new UpperScoreLine("Dummy Name", "Dummy Explanation", 1, 1);
        Hand dummyHand = new Hand();
        dummyLine.calculateScore(dummyHand);
        int expectedScore = 5;
        int actualScore = dummyLine.getPossibleScore(1);
        assertEquals(expectedScore, actualScore);
    }

    @Test
    void testOnesNoOnesCalcScore(){
        UpperScoreLine dummyLine = new UpperScoreLine("Dummy Name", "Dummy Explanation", 1, 1);
        int[] handValues = {2,2,2,2,2};
        Hand dummyHand = new Hand(handValues);
        dummyLine.calculateScore(dummyHand);
        int expectedScore = 0;
        int actualScore = dummyLine.getPossibleScore(1);
        assertEquals(expectedScore, actualScore);
    }

    @Test
    void testSixesAllSixesCalcScore(){
        UpperScoreLine dummyLine = new UpperScoreLine("Dummy Name", "Dummy Explanation", 6, 1);
        int[] handValues = {6,6,6,6,6};
        Hand dummyHand = new Hand(handValues);
        dummyLine.calculateScore(dummyHand);
        int expectedScore = 30;
        int actualScore = dummyLine.getPossibleScore(1);
        assertEquals(expectedScore, actualScore);
    }

    @Test
    void testSixesNoSixesCalcScore(){
        UpperScoreLine dummyLine = new UpperScoreLine("Dummy Name", "Dummy Explanation", 6, 1);
        int[] handValues = {4,4,4,4,4};
        Hand dummyHand = new Hand(handValues);
        dummyLine.calculateScore(dummyHand);
        int expectedScore = 0;
        int actualScore = dummyLine.getPossibleScore(1);
        assertEquals(expectedScore, actualScore);
    }

}
