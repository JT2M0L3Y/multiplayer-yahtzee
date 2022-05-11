package edu.gonzaga.ScoreCardTests.ScoreLineTests;

import org.junit.jupiter.api.Test;
import edu.gonzaga.Hand;
import edu.gonzaga.ScoreCard.ScoreLines.ChanceLine;
import static org.junit.jupiter.api.Assertions.*;

public class ChanceLineTest {
    
    @Test
    void testScoreHandOfOnes(){
        ChanceLine dummyLine = new ChanceLine("Dummy Name", "DummyExplanation");
        dummyLine.calculateScore(new Hand());
        int expectedScore = 5;
        int actualScore = dummyLine.getPossibleScore(1);
        assertEquals(expectedScore, actualScore);
    }

    @Test
    void testScoreHandOfSixes(){
        ChanceLine dummyLine = new ChanceLine("Dummy Name", "DummyExplanation");
        int[] handValues = {6,6,6,6,6};
        dummyLine.calculateScore(new Hand(handValues));
        int expectedScore = 30;
        int actualScore = dummyLine.getPossibleScore(1);
        assertEquals(expectedScore, actualScore);
    }

    @Test
    void testScoreMixedHand(){
        ChanceLine dummyLine = new ChanceLine("Dummy Name", "DummyExplanation");
        int[] handValues = {1,2,3,4,5};
        dummyLine.calculateScore(new Hand(handValues));
        int expectedScore = 15;
        int actualScore = dummyLine.getPossibleScore(1);
        assertEquals(expectedScore, actualScore);
    }

}
