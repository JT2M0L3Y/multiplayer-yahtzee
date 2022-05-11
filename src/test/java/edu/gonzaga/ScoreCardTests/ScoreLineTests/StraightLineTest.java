package edu.gonzaga.ScoreCardTests.ScoreLineTests;

import org.junit.jupiter.api.Test;
import edu.gonzaga.Hand;
import edu.gonzaga.ScoreCard.ScoreLines.*;
import static org.junit.jupiter.api.Assertions.*;

public class StraightLineTest {

    @Test
    void testSmallStraightSorted(){
        StraightLine dummyLine = new StraightLine("Dummy Straight", "Dummy Explanation", 4);
        int[] handValues = {1,2,3,4,6};
        dummyLine.calculateScore(new Hand(handValues));
        int expectedScore = 30;
        int actualScore = dummyLine.getPossibleScore(1);
        assertEquals(expectedScore, actualScore);
    }

    @Test
    void testSmallStraightNotSorted(){
        StraightLine dummyLine = new StraightLine("Dummy Straight", "Dummy Explanation", 4);
        int[] handValues = {2,1,3,4,6};
        dummyLine.calculateScore(new Hand(handValues));
        int expectedScore = 30;
        int actualScore = dummyLine.getPossibleScore(1);
        assertEquals(expectedScore, actualScore);
    }
    
    @Test
    void testSmallStraightNoSmallStraight(){
        StraightLine dummyLine = new StraightLine("Dummy Straight", "Dummy Explanation", 4);
        int[] handValues = {2,1,1,4,6};
        dummyLine.calculateScore(new Hand(handValues));
        int expectedScore = 0;
        int actualScore = dummyLine.getPossibleScore(1);
        assertEquals(expectedScore, actualScore);
    }

    @Test
    void testSmallStraightLargeStraight(){
        StraightLine dummyLine = new StraightLine("Dummy Straight", "Dummy Explanation", 4);
        int[] handValues = {1,2,3,4,5};
        dummyLine.calculateScore(new Hand(handValues));
        int expectedScore = 30;
        int actualScore = dummyLine.getPossibleScore(1);
        assertEquals(expectedScore, actualScore);
    }

    @Test
    void testLargeStraightSorted(){
        StraightLine dummyLine = new StraightLine("Dummy Straight", "Dummy Explanation", 5);
        int[] handValues = {1,2,3,4,5};
        dummyLine.calculateScore(new Hand(handValues));
        int expectedScore = 40;
        int actualScore = dummyLine.getPossibleScore(1);
        assertEquals(expectedScore, actualScore);
    }

    @Test
    void testLargeStraightNotSorted(){
        StraightLine dummyLine = new StraightLine("Dummy Straight", "Dummy Explanation", 5);
        int[] handValues = {1,2,3,5,4};
        dummyLine.calculateScore(new Hand(handValues));
        int expectedScore = 40;
        int actualScore = dummyLine.getPossibleScore(1);
        assertEquals(expectedScore, actualScore);
    }

    @Test
    void testLargeStraightNoLargeStraight(){
        StraightLine dummyLine = new StraightLine("Dummy Straight", "Dummy Explanation", 5);
        int[] handValues = {1,2,5,5,5};
        dummyLine.calculateScore(new Hand(handValues));
        int expectedScore = 0;
        int actualScore = dummyLine.getPossibleScore(1);
        assertEquals(expectedScore, actualScore);
    }

    @Test
    void testLargeStraightSmallStraight(){
        StraightLine dummyLine = new StraightLine("Dummy Straight", "Dummy Explanation", 5);
        int[] handValues = {1,2,3,4,1};
        dummyLine.calculateScore(new Hand(handValues));
        int expectedScore = 0;
        int actualScore = dummyLine.getPossibleScore(1);
        assertEquals(expectedScore, actualScore);
    }

}
