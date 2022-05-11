package edu.gonzaga.ScoreCardTests;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import edu.gonzaga.ScoreCard.ScoreCard;
import edu.gonzaga.ScoreCard.ScoreCardView;
import edu.gonzaga.ScoreCard.ScoreLines.ScoreLine;

public class ScoreCardTest {
    
    @Test
    void testViewInstantiation(){
        ScoreCard dummyCard = new ScoreCard("John", 6, 1);
        ScoreCardView dummyView = dummyCard.getView();
        assertNotNull(dummyView);
    }

    @Test
    void testScoreLineInstantiation(){
        ScoreCard dummyCard = new ScoreCard("John", 6, 1);
        ArrayList<ScoreLine> dummyLines = dummyCard.getScoreLines();
        assertNotNull(dummyLines);
    }

    @Test
    void test13ScoreLines(){
        ScoreCard dummyCard = new ScoreCard("John", 6, 1);
        ArrayList<ScoreLine> dummyLines = dummyCard.getScoreLines();
        int expectedNumScoreLines = 13;
        int actualNumScoreLines = dummyLines.size();
        assertEquals(expectedNumScoreLines, actualNumScoreLines);
    }

    @Test
    void testTotalLinesInstantiation(){
        ScoreCard dummyCard = new ScoreCard("John", 6, 1);
        ArrayList<ScoreLine> dummyLines = dummyCard.getTotalLines();
        assertNotNull(dummyLines);
    }

    @Test
    void test6TotalLines(){
        ScoreCard dummyCard = new ScoreCard("John", 6, 1);
        ArrayList<ScoreLine> dummyLines = dummyCard.getTotalLines();
        assertNotNull(dummyLines);
        int expectedNumTotalLines = 6;
        int actualNumTotalLines = dummyLines.size();
        assertEquals(expectedNumTotalLines, actualNumTotalLines);
    }

    @Test
    void testSetScoreOneLine(){
        ScoreCard dummyCard = new ScoreCard("John", 6, 1);
        dummyCard.setScore(1, 1, 5);
        int expectedRecordedScore = 5;
        int actualRecordedScore = dummyCard.getScoreLines().get(0).getScore(1);
        assertEquals(expectedRecordedScore, actualRecordedScore);
    }

    @Test
    void testSetScore6Line(){
        ScoreCard dummyCard = new ScoreCard("John", 6, 1);
        dummyCard.setScore(6, 1, 5);
        int expectedRecordedScore = 5;
        int actualRecordedScore = dummyCard.getScoreLines().get(5).getScore(1);
        assertEquals(expectedRecordedScore, actualRecordedScore);
    }

    @Test
    void testSetScoreChanceLine(){
        ScoreCard dummyCard = new ScoreCard("John", 6, 1);
        dummyCard.setScore(13, 1, 5);
        int expectedRecordedScore = 5;
        int actualRecordedScore = dummyCard.getScoreLines().get(12).getScore(1);
        assertEquals(expectedRecordedScore, actualRecordedScore);
    }

}
