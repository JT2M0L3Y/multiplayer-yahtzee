package edu.gonzaga.ScoreCard;

import javax.swing.*;
import java.awt.*;
import edu.gonzaga.GameComponents.*;

/**
 * PlayerScoreCardView is the class that holds the PlayerScoreCard class's visual information
 * 
 * @author Anna Cardinal
 * @version 1.0 5/6/2022
 */
public class PlayerScoreCardView extends JPanel {

    private Color[][] possibleColors = {
        {ColorPalette.lightRed, ColorPalette.red, ColorPalette.darkRed},
        {ColorPalette.lightGreen, ColorPalette.green, ColorPalette.darkGreen},
        {ColorPalette.lightBlue, ColorPalette.blue, ColorPalette.darkBlue},
        {ColorPalette.lightGrey, ColorPalette.grey, ColorPalette.darkGrey},
        {ColorPalette.lightPurple, ColorPalette.purple, ColorPalette.darkPurple},
        {ColorPalette.lightTeal, ColorPalette.teal, ColorPalette.darkTeal},
        {ColorPalette.lightBrown, ColorPalette.brown, ColorPalette.darkBrown},
        {ColorPalette.lightOrange, ColorPalette.orange, ColorPalette.darkOrange}
    };
    private Color titleColor;
    private Color columnHeadersColor;
    private Color possibleScoreColor;
    private ScoreCardView scoreTable;
    private ScoringMenuView scoringMenu;
    private GameLabel possibleScoreExplanation;
    private int height;
    private int width;
    private int id;
 
    public PlayerScoreCardView(ScoreCardView scoreTableView, int id) {
        this.setLayout(null);
        this.id = id;
        scoreTable = scoreTableView;
        scoringMenu = new ScoringMenuView(scoreTable.getNumScoringRows(), scoreTable.getHeight(), scoreTable.getRowHeight());
        possibleScoreExplanation = new GameLabel("Possible scores displayed in grey");
        configureView();
    }

    /** sets component visual settings*/
    public void configureView() {
        setColorSettings();
        setComponentSizes();
        setComponentLocations();
        scoreTable.color(titleColor, columnHeadersColor, possibleScoreColor);
        height = scoreTable.getHeight() + possibleScoreExplanation.getHeight() + 10;
        width = scoreTable.getWidth() + scoringMenu.getWidth();
        this.setSize(width, height);
        this.add(scoreTable);
        this.add(scoringMenu);
        this.add(possibleScoreExplanation);
    }

    /** assigns colors based on current cardId*/
    public void setColorSettings() {
        titleColor = possibleColors[id-1][2];
        columnHeadersColor = possibleColors[id-1][1];
        possibleScoreColor = possibleColors[id-1][0];
    }

    /** sets the posssibleScoreExplanation size*/
    public void setComponentSizes() {
        possibleScoreExplanation.setSize(250, 20);
    }

    /** sets the location of the card components*/
    public void setComponentLocations() {
        scoreTable.setLocation(0, 0);
        scoringMenu.setLocation(scoreTable.getRowWidth(), 0);
        possibleScoreExplanation.setLocation(0, scoreTable.getHeight() + 10);
    }

    /**
    * gets the currently selected row index from the scoring menu
    *
    * @return int value corresponding to the index of the selected row
    */
    public int getSelectedScoringIndex() {
        return scoringMenu.getSelectedIndex();
    }

    /**
    * Hides the button used to select scoring row on a given row
    *
    * @param rowToDelete int value corresponding to the row that needs its scoring button hidden
    */
    public void deleteScoringOption(int rowToDelete) {
        scoringMenu.deleteScoringOption(rowToDelete - 1);
    }

    /** sets the scoring menu to invisible*/
    public void hideScoringMenu() { scoringMenu.setVisible(false); }

    /** sets the scoring menu to visible*/
    public void revealScoringMenu() { scoringMenu.setVisible(true); }
    
    /**
    * gets the scoring menu
    *
    * @return ScoringMenuView with scoring menu data
    */
    public ScoringMenuView getScoringMenu() { return scoringMenu; }

}
