/**
 * This program is a Yahtzee game.
 * CPSC 224-01, Spring 2022
 * HW #3
 * No Sources to cite
 * 
 * @author Jonathan Smoley
 * @version v3.5 3/5/2022
 */
package edu.gonzaga;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

/**
 * Game class composed of a method to play the game Yahtzee.
 * Specifically, it creates a new player object, calls the 
 * method to run a game loop, and requests to output a scorecard.
 * 
 * @author Jonathan Smoley
 * @see "No Borrowed Code"
 */
public class Game {
    /**
     * Number of sides on each die.
     */
    private Integer numSides = 6;
    /**
     * Number of dice to be used in the game.
     */
    private Integer numDice = 5;
    /**
     * number of rolls to be played in a round.
     */
    private Integer numRolls = 3;
    /**
     * reference to input stream for user input
     */
    private Scanner input;

    /**
     * Method to link a player object to the game loop.
     * 
     * @param in reference to input stream for user input
     * @see "Yahtzee.java" for use of the Game object
     */
    public void playGame(Scanner in) {
        this.input = in;
        // organize game configuration
        this.readConfig();
        this.displayConfig();
        System.out.print("If you would like to change the configuration enter 'y': ");
        // only change configuration if user requests
        if (this.grabUserInput(input).equals("y")) {
            this.setConfig();
            this.readConfig();
            this.displayConfig();
        }
        System.out.println();
        // create player object
        Player player = new Player(this, input);
        // run rounds until lines are all chosen
        for (int i = 0; i < (numSides + 7); ++i)
        {
            player.playRound();
        }
        // output the scorecard plus bonus and total score
        System.out.println("Final Score Sheet: ");
        player.displayCard();
    }

    /**
     * Setter for numSides.
     *
     * @param newSideCount the number of sides each die will have
     * @see "No Borrowed Code"
     */
    public void setNumSides(Integer newSideCount) {
        this.numSides = newSideCount;
    }

    /**
     * Setter for numDice.
     *
     * @param newDiceCount the number of dice the player will roll
     * @see "No Borrowed Code"
     */
    public void setNumDice(Integer newDiceCount) {
        this.numDice = newDiceCount;
    }

    /**
     * Setter for numRolls.
     * 
     * @param newRollCount the number of rolls the player will have
     * @see "No Borrowed Code"
     */
    public void setNumRolls(Integer newRollCount) {
        this.numRolls = newRollCount;
    }

    /**
     * Getter for numSides.
     * 
     * @return Integer number of sides on a die
     * @see "No Borrowed Code"
     */
    public Integer getSides() {
        return this.numSides;
    }

    /**
     * Getter for numDice.
     *      
     * @return Integer number of dice
     * @see "No Borrowed Code"
     */
    public Integer getDice() {
        return this.numDice;
    }

    /**
     * Getter for numRolls.
     * 
     * @return Integer number of rolls
     * @see "No Borrowed Code"
     */
    public Integer getRolls() {
        return this.numRolls;
    }

    /**
     * Method to read user input from the console.
     * 
     * @param in the Scanner object to read from
     * @return String user input
     * @see "No Borrowed Code"
     */
    public String grabUserInput(Scanner in) {
        String userStr = in.nextLine();
        return userStr;
    }

    /**
     * Method to retrieve the game settings from a file.
     * 
     * @see "No Borrowed Code"
     */
    private void readConfig() {
        // read from input file, test for errors
        try {
            String home = System.getProperty("user.dir");
            File config = new File(home + "/yahtzeeConfig.txt");
            Scanner input = new Scanner(config);
            // read each line and store into game member variables
            for (int i = 0; i < 4; ++i) {
                // only 3 game configuration settings to change
                switch (i) {
                    case 0:
                        setNumSides(input.nextInt());
                        break;
                    case 1:
                        setNumDice(input.nextInt());
                        break;
                    case 2:
                        setNumRolls(input.nextInt());
                        break;
                }
            }
            input.close();
        }
        catch (Exception ex) {
            System.out.println("Error reading file: " + ex.getMessage());
            return;
        }
    }

    /**
     * Method to display the contents of a configuration file.
     * 
     * @see "No Borrowed Code"
     */
    private void displayConfig() {
        System.out.println("The game is set to use " + getDice() + " "
                            + getSides() + "-sided dice.");
        System.out.println("A player will get " + getRolls() + " rolls per hand.");
    }

    /**
     * Method to write current user's settings to a configuration file.
     * 
     * @see "No Borrowed Code"
     */
    private void setConfig() {
        String home = System.getProperty("user.dir");
        // catch error writing to the file
        try {
            FileWriter writer = new FileWriter(home + "/yahtzeeConfig.txt");
            System.out.print("Enter the number of sides each die will have: ");
            writer.write(grabUserInput(input) + "\n");
            System.out.print("Enter the number of dice the player will use: ");
            writer.write(grabUserInput(input) + "\n");
            System.out.print("Enter the number of rolls the player will have: ");
            writer.write(grabUserInput(input) + "\n");
            writer.close();
            System.out.println();
        }
        catch (Exception ex) {
            System.out.println("Error writing to file: " + ex.getMessage());
            return;
        }
    }
}
