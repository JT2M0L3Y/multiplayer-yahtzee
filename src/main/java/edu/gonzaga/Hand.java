package edu.gonzaga;

import edu.gonzaga.GameComponents.GameButton;
import edu.gonzaga.GameComponents.GameLabel;
import javax.swing.*;

/**
 * Class to create an array of Dice and manage them
 * One per GameWindow
 * 
 * @author Tyler Kamphouse
 * @version final 5/06/2022
 */
public class Hand {

    private static final int DEFAULT_COMPONENT_LENGTH = 30;
    private static final int ROLL_LABEL_X_COORDINATE = 0;
    private static final int ROLL_LABEL_Y_COORDINATE = 0;
    private static final int ROLL_LABEL_WIDTH = 160;
    private static final int EXPLANATION_ROLLING_X_COORDINATE = 0;
    private static final int EXPLANATION_ROLLING_Y_COORDINATE = 50;
    private static final int EXPLANATION_ROLLING_WIDTH = 160;
    private static final int ROLL_BUTTON_X_COORDINATE = 20;
    private static final int ROLL_BUTTON_WIDTH = 120;
    private static final int LENGTH = 550;

    private Die[] dice;
    private int numDice = 5;
    private int rollCount;

    private JPanel[] dicePanels;
    private JPanel curPanel;
    private GameLabel numRollsLabel;
    private GameLabel rollTextLabel;
    private GameButton rollButton;

    /**
     * Default constructor for the Hand class.
     * creates an array of 5 die
     */
    public Hand() {
        rollCount = 0;
        dice = new Die[numDice];
        for(int i = 0; i < numDice; i++) {
            dice[i] = new Die();
        }
        configureView();
    }

    /**
     * Overloaded constructor for the Hand class.
     * creates an array of 5 die, initializes to param values
     * 
     * @param array of integer values for die to initialize to
     * @see Hand Default Constructor
     */
    public Hand(int[] values) {
        rollCount = 0;
        dice = new Die[numDice];
        for(int i = 0; i < numDice; i++) {
            dice[i] = new Die();
        }
        for (int i = 0; i < this.numDice; ++i) {
            dice[i].setValue(values[i]);
        }
        configureView();
    }

    /**
     * Method to return all of the Dice in Hand
     * 
     * @return (Die[]) ArrayList of all Dice in Hand
     */
    public Die[] returnHand() {
        return dice;
    }

    /**
     * Method to return the value of a given Die in Hand
     * 
     * @param index of the Die in Hand
     * @return (int) Value of Die at index
     */
    public int returnValue(int index) {
        int value = 0;
        if (index < numDice && index >= 0) {
            value = dice[index].getSideUp();
        }
        return value;
    }

    /**
     * Method to return all of the Dice Values in Hand
     * 
     * @see returnValue(int)
     * @return (int[]) Array of values of all dice
     */
    public int[] returnAllValues() {
        int[] values = new int[numDice];
        for(int i = 0; i < numDice; i++) {
            values[i] = dice[i].getSideUp();
        }
        return values;
    }

    /**
     * Method to return amount of times the hand has been rolled
     * 
     * @see reset()
     * @return (int) times hand has been rolled
     */
    public int rollCount() {
        return rollCount;
    }

    /**
     * Method to rreset the values of Dice in Hand
     * Resets rollCount, sets Die values to 1
     * 
     * @see reset()
     */
    public void reset() {
        rollCount = 0;
        setRollLabel(3, rollCount);
        for (int i = 0; i < this.numDice; ++i) {
            dice[i].setValue(1);
            dice[i].deselectButton();
        }
        revealRollButton();
    }

    /**
     * Method to roll new values for dice in Hand
     * Increases rollCount, hides roll button when >= 3
     * 
     * @see rollCount()
     * @see Die.roll()
     */
    public void RollNewHand() {
        rollCount++;
        setRollLabel(3, rollCount);
        for (int i = 0; i < this.numDice; ++i) {
            dice[i].roll();
        }
        if (rollCount == 1) {
            revealDiceButtons();
        }
        if (rollCount >= 3) {
            hideDiceButtons();
            hideRollButton();
        }
    }

    /**
     * Method to return all of the dice in hand
     * 
     * @see getDie()
     * @return (Die[]) Array of all the Dice in Hand
     */
    public Die[] getDice() {
        return dice;
    }

    /**
     * Method to return a given Die in Hand
     * 
     * @param index of the Die in Hand
     * @return (Die) Die at index
     */
    public Die getDie(int index) {
        return dice[index];
    }

    /**
     * Method to return the number of dice in hand
     * 
     * @return (int) number of Dice
     */
    public int getSize() {
        return numDice;
    }

    /**
     * Method to return if the player's turn is over
     * 
     * @see rollCount()
     * @return (boolean) true if rollcount >= 3, false otherwise
     */
    public boolean isTurnOver() {
        if (rollCount >= 3) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Method to return Hand as a string
     * 
     * @return (String) Hand as a string
     */
    public String toString() {
        String ret = "";
        ret += "Hand: ";
        for (Die die : dice) {
            ret += die.toString() + " | ";
        }
        return ret;
    }

    /**
     * Method to return a sum of all the Dice values in Hand
     * 
     * @return (int) the sum of Die values
     */
    public int sum() {
        int sum = 0;
        for(int i = 0; i < numDice; i++) {
            sum += dice[i].getSideUp();
        }
        return sum;
    }

    /**
     * Method to setup the visual elements of Hand
     * 
     * @see GameLabel
     * @see ConfigurePanel()
     * @see setComponentLocations()
     */
    private void configureView() {
        numRollsLabel = new GameLabel("Not Assigned", SwingConstants.CENTER);
        setRollLabel(3, rollCount);
        numRollsLabel.setTextSize(20);
        rollTextLabel = new GameLabel("Select Dice to Keep", SwingConstants.CENTER);
        rollTextLabel.setTextSize(20);
        rollTextLabel.setVisible(false);
        dicePanels = new JPanel[numDice];
        rollButton = new GameButton("Roll", dice[0].getNumSides());
        setComponentLocations();
        configurePanel();
    }

    /**
     * Method to set Location Coordinates of Visual Components
     * 
     * @see .setBounds(int, int, int, int)
     * @see setDiceLocations(int)
     */
    private void setComponentLocations() {
        numRollsLabel.setBounds(ROLL_LABEL_X_COORDINATE, ROLL_LABEL_Y_COORDINATE, ROLL_LABEL_WIDTH, DEFAULT_COMPONENT_LENGTH);
        rollTextLabel.setBounds(EXPLANATION_ROLLING_X_COORDINATE, EXPLANATION_ROLLING_Y_COORDINATE, EXPLANATION_ROLLING_WIDTH, DEFAULT_COMPONENT_LENGTH);
        rollButton.setBounds(ROLL_BUTTON_X_COORDINATE, LENGTH - 30, ROLL_BUTTON_WIDTH, DEFAULT_COMPONENT_LENGTH);
        setDiceLocations(dice[0].getNumSides());
    }

    /**
     * Method to set the Location Coordinates of Dice
     * 
     * @param number of sides on die
     * @see DieView.setLocation
     */
    public void setDiceLocations(int typeDice) {
        int rowNum = 0;
        for(int i = 0; i < numDice; i++) {
            dicePanels[i] = dice[i].getView(); //NEEDS TO BE CHECK FOR COMBATIBILITY WITH DIE()
            if (i % 2 == 0) {
                dicePanels[i].setLocation(20 + 0, 120 + (rowNum * 75));
            } else {
                dicePanels[i].setLocation(20 + 70, 120 + (rowNum * 75));
                rowNum++;
            }
        }
    }

    /**
     * Method to initialize the Hand View Panel
     * 
     * @see configureView()
     */
    public void configurePanel() {
        curPanel = new JPanel();
        curPanel.setLayout(null);
        curPanel.setOpaque(false);
        curPanel.setSize(160, LENGTH);
        numRollsLabel.setSize(150, 75);
        curPanel.add(numRollsLabel);
        curPanel.add(rollTextLabel);
        for(int i = 0; i < numDice; i++) {
            curPanel.add(dicePanels[i]);
        }
        curPanel.add(rollButton);
    }

    /**
     * Method to set the Text at the top of Hand Panel
     * 
     * @param number of rolls per player turn
     * @param number of rolls
     * @see GameLabel
     */
    public void setRollLabel(int rollsPerTurn, int rollCount){
        if ((rollsPerTurn - rollCount) == 1) {
            numRollsLabel.setText("<html>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Roll " + Integer.toString(rollCount) + " <br>(" + Integer.toString(rollsPerTurn - rollCount) + " Roll Left)<html>");
        } else {
            numRollsLabel.setText("<html>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Roll " + Integer.toString(rollCount) + " <br>(" + Integer.toString(rollsPerTurn - rollCount) + " Rolls Left)<html>");
        }
    }

    /**
     * Method to set Explaination Label to Final Hand
     */
    public void setExplanationLabelScoringMode() {
        rollTextLabel.setText("Final Hand");
    }

    /**
     * Method to set Explaination Label when not Final Hand
     */
    public void resetExplanationLabelText() {
        rollTextLabel.setText("Select Dice to Keep");
        rollTextLabel.setVisible(true);
    }

    /**
     * Method to set visibility of roll button
     */
    public void hideRollButton() {
        rollButton.setVisible(false);
    }

    /**
     * Method to set invisibility of roll button
     */
    public void revealRollButton() {
        rollButton.setVisible(true);
    }

    /**
     * Method to set invisibility of roll button
     */
    public void hideDiceButtons() {
        for(int i = 0; i < numDice; i++) {
            dice[i].setButtonInvisibility(); 
        }
    }

    /**
     * Method to set visibility of roll button
     */
    public void revealDiceButtons() {
        for(int i = 0; i < numDice; i++) {
            dice[i].setButtonVisibility();  
        }
    }

    /**
     * Method to set invisibility of roll button
     */
    public void hideRollText() {
        rollTextLabel.setVisible(false);
    }

    /**
     * Method to set visibility of roll button
     */
    public void showRollText() {
        rollTextLabel.setVisible(true);
    }

    /**
     * Method to return the JLabel displaying Rolls
     */
    public JLabel getRollLabel() {
        return numRollsLabel;
    }

    /**
     * Method to return the JButton to Roll Dice
     */
    public JButton getRollButton() {
        return rollButton;
    }

    /**
     * Method to return the JPanel of Hand View
     */
    public JPanel getAppearance() {
        return curPanel;
    }

}
