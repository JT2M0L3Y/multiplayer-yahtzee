package edu.gonzaga.ScoreCardTests.ScoreLineTests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import edu.gonzaga.Hand;
import edu.gonzaga.ScoreCard.ScoreLines.BonusLine;
import edu.gonzaga.ScoreCard.ScoreLines.UpperScoreLine;

public class BonusLineTest {
    
    @Test
    void scoringNoBonus(){
        UpperScoreLine lineToWatch = new UpperScoreLine("Dummy Name", "Dummy Explanation", 1, 1);
        lineToWatch.setScore(1, 9);
        BonusLine dummyLine = new BonusLine("Dummy Name", "Dummy Explanation", lineToWatch);
        dummyLine.calculateScore(new Hand());
        int expectedScore = 0;
        int actualScore = dummyLine.getScore(1);
        assertEquals(expectedScore, actualScore);
    }

    @Test
    void scoringWithBonus(){
        UpperScoreLine lineToWatch = new UpperScoreLine("Dummy Name", "Dummy Explanation", 1, 1);
        lineToWatch.setScore(1, 70);
        BonusLine dummyLine = new BonusLine("Dummy Name", "Dummy Explanation", lineToWatch);
        dummyLine.calculateScore(new Hand());
        int expectedScore = 35;
        int actualScore = dummyLine.getScore(1);
        assertEquals(expectedScore, actualScore);
    }

}
