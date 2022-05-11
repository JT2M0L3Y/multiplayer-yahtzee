package edu.gonzaga.ScoreCardTests.ScoreLineTests;

import org.junit.jupiter.api.Test;
import edu.gonzaga.Hand;
import edu.gonzaga.ScoreCard.ScoreLines.*;
import static org.junit.jupiter.api.Assertions.*;

public class FullHouseLineTest {

    @Test
    void testScoreFullHouseSorted(){
        FullHouseLine dummyLine = new FullHouseLine("DummyName", "Dummy Explanation");
        int[] handValues = {1,1,2,2,2};
        dummyLine.calculateScore(new Hand(handValues));
        int expectedScore = 25;
        int actualScore = dummyLine.getPossibleScore(1);
        assertEquals(expectedScore, actualScore);
    }

    @Test
    void testScoreFullHouseNotSorted(){
        FullHouseLine dummyLine = new FullHouseLine("DummyName", "Dummy Explanation");
        int[] handValues = {1,2,1,2,2};
        dummyLine.calculateScore(new Hand(handValues));
        int expectedScore = 25;
        int actualScore = dummyLine.getPossibleScore(1);
        assertEquals(expectedScore, actualScore);
    }

    @Test
    void testScoreFullHouseNoFullHouse(){
        FullHouseLine dummyLine = new FullHouseLine("DummyName", "Dummy Explanation");
        int[] handValues = {1,2,1,2,3};
        dummyLine.calculateScore(new Hand(handValues));
        int expectedScore = 0;
        int actualScore = dummyLine.getPossibleScore(1);
        assertEquals(expectedScore, actualScore);
    }
    
}
