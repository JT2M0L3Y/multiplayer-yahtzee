package edu.gonzaga.ScoreCard;

import javax.swing.JPanel;
import java.util.ArrayList;
import edu.gonzaga.GameComponents.*;
import edu.gonzaga.ScoreCard.ScoreLines.*;
import java.awt.*;
import javax.swing.*;

/**
 * ScoreCardView is the class that holds the ScoreCard class's visual information
 * 
 * @author Anna Cardinal
 * @version 1.0 5/6/2022
 */
public class ScoreCardView extends JPanel {
    
    private GameLabel title;
    private ArrayList<ScoreLineView> scoreLines = new ArrayList<>();
    private ArrayList<ScoreLineView> totalLines = new ArrayList<>();
    private ArrayList<TitleLineView> titleLines = new ArrayList<>();
    private int rowHeight;
    private int width;
    private int height;

    public ScoreCardView(String titleText, ArrayList<ScoreLine> scoreLineModelsRef, ArrayList<ScoreLine> totalLinesRef, ArrayList<TitleLineView> titleLinesRef) {
        this.title = new GameLabel(titleText, SwingConstants.CENTER);
        title.setTextBold();
        this.setLayout(null);
        for (int i = 0; i < scoreLineModelsRef.size(); i++) {
            scoreLines.add(scoreLineModelsRef.get(i).getView());
        }
        for (int i = 0; i < totalLinesRef.size(); i++) {
            totalLines.add(totalLinesRef.get(i).getView());
        }
        titleLines = titleLinesRef;
        this.rowHeight = scoreLines.get(0).getHeight();
        this.width = scoreLines.get(0).getWidth();
        this.height = rowHeight + (rowHeight * scoreLines.size()) + (rowHeight * totalLines.size()) + (rowHeight * titleLines.size());
        configureView();
    }

    /** assigns component visual information*/
    public void configureView() {
        this.setSize(width, height);
        setComponentSizes();
        setComponentLocations();
        this.add(title);
        for (int i = 0; i < scoreLines.size(); i++) {
            this.add(scoreLines.get(i));
        }
        for (int i = 0; i < totalLines.size(); i++) {
            this.add(totalLines.get(i));
        }
        for (int i = 0; i < titleLines.size(); i++) {
            this.add(titleLines.get(i));
        }
    }

    /** sets component size settings*/
    public void setComponentSizes() {
        title.setSize(width, rowHeight);
        title.setBorder(BorderFactory.createMatteBorder(3, 3, 1, 3, ColorPalette.textColor));
    }

    /** sets component location settings*/
    public void setComponentLocations() {
        int yCoordinate = 0;
        title.setLocation(0, yCoordinate);
        yCoordinate += rowHeight;
        titleLines.get(0).setLocation(0, yCoordinate);
        yCoordinate += rowHeight;
        for (int i = 0; i < 6; i++) {
            scoreLines.get(i).setLocation(0, yCoordinate);
            yCoordinate += rowHeight;
        }
        for (int i = 0; i < 3; i++) {
            totalLines.get(i).setLocation(0, yCoordinate);
            yCoordinate += rowHeight;
        }
        titleLines.get(1).setLocation(0, yCoordinate);
        yCoordinate += rowHeight;
        for (int i = 6; i < scoreLines.size(); i++) {
            scoreLines.get(i).setLocation(0, yCoordinate);
            yCoordinate += rowHeight;
        }
        for (int i = 3; i < totalLines.size(); i++) {
            totalLines.get(i).setLocation(0, yCoordinate);
            yCoordinate += rowHeight;
        }
    }

    /**
    * Gets the height of the card rows
    *
    * @return int value corresponding to the row height
    */
    public int getRowHeight() { return rowHeight; }

    /**
    * Gets the width of the card rows
    *
    * @return int value corresponding to the row width
    */
    public int getRowWidth() { return width; }

    /**
    * Gets the number of rows that can be scored
    *
    * @return int value corresponding to the number of scorable rows
    */
    public int getNumScoringRows() { return scoreLines.size(); }

    /**
    * Assigns the text of the title lines with the given score headers
    *
    * @param scoreHeaders Arraylist<String> with score column headers
    */
    public void setUpperScoreCardTitles(ArrayList<String> scoreHeaders) {
        titleLines.get(0).setScoreHeaders(scoreHeaders);
    }

    /**
    * Gets all the scoreLineViews
    *
    * @return ArrayList<ScoreLineView> with all scoreline views
    */
    public ArrayList<ScoreLineView> getScoreLineViews() { return scoreLines; }

    /**
    * Gets all the totalLineViews
    *
    * @return ArrayList<ScoreLineView> with all totalline views
    */
    public ArrayList<ScoreLineView> getTotalLineViews() { return totalLines; }

    /**
    * Colors the card
    *
    * @param titleColor Color of the title
    * @param columnHeadersColor Color of the column headers
    * @param possibleScoreColor Color of the possible scores
    */
    public void color(Color titleColor, Color columnHeadersColor, Color possibleScoreColor) {
        title.setOpaque(true);
        title.setBackground(titleColor);
        titleLines.get(0).setLineBackground(columnHeadersColor);
        titleLines.get(1).setLineBackground(columnHeadersColor);
    }

    /**
    * Colors a given title cell a given color
    *
    * @param color Color to be the background
    * @param titleRow int corresponding to the row to be colored
    * @param colum int corresponding to the column to be colored
    */
    public void colorTitleCell(Color color, int titleRow, int column) {
        if (titleRow == 1) {
            titleLines.get(0).getCell(column).setBackground(color);
        } else {
            titleLines.get(1).getCell(column).setBackground(color);
        }
    }

    /**
    * Colors a given score cell a given color
    *
    * @param color Color to be the background
    * @param row int corresponding to the row to be colored
    * @param colum int corresponding to the column to be colored
    */
    public void colorScoreCell(Color color, int row, int column) {
        scoreLines.get(row - 1).getCell(column).setBackground(color);
        scoreLines.get(row - 1).getCell(column).setOpaque(true);
    }

    /**
    * Colors a given total cell a given color
    *
    * @param color Color to be the background
    * @param row int corresponding to the row to be colored
    * @param colum int corresponding to the column to be colored
    */
    public void colorTotalCell(Color color, int row, int column) {
        totalLines.get(row -1).getCell(column).setBackground(color);
        totalLines.get(row -1).getCell(column).setOpaque(true);
    }

}
