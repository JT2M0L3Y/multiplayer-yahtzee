package edu.gonzaga.ScoreCard.ScoreLines;

import edu.gonzaga.*;

/**
 * Bonus Line is the Class the represents the bonus line on the UpperScoreCard
 * 
 * @author Anna Cardinal
 * @version 1.0 5/6/2022
 */
public class BonusLine extends ScoreLine {

    private int targetScore = 63;
    private ScoreLine lineToWatch;

    public BonusLine(String name, String scoringExplanation, ScoreLine lineToWatch) {
        super(name, scoringExplanation);
        this.lineToWatch = lineToWatch;
    }

    public BonusLine(String name, String scoringExplanation, int numScores, ScoreLine lineToWatch) {
        super(name, scoringExplanation, numScores);
        this.lineToWatch = lineToWatch;
    }

    /**
    * Calculates possible score based on a given hand
    *
    * @param currentHand hand object used to calculate possible score
    */
    public void calculateScore(Hand currentHand) {
        int finalScore;
        for (int i = 0; i < lineToWatch.getScores().size(); i++) {
            finalScore = 0;
            if (lineToWatch.getScores().get(i) >= targetScore) {
                finalScore = 35;
            }
            super.setScore(i + 1, finalScore);
        }
    }
    
}
