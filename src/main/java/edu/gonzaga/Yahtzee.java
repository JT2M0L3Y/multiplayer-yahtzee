/**
 * This program is a Yahtzee game.
 * ! Important: full house not adjusted for 6+ dice hands
 * CPSC 224-01, Spring 2022
 * HW #3
 * No Sources to cite
 * 
 * @author Jonathan Smoley
 * @version v3.5 3/5/2022
 */
package edu.gonzaga;

import java.util.Scanner;

/** 
 * <pre>
 * Main program class for launching this Yahtzee program. Uses
 * composition to form a 'has-a' relationship between the objects
 * that are included.
 * 
 * Extra Credit:
 * No extra credit was attempted for this project. 
 * 
 * History:
 * v1.0 1/24/2022: created basic game/round loop, scorecard, and console output
 * v2.0 2/9/2022: added user game config via file I/O, adjusted scoring accordingly
 * v3.0 3/3/2022: began tracking scores for each line in scorecard between rounds
 * </pre>
 * 
 * @author Jonathan Smoley
 * @see "No Borrowed Code"
*/
public class Yahtzee {
    /**
     * Main method, the entry point for this Yahtzee program.
     * Loops through games until the user decides to quit.
     * 
     * @param args a String array of command line arguments
     * @see "No Borrowed Code"
     */
    public static void main(String[] args) {
        String playAgain = "n";
        Scanner userInput = new Scanner(System.in);
        do {
            Game newGame = new Game();
            System.out.println("Starting a new game of Yahtzee!\n");
            newGame.playGame(userInput);
            System.out.print("Enter 'y' to play again ");
            playAgain = userInput.nextLine();
        } while (playAgain.equals("y"));
        userInput.close();
    }
}
