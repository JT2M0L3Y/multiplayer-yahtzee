package edu.gonzaga.ScoreCardTests.ScoreLineTests;

import org.junit.jupiter.api.Test;
import edu.gonzaga.Hand;
import edu.gonzaga.ScoreCard.ScoreLines.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

public class TotalScoreLineTest {

    @Test
    void testTotalWithScores(){
        UpperScoreLine lineToWatch = new UpperScoreLine("Dummy", "Dummy", 1, 1);
        UpperScoreLine lineToWatch2 = new UpperScoreLine("Dummy", "Dummy", 1, 1);
        lineToWatch.setScore(1, 1);
        lineToWatch2.setScore(1, 1);
        TotalScoreLine dummyLine = new TotalScoreLine("Dummy", "Dummy", new ArrayList<ScoreLine>(){{
            add(lineToWatch);
            add(lineToWatch2);
        }});
        dummyLine.calculateScore(new Hand());
        int expectedScore = 2;
        int actualScore = dummyLine.getScore(1);
        assertEquals(expectedScore, actualScore);
    }

    @Test
    void testTotalWithoutScores(){
        UpperScoreLine lineToWatch = new UpperScoreLine("Dummy", "Dummy", 1, 1);
        UpperScoreLine lineToWatch2 = new UpperScoreLine("Dummy", "Dummy", 1, 1);
        TotalScoreLine dummyLine = new TotalScoreLine("Dummy", "Dummy", new ArrayList<ScoreLine>(){{
            add(lineToWatch);
            add(lineToWatch2);
        }});
        dummyLine.calculateScore(new Hand());
        int expectedScore = 0;
        int actualScore = dummyLine.getScore(1);
        assertEquals(expectedScore, actualScore);
    }
    
    @Test
    void testTotalSomeScored(){
        UpperScoreLine lineToWatch = new UpperScoreLine("Dummy", "Dummy", 1, 1);
        UpperScoreLine lineToWatch2 = new UpperScoreLine("Dummy", "Dummy", 1, 1);
        lineToWatch.setScore(1, 1);
        TotalScoreLine dummyLine = new TotalScoreLine("Dummy", "Dummy", new ArrayList<ScoreLine>(){{
            add(lineToWatch);
            add(lineToWatch2);
        }});
        dummyLine.calculateScore(new Hand());
        int expectedScore = 1;
        int actualScore = dummyLine.getScore(1);
        assertEquals(expectedScore, actualScore);
    }

}
