package edu.gonzaga.ScoreCard.ScoreLines;

import edu.gonzaga.*;

/**
 * ChanceLine is the Class the represents the chance line on the LowerScoreCard
 * 
 * @author Anna Cardinal
 * @version 1.0 5/6/2022
 */
public class ChanceLine extends ScoreLine {

    public ChanceLine(String name, String scoringExplanation) {
        super(name, scoringExplanation);
    }

    public ChanceLine(String name, String scoringExplanation, Integer score) {
        super(name, scoringExplanation, score);
    }

    public ChanceLine(String name, String scoringExplanation, Integer[] playerScores) {
        super(name, scoringExplanation, playerScores);
    }

    /**
    * Calculates possible score based on a given hand
    *
    * @param currentHand hand object used to calculate possible score
    */
    public void calculateScore(Hand currentHand) {
        if (!super.checkUsed()) {
            super.setPossibleScore(1, currentHand.sum());
        }
    }
    
}
