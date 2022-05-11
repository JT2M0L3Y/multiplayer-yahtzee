package edu.gonzaga.ScoreCard;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import java.util.ArrayList;
import edu.gonzaga.GameComponents.GameLabel;

/**
 * The ScoringMenuView class generates a list of radio buttons
 * for use in recording the score of a turn in a player's scorecard.
 * 
 * @author Anna Cardinal
 * @version 1.0 4/22/2022
 */
public class ScoringMenuView extends JPanel {

    private ArrayList<JRadioButton> buttons = new ArrayList<>();
    private ButtonGroup buttonGroup = new ButtonGroup();
    private GameLabel menuExplanation;
    private int rowHeight;
    private int width = 150;
    private int height;

    /**
     * The constructor for the ScoringMenuView class.
     * 
     * @param numScoringRows the number of rows in the scorecard that need buttons
     * @param scoreCardLength the number of rows in the scorecard
     * @param rowHeight the height of each row in the scorecard
     */
    public ScoringMenuView(int numScoringRows, int scoreCardLength, int rowHeight) {
        this.setLayout(null);
        this.height = scoreCardLength;
        this.rowHeight = rowHeight;
        this.setSize(width, height);
        for (int i = 0; i < numScoringRows; i++) {
            buttons.add(new JRadioButton());
            buttonGroup.add(buttons.get(i));
        }
        menuExplanation = new GameLabel("<html>Select Row to<br>Record Score<html>");
        configurePanel();
    }

    /**
     * Method to generate and add components to this panel.
     * 
     * @see ScoringMenyView constructor
     */
    public void configurePanel() {
        setComponentSizes();
        setComponentLocations();
        AddComponents();
    }

    /**
     * Method to set the size of each component in this panel.
     * 
     * @see configurePanel method above
     */
    public void setComponentSizes() {
        for (int i = 0; i < buttons.size(); i++) {
            buttons.get(i).setSize(20, 15);
        }
        menuExplanation.setSize(100, rowHeight * 2);
    }

    /**
     * Method to set the location of each component in this panel.
     * 
     * @see configurePanel method above
     */
    public void setComponentLocations(){
        menuExplanation.setLocation(10, 0);
        for (int i = 0; i < 6; i++){
            buttons.get(i).setLocation(10, (5 + menuExplanation.getHeight() + rowHeight * i));
        }
        for (int i = 6; i < buttons.size(); i++) {
            buttons.get(i).setLocation(10, (5 + menuExplanation.getHeight() + (4 * rowHeight) + rowHeight * i));
        }
    }

    /**
     * Method to add components to this panel.
     * 
     * @see configurePanel method above
     */
    public void AddComponents() {
        this.add(menuExplanation);
        for (int i = 0; i < buttons.size(); i++) {
            this.add(buttons.get(i));
        }
    }

    /**
     * Getter for the index selected by the player.
     * 
     * @return int index of the selected radio button
     */
    public int getSelectedIndex() {
        for (int i = 0; i < buttons.size(); i++) {
            if (buttons.get(i).isSelected()) {
                return i;
            }
        }
        return -1;
    }

    /**
    * Hides the a given button by setting it invisible
    *
    * @param indexToHide int value corresponding to the button to be hidden
    */
    public void deleteScoringOption(int indexToHide) { buttons.get(indexToHide).setVisible(false); }

    /**
    * gets all buttons
    *
    * @return ArrayList<JRadioButton> containing all buttons
    */
    public ArrayList<JRadioButton> getButtons() { return buttons; }
    
}
