package edu.gonzaga.ScoreCard.ScoreLines;

import edu.gonzaga.*;

/**
 * UpperScoreLine is the class that represents the scorelines on the UpperScoreLine
 * 
 * @author Anna Cardinal
 * @version 1.0 5/6/2022
 */
public class UpperScoreLine extends ScoreLine {
    
    private int rowNum;

    public UpperScoreLine(String name, String scoringExplanation, int rowNum, int numPlayers) {
        super(name, scoringExplanation, numPlayers);
        this.rowNum = rowNum;
    }

    public UpperScoreLine(String name, String scoringExplanation, Integer[] playerScores, int rowNum) {
        super(name, scoringExplanation, playerScores);
        this.rowNum = rowNum;
    }

    /**
    * Calculates possible score based on a given hand
    *
    * @param currentHand hand object used to calculate possible score
    */
    public void calculateScore(Hand currentHand) {
        if (!super.checkUsed()) {
            int finalScore;
            int countPoints = 0;
            for (int i = 0; i < currentHand.getSize(); i++) {
                if (currentHand.getDie(i).getSideUp() == rowNum) { //record each occurance of specified side
                    countPoints++;
                }
            }
            finalScore = (countPoints *= rowNum);//multiply amount of occurances by value of dice side and return

            super.setPossibleScore(1, finalScore);
        }
    } 

}
