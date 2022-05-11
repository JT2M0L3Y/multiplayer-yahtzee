package edu.gonzaga;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PlayerTest {

    @Test
    void testManualRecordScore(){
        Player dummyPlayer = new Player("John");
        dummyPlayer.recordScore(1, 4);
        int actualScore = dummyPlayer.getScore(1);
        int expectedScore = 4;
        assertEquals(expectedScore, actualScore);
    } 

    @Test
    void testGetFinalScore(){
        Player dummyPlayer = new Player("John");
        for(int i = 1; i <= 13; i++){
            dummyPlayer.recordScore(i, 1);
        }
        int expectedFinalScore = 13;
        int actualFinalScore = dummyPlayer.getFinalScore();
        assertEquals(expectedFinalScore, actualFinalScore);
    }
    
}
