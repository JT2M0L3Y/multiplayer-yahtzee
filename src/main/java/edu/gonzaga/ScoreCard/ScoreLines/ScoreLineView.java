package edu.gonzaga.ScoreCard.ScoreLines;

import javax.swing.JPanel;
import java.util.ArrayList;
import edu.gonzaga.GameComponents.*;
import java.awt.*;
import javax.swing.*;

/**
 * ScoreLineView is the Class the represents the visual information from the ScoreLine Class
 * 
 * @author Anna Cardinal
 * @version 1.0 5/6/2022
 */
public class ScoreLineView extends JPanel {

    private static final int NAME_CELL_WIDTH = 100;
    private static final int SCORING_EXPLANATION_CELL_WIDTH = 250;
    private static final int SCORE_CELL_WIDTH = 50;

    private GameLabel nameCell;
    private GameLabel scoringExplanationCell;
    private ArrayList<GameLabel> scoreCells = new ArrayList<>();
    private int height = 25;
    private int width;

    public ScoreLineView(String name, String scoringExplanations, ArrayList<Integer> scores) {
        nameCell = new GameLabel(name);
        scoringExplanationCell = new GameLabel(scoringExplanations, SwingConstants.CENTER);
        GameLabel tempLabel;
        for (int i = 0; i < scores.size(); i++) {
            if (scores.get(i) == -1) {
                tempLabel = new GameLabel("-", SwingConstants.CENTER);
            } else {
                tempLabel = new GameLabel(Integer.toString(scores.get(i)), true);
                tempLabel.setHorizontalAlignment(SwingConstants.CENTER);
                tempLabel.setVerticalAlignment(SwingConstants.CENTER);
            }
            tempLabel.setTextBold();
            scoreCells.add(tempLabel);
        }
        this.width = NAME_CELL_WIDTH + SCORING_EXPLANATION_CELL_WIDTH + (SCORE_CELL_WIDTH * scoreCells.size());
        configureView();
    }

    public ScoreLineView(String name, String scoringExplanations, int numScores) {
        nameCell = new GameLabel(name);
        scoringExplanationCell = new GameLabel(scoringExplanations, SwingConstants.CENTER);
        GameLabel tempLabel;
        for (int i = 0; i < numScores; i++) {
            tempLabel = new GameLabel("-", SwingConstants.CENTER);
            scoreCells.add(tempLabel);
        }
        this.width = NAME_CELL_WIDTH + SCORING_EXPLANATION_CELL_WIDTH + (SCORE_CELL_WIDTH * scoreCells.size());
        configureView();
    }

    public ScoreLineView(String name, String scoringExplanations) {
        nameCell = new GameLabel(name);
        scoringExplanationCell = new GameLabel(scoringExplanations, SwingConstants.CENTER);
        scoreCells.add(new GameLabel("-", SwingConstants.CENTER));
        this.width = NAME_CELL_WIDTH + SCORING_EXPLANATION_CELL_WIDTH + (SCORE_CELL_WIDTH * scoreCells.size());
        configureView();
    }

    /** organizes component visual information */
    public void configureView() {
        this.setLayout(null);
        this.setSize(width, height);
        setCellDimensions();
        setCellLocations();
        setCellBorders();
        this.add(nameCell);
        this.add(scoringExplanationCell);
        for (int i = 0; i < scoreCells.size(); i++) {
            this.add(scoreCells.get(i));
        }
    }
    
    /** assigns each cell dimensions*/
    public void setCellDimensions() {
        nameCell.setSize(NAME_CELL_WIDTH, height);
        scoringExplanationCell.setSize(SCORING_EXPLANATION_CELL_WIDTH, height);
        for (int i = 0; i < scoreCells.size(); i++) {
            scoreCells.get(i).setSize(SCORE_CELL_WIDTH, height);
        }
    }

    /** assigns the location of each cell*/
    public void setCellLocations() {
        int scoreCellXCoordinate;
        nameCell.setLocation(0, 0);
        scoringExplanationCell.setLocation(NAME_CELL_WIDTH, 0);
        for (int i = 0; i < scoreCells.size(); i++) {
            scoreCellXCoordinate = NAME_CELL_WIDTH + SCORING_EXPLANATION_CELL_WIDTH + (SCORE_CELL_WIDTH * i);
            scoreCells.get(i).setLocation(scoreCellXCoordinate, 0);
        }
    }

    /** sets the border on each cell*/
    public void setCellBorders() {
        nameCell.setBorder(BorderFactory.createMatteBorder(1, 3, 1, 1, ColorPalette.textColor));
        scoringExplanationCell.setBorder(BorderFactory.createLineBorder(ColorPalette.textColor));
        for (int i = 0; i < scoreCells.size(); i++) {
            scoreCells.get(i).setBorder(BorderFactory.createLineBorder(ColorPalette.textColor));
            if (i == scoreCells.size() - 1) {
                scoreCells.get(i).setBorder(BorderFactory.createMatteBorder(1, 1, 1, 3, ColorPalette.textColor));
            }
        }
    }

    /**
    * Updates text to match new score and sets text to black
    *
    * @param newScore int value corresponding to the new score
    */
    public void updateScoreCell(int newScore) {
        scoreCells.get(0).setText(Integer.toString(newScore));
        scoreCells.get(0).setForeground(Color.BLACK);
    }

    /**
    * Updates text to match new score and sets text to black
    *
    * @param newScore int value corresponding to the new score
    * @param scoreColumn int value corresponding to column to update
    */
    public void updateScoreCell(int newScore, int scoreColumn) {
        scoreCells.get(scoreColumn - 1).setText(Integer.toString(newScore));
        scoreCells.get(0).setForeground(Color.BLACK);
    }

    /**
    * Updates text to match a given text and sets text to black
    *
    * @param newScoreText String value to be assigned as scorecell text
    * @param scoreColumn int value corresponding to collumn to update
    */
    public void updateScoreCell(String newScoreText, int scoreColumn) {
        scoreCells.get(scoreColumn - 1).setText(newScoreText);
        scoreCells.get(0).setForeground(Color.BLACK);
    }

    /**
    * Updates text to match new score and sets text to given color
    *
    * @param newScore int value corresponding to the new score
    * @param scoreColor Color value of new Score
    */
    public void updateScoreCell(int newScore, Color scoreColor) {
        scoreCells.get(0).setText(Integer.toString(newScore));
        scoreCells.get(0).setForeground(scoreColor);
    }

    /**
    * Updates text to match new score and sets text to black on a given column
    *
    * @param newScore int value corresponding to the new score
    * @param scoreColumn int value scorresponding to the column to be changed
    * @param scoreColor Color value corresponding to the color of the new text
    */
    public void updateScoreCell(int newScore, int scoreColumn, Color scoreColor) {
        scoreCells.get(scoreColumn - 1).setText(Integer.toString(newScore));
        scoreCells.get(scoreColumn - 1).setForeground(scoreColor);
    }

    /**
    * sets the background color of the line
    *
    * @param backgroundColor Color value to be set as line background color
    */
    public void setLineBackground(Color backgroundColor) {
        nameCell.setOpaque(true);
        nameCell.setBackground(backgroundColor);
        scoringExplanationCell.setOpaque(true);
        scoringExplanationCell.setBackground(backgroundColor);
        for (int i = 0; i < scoreCells.size(); i++) {
            scoreCells.get(i).setOpaque(true);;
            scoreCells.get(i).setBackground(backgroundColor);
        }
    }

    /**
    * get cell on a given column
    *
    * @param column int value corresponding with column to get cell from
    * @return GameLabel with cell information
    */
    public GameLabel getCell(int column) {
        if (column == 1) {
            return nameCell;
        } else if (column == 2) {
            return scoringExplanationCell;
        } else {
            return scoreCells.get(column - 3);
        }
    }

    /** Makes the bottom border of the line thicker*/
    public void setBottomBorder() {
        nameCell.setBorder(BorderFactory.createMatteBorder(1, 3, 3, 1, ColorPalette.textColor));
        scoringExplanationCell.setBorder(BorderFactory.createMatteBorder(1, 1, 3, 1, ColorPalette.textColor));
        for (int i = 0; i < scoreCells.size(); i++) {
            scoreCells.get(i).setBorder(BorderFactory.createMatteBorder(1, 1, 3, 1, ColorPalette.textColor));
            if (i == scoreCells.size() - 1) {
                scoreCells.get(i).setBorder(BorderFactory.createMatteBorder(1, 1, 3, 3, ColorPalette.textColor));
            }
        }
    }

}
