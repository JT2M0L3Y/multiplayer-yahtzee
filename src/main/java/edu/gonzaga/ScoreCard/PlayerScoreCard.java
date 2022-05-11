package edu.gonzaga.ScoreCard;

import edu.gonzaga.Hand;

/**
 * PlayerScoreCard is the class that contains a player's scoring information
 * 
 * @author Anna Cardinal
 * @version 1.0 5/6/2022
 */
public class PlayerScoreCard extends ScoreCard {

    private static int cardCount = 0;
    private int id;
    private PlayerScoreCardView playerView;
    private ScoreCardView scoreTable;

    public PlayerScoreCard(String playerName, int numDiceSides) {
        super(playerName + "'s ScoreCard", numDiceSides, 1);
        cardCount++;
        id = cardCount;
        scoreTable = super.getView();
        playerView = new PlayerScoreCardView(scoreTable, id);
    }

    /**
    * gets view
    *
    * @return PlayerScoreCardView with view information
    */
    public PlayerScoreCardView getPlayerScoreCardView() { return playerView; }

    public void displayPossibleScores(Hand currentHand) {
        for(int i = 0; i < 13; i++){
            super.getScoreLines().get(i).calculateScore(currentHand);
        }
    }

    /**
    * Makes two dice comparable using <, ==, >, etc. based on sideUp values.
    *
    * @param otherDie The die we're comparing to this one (two objects)
    * @return int -1, 0, 1 for less than, equal, greater than
    */
    public void resetPossibleScores() {
        for (int i = 0; i < 13; i++) {
            super.getScoreLines().get(i).resetPossibleScore(1);
        }
    }

    /** scores the row selected on the scoring menu with the recorded possible score */
    public void score() {
        int scoringRow = playerView.getSelectedScoringIndex() + 1;
        int score = super.getScoreLines().get(scoringRow - 1).getPossibleScore(1);
        manualSetScore(scoringRow, score);
        playerView.deleteScoringOption(scoringRow);
        for (int i = 0; i < 6; i++) {
            super.getTotalLines().get(i).calculateScore(new Hand());
        }
    }

    /**
    * manually assigns a score on the given row
    *
    * @param scoringRow int value corresponding to the row to be scored
    * @param score int value corresponding to the score to be recorded
    */
    public void manualSetScore(int scoringRow, int score) {
        super.setScore(scoringRow, 1, score);
        for(int i = 0; i < 6; i++) {
            super.getTotalLines().get(i).calculateScore(new Hand());
        }
    }

    /** sets the scoring menu invisible*/
    public void hideScoringMenu() { playerView.hideScoringMenu(); }

    /** sets the scoring menu to visible*/
    public void revealScoringMenu() { playerView.revealScoringMenu(); }

    /**
    * checks to see if scorecard is completely filled
    *
    * @return boolean value telling whether card is full
    */
    public boolean checkFull() {
        if (checkAvailableSpace() == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
    * Gets the total number of availble spaces on the card
    *
    * @return int value corresponding to all remaining available spaces
    */
    public int checkAvailableSpace() {
        int notUsedCount = 0;
        for (int i = 0; i < super.getScoreLines().size(); i++) {
            if (!super.getScoreLines().get(i).checkUsed()) {
                notUsedCount++;
            }
        }
        return notUsedCount;
    }

    /**
    * Gets the recorded score from a given row
    *
    * @param row int value corresponding to the row to get the score from
    * @return int value corresponding to the recorded score value
    */
    public int getScore(int row) {
        return super.getScoreLines().get(row - 1).getScores().get(0);
    }

    /**
    * Gets the score on a given TotalScoreLine
    *
    * @param row int value corresponding to the row to get the score from
    * @return int value corresponding to the total score
    */
    public int getTotalScore(int row) {
        return super.getTotalLines().get(row - 1).getScores().get(0);
    }

    /**
    * Gets the grand total score
    *
    * @param row int value corresponding to the row to get the score from
    * @return int value corresponding to the grand total score
    */
    public int getFinalScore() {
        return super.getTotalLines().get(5).getScore(1);
    }

    /** resets the card count to zero*/
    public void resetCount() { cardCount = 0; }
    
}
