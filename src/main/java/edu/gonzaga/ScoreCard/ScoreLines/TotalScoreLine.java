package edu.gonzaga.ScoreCard.ScoreLines;

import java.util.ArrayList;
import edu.gonzaga.*;

/**
 * TotalScoreLine is the Class the represents the total score lines on the ScoreCard
 * 
 * @author Anna Cardinal
 * @version 1.0 5/6/2022
 */
public class TotalScoreLine extends ScoreLine {

    private ArrayList<ScoreLine> linesToTotal = new ArrayList<>();

    public TotalScoreLine(String name, String scoringExplanation, ArrayList<ScoreLine> linesToTotal) {
        super(name, scoringExplanation);
        this.linesToTotal = linesToTotal;
    }

    public TotalScoreLine(String name, String scoringExplanation, int numScores, ArrayList<ScoreLine> linesToTotal) {
        super(name, scoringExplanation, numScores);
        this.linesToTotal = linesToTotal;
    }

    /**
    * Calculates possible score based on a given hand
    *
    * @param currentHand hand object used to calculate possible score
    */
    public void calculateScore(Hand currentHand) {
        int total = 0;
        int lineToTotalScore;
        for (int i = 0; i < linesToTotal.size(); i++) {
            lineToTotalScore = linesToTotal.get(i).getScores().get(0);
            if (lineToTotalScore == -1) {
                total += 0;
            } else {
                total += lineToTotalScore;
            }
        }
        getScores().set(0, total);
        super.setScore(1, total);  
    }
    
}
