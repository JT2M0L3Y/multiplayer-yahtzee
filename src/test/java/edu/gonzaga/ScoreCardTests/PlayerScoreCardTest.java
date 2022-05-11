package edu.gonzaga.ScoreCardTests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import edu.gonzaga.ScoreCard.PlayerScoreCard;
import edu.gonzaga.ScoreCard.PlayerScoreCardView;
import edu.gonzaga.*;

public class PlayerScoreCardTest {

    @Test
    void testViewInstatiation(){
        PlayerScoreCard dummyCard = new PlayerScoreCard("John",6);
        PlayerScoreCardView dummyView = dummyCard.getPlayerScoreCardView();
        assertNotNull(dummyView);
    }

    @Test
    void testDisplayPossibleScoresFirstLine(){
        PlayerScoreCard dummyCard = new PlayerScoreCard("John",6);
        Hand dummyHand = new Hand();
        dummyCard.displayPossibleScores(dummyHand);
        int unexpectedPossibleScoe = -1;
        int actualPossibleScore = dummyCard.getScoreLines().get(0).getPossibleScore(1);
        assertNotEquals(unexpectedPossibleScoe, actualPossibleScore);
    }

    @Test
    void testDisplayPossibleScoresLastLine(){
        PlayerScoreCard dummyCard = new PlayerScoreCard("John",6);
        Hand dummyHand = new Hand();
        dummyCard.displayPossibleScores(dummyHand);
        int unexpectedPossibleScoe = -1;
        int actualPossibleScore = dummyCard.getScoreLines().get(12).getPossibleScore(1);
        assertNotEquals(unexpectedPossibleScoe, actualPossibleScore);
    }

    @Test
    void testResetPossibleScoresFirstLine(){
        PlayerScoreCard dummyCard = new PlayerScoreCard("John",6);
        Hand dummyHand = new Hand();
        dummyCard.displayPossibleScores(dummyHand);
        dummyCard.resetPossibleScores();
        int expectedPossibleScoe = -1;
        int actualPossibleScore = dummyCard.getScoreLines().get(0).getPossibleScore(1);
        assertEquals(expectedPossibleScoe, actualPossibleScore);
    }

    @Test
    void testResetPossibleScoresLastLine(){
        PlayerScoreCard dummyCard = new PlayerScoreCard("John",6);
        Hand dummyHand = new Hand();
        dummyCard.displayPossibleScores(dummyHand);
        dummyCard.resetPossibleScores();
        int expectedPossibleScoe = -1;
        int actualPossibleScore = dummyCard.getScoreLines().get(12).getPossibleScore(1);
        assertEquals(expectedPossibleScoe, actualPossibleScore);
    }

    @Test
    void testScoreFirstLine(){
        PlayerScoreCard dummyCard = new PlayerScoreCard("John",6);
        Hand dummyHand = new Hand();
        dummyCard.displayPossibleScores(dummyHand);
        dummyCard.getPlayerScoreCardView().getScoringMenu().getButtons().get(0).setSelected(true);
        dummyCard.score();
        int expectedRecordedScore = 5;
        int actualRecordedScore = dummyCard.getScoreLines().get(0).getScore(1);
        assertEquals(expectedRecordedScore, actualRecordedScore);
    }

    @Test
    void testScoreLastLine(){
        PlayerScoreCard dummyCard = new PlayerScoreCard("John",6);
        Hand dummyHand = new Hand();
        dummyCard.displayPossibleScores(dummyHand);
        dummyCard.getPlayerScoreCardView().getScoringMenu().getButtons().get(0).setSelected(true);
        dummyCard.score();
        int expectedRecordedScore = 5;
        int actualRecordedScore = dummyCard.getScoreLines().get(0).getScore(1);
        assertEquals(expectedRecordedScore, actualRecordedScore);
    }
    
}
