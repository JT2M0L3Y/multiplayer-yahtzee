package edu.gonzaga.ScoreCardTests.ScoreLineTests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import javax.swing.*;
import edu.gonzaga.Hand;
import edu.gonzaga.ScoreCard.ScoreLines.ScoreLine;
import java.util.ArrayList;

class DummyScoreLine extends ScoreLine{

    public DummyScoreLine(){
        super("Dummy Name", "Dummy Explanantion");
    }

    @Override
    public void calculateScore(Hand currentHand) {
        //do nothing
    }

}

public class ScoreLineTest {

    @Test
    void testViewInstantiation(){
        DummyScoreLine dummyLine = new DummyScoreLine();
        JPanel dummyView = dummyLine.getView();
        assertNotNull(dummyView);
    }

    @Test
    void testScoresInstantiation(){
        DummyScoreLine dummyLine = new DummyScoreLine();
        ArrayList<Integer> dummyScores = dummyLine.getScores();
        assertNotNull(dummyScores);
    }

    @Test
    void testGetEmptyScores(){
        DummyScoreLine dummyLine = new DummyScoreLine();
        ArrayList<Integer> actualScores = dummyLine.getScores();
        ArrayList<Integer> expectedScores = new ArrayList<>() {{
            for(int i = 0; i < actualScores.size(); i++){
                add(-1);
            }
        }};
        assertEquals(expectedScores, actualScores);
    }

    @Test
    void testPossibleScoresInstantiation(){
        DummyScoreLine dummyLine = new DummyScoreLine();
        Integer dummyPossibleScore = dummyLine.getPossibleScore(1);
        assertNotNull(dummyPossibleScore);
    }

    @Test
    void testGetEmptyPossibleScore(){
        DummyScoreLine dummyLine = new DummyScoreLine();
        Integer actualPossibleScore = dummyLine.getPossibleScore(1);
        Integer expectedPossibleScore = -1;
        assertEquals(expectedPossibleScore, actualPossibleScore);
    }
    
    @Test
    void testSetScore(){
        DummyScoreLine dummyLine = new DummyScoreLine();
        dummyLine.setScore(1, 10);
        int actualScore = dummyLine.getScore(1);
        int expectedScore = 10;
        assertEquals(expectedScore, actualScore);
    }

    @Test
    void testSetPossibleScore(){
        DummyScoreLine dummyLine = new DummyScoreLine();
        dummyLine.setPossibleScore(1, 10);
        int actualPossibleScore = dummyLine.getPossibleScore(1);
        int expectedPossibleScore = 10;
        assertEquals(expectedPossibleScore, actualPossibleScore);
    }

    @Test
    void testResetPossibleScore(){
        DummyScoreLine dummyLine = new DummyScoreLine();
        dummyLine.setPossibleScore(1, 10);
        dummyLine.resetPossibleScore(1);
        int actualPossibleScore = dummyLine.getPossibleScore(1);
        int expectedPossibleScore = -1;
        assertEquals(expectedPossibleScore, actualPossibleScore);
    }

    @Test
    void testCheckUsedNotUsedLine(){
        DummyScoreLine dummyLine = new DummyScoreLine();
        assertEquals(false, dummyLine.checkUsed());
    }

    @Test
    void testCheckUsedUsedLine(){
        DummyScoreLine dummyLine = new DummyScoreLine();
        dummyLine.setScore(1, 10);
        assertEquals(true, dummyLine.checkUsed());
    }
    
}
