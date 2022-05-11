package edu.gonzaga.ScoreCard.ScoreLines;

import java.awt.Color;
import java.util.ArrayList;
import edu.gonzaga.*;

/**
 * ScoreLine is the Class that represents the lines on the scorecard used to record scores
 * 
 * @author Anna Cardinal
 * @version 1.0 5/6/2022
 */

public abstract class ScoreLine {
    
    private ArrayList<Integer> scores = new ArrayList<>();
    private ArrayList<Integer> possibleScores = new ArrayList<>();
    private ScoreLineView view;

    public ScoreLine(String name, String scoringExplanation) {
        scores.add(-1);
        possibleScores.add(-1);
        view = new ScoreLineView(name, scoringExplanation, scores);
    }

    public ScoreLine(String name, String scoringExplanation, int numScores) {
        for (int i = 0; i < numScores; i++) {
            scores.add(-1);
            possibleScores.add(-1);
        }
        view = new ScoreLineView(name, scoringExplanation, scores);
    }

    public ScoreLine(String name, String scoringExplanation, Integer[] playerScores) {
        for (int i = 0; i < playerScores.length; i++) {
            scores.add(playerScores[i]);
            possibleScores.add(-1);
        }
        view = new ScoreLineView(name, scoringExplanation, scores);
    }

    /**
    * Calculates possible scores with a given hand
    *
    * @param currentHand Hand to base scores on
    */
    public abstract void calculateScore(Hand currentHand);

    /**
    * Returns view
    *
    * @return ScoreLineView with line's visual information
    */
    public ScoreLineView getView() { return view; }

    /**
    * Returns Scores
    *
    * @return ArrayList<Integers> containing line's scores
    */
    public ArrayList<Integer> getScores() { return scores; }

    /**
    * Sets a possible score for the line and updates view
    *
    * @param scoreColumn int used to determine which score column to record score on
    * @param newScore int representing new value to be recorded as possible score
    */
    public void setPossibleScore(int scoreColumn, int newScore) {
        possibleScores.set(scoreColumn - 1, newScore);
        view.updateScoreCell(newScore, scoreColumn, Color.GRAY);
    }

    /**
    * resets possible score to -1 and updates view
    *
    * @param scoreColumn int corresponding to column to reset score
    */
    public void resetPossibleScore(int scoreColumn) {
        if (!checkUsed()) {
            possibleScores.set(scoreColumn - 1, -1);
            view.updateScoreCell("-", scoreColumn);
        }
    }

    /**
    * sets a score for the line
    *
    * @param scoreColumn int corresponding to column where the score is to be recorded
    * @param newScore int value representing new score to be recorded
    */
    public void setScore(int scoreColumn, int newScore) {
        scores.set(scoreColumn - 1, newScore);
        view.updateScoreCell(newScore, scoreColumn);
    }

    /**
    * gets posssible score on a given column
    *
    * @param scoreColumn int value corresponding to column where the possible score is to be retrieved from
    * @return int value corresponding to possible score
    */
    public int getPossibleScore(int scoreColumn) {
        return possibleScores.get(scoreColumn - 1);
    }

    /**
    * gets recorded score on a given column 
    *
    * @param scoreColumn int value corresponding to column where the recorded score is to be retrieved from
    * @return int value corresponding to recorded score
    */
    public int getScore(int scoreColumn) {
        return scores.get(scoreColumn - 1);
    }

    /**
    * Checks if the scoreline has filled all available scoreing spots
    *
    * @return boolean for whether or not the scoreline is filled
    */
    public boolean checkUsed() {
        for (int i = 0; i < scores.size(); i++) {
            if (scores.get(i) == -1) {
                return false;
            }
        }
        return true;
    }

    /**
    * Sets the background color of the line
    *
    * @param backgroundColor Color value to assign as the background
    */
    public void setLineBackground(Color backgroundColor) {
        view.setLineBackground(backgroundColor);
    }

    /** Makes the bottum border of the view thicker */
    public void setBottomBorder() { view.setBottomBorder(); }

}
