package edu.gonzaga.ScoreCard.ScoreLines;

import edu.gonzaga.*;

/**
 * FullHouseLine is the Class the represents the full house line on the LowerScoreCard
 * 
 * @author Anna Cardinal
 * @version 1.0 5/6/2022
 */
public class FullHouseLine extends ScoreLine {
    
    public FullHouseLine(String name, String scoringExplanation) {
        super(name, scoringExplanation);
    }

    public FullHouseLine(String name, String scoringExplanation, int numPlayers) {
        super(name, scoringExplanation, numPlayers);
    }

    public FullHouseLine(String name, String scoringExplanation, Integer[] playerScores) {
        super(name, scoringExplanation, playerScores);
    }

    /**
    * Calculates possible score based on a given hand
    *
    * @param currentHand hand object used to calculate possible score
    */
    public void calculateScore(Hand currentHand) {
        if (!super.checkUsed()) {
            int finalScore;
            boolean matchOfThree = false;
            boolean matchOfTwo = false;
            int count = 0;
            for (int i = 1; i <= currentHand.getSize(); i++) { //loop through die sides
                count = 0;
                for (int j = 0; j < currentHand.getSize(); j++) { //loop through dice
                    if (currentHand.getDie(j).getSideUp() == i) { // count occurances of current specified side
                        count++;
                    }
                }
                if (count >= 3 && matchOfThree == false) {
                    matchOfThree = true;
                } else if (count >= 2) {
                    matchOfTwo = true;
                }
            }
            if (matchOfThree == true && matchOfTwo == true) {
                finalScore = 25;
            } else {
                finalScore = 0;
            }
            super.setPossibleScore(1, finalScore);
        }
    }

}
