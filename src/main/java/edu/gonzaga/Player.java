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

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Player class, composed of a player's hand of dice and their score card. Controls
 * the main functions complete during each game loop. Primarily controls the player's
 * hand, but references a scorecard object to update the player's scorecard.
 * 
 * @author Jonathan Smoley
 * @see "No Borrowed Code"
 */
public class Player {
    /**
     * ArrayList to hold the player's hand of dice. Size can vary
     * based on the number of dice the player will use.
     */
    private ArrayList<Die> playerHand = new ArrayList<Die>();
    /**
     * object to track the possible scores for the player's hand.
     */
    private Scorecard card;
    /**
     * object to hold a reference to the current game being played.
     */
    private Game currGame;
    /**
     * member to hold a stream object
     */
    private Scanner scan;

    /**
     * Constructor for the player class.
     * 
     * @param game object to hold a reference to the current game being played.
     * @param in  object to hold a stream object
     * @see "No Borrowed Code"
     */
    public Player(Game game, Scanner in) {
        this.currGame = game;
        this.scan = in;
        for (int i = 0; i < this.currGame.getDice(); ++i) {
            // add a die with the specified number of sides
            this.playerHand.add(new Die(this.currGame.getSides()));
        }
        // create a set of scores using the current hand
        this.card = new Scorecard(this.playerHand, this.scan);
    }

    /**
     * Method to grab the player's hand.
     * 
     * @return ArrayList<Die> playerHand
     * @see "No Borrowed Code"
     */
    public ArrayList<Die> getHand() {
        return this.playerHand;
    }

    /**
     * Method to run round mechanics all together. Rolls dice, asks user
     * if they want to roll again, sorts dice, and updates scorecard.
     * 
     * @see "No Borrowed Code"
     */
    public void playRound() {
        String keep = "";
        for (int i = 0; i < this.currGame.getDice(); ++i) {
            keep += "n";
        }
        int turn = 0;
        int yCount = 0;
        // give option to view scorecard before each turn
        System.out.print("If you want to view your scorecard enter 'S': ");
        if (this.currGame.grabUserInput(scan).equals("S"))
        {
            this.displayCard();
        }
        // roll all dice initially
        this.playerHand = this.rollHand();
        do {
            yCount = 0;
            // roll dice user doesn't want to keep
            for (int dieNum = 0; dieNum < this.playerHand.size(); ++dieNum) {
                if (keep.charAt(dieNum) == 'n') {
                    this.rollDie(dieNum);
                    continue;
                }
                yCount++;
            }
            // skip to possible scores if user wants to keep all dice
            if (yCount == this.currGame.getDice()) {
                break;
            }
            // output the new roll
            System.out.print("Your roll was: ");
            this.outputRoll();
            System.out.println();
            // ask user if they want to keep dice
            if (turn < this.currGame.getRolls()) {
                System.out.print("enter dice to keep (y or n): ");
                keep = this.currGame.grabUserInput(scan);
            }
            turn++;
        } while (turn < this.currGame.getRolls());
        // output the final roll and the scores according to it
        this.sortHand(this.playerHand);
        System.out.print("Here is your sorted hand: ");
        this.outputRoll();
        System.out.println();
        this.card.computePossibleScores(this.playerHand);
        this.card.outputScores();
        this.card.setScores(this.card.getUserScoreLine());
    }

    /**
     * Method to print the current scorecard. Simply calls the print method
     * composed within the ScoreCard class.
     * 
     * @see "No Borrowed Code"
     */
    public void displayCard() {
        System.out.println("\nSCORE SHEET");
        System.out.println("---------------------");
        // output score for each side of the die
        System.out.println("Upper Section:");
        Integer upperSubTotal = 0;
        for (int i = 0; i < this.currGame.getSides(); ++i) {
                System.out.println(this.card.getScorelines().get(i).getName() + "               "
                    + this.card.getScorelines().get(i).getScore());
                upperSubTotal += this.card.getScorelines().get(i).getScore();
        }
        Integer upperBonus = 0;
        if (upperSubTotal >= 63) {
            upperBonus = 35;
        }
        Integer upperTotal = upperSubTotal + upperBonus;
        System.out.println("---------------------");
        // output upper subtotal, bonus, and total
        System.out.println("Upper Subtotal    " + upperSubTotal);
        System.out.println("Bonus Score       " + upperBonus);
        System.out.println("Total Score       " + upperTotal);
        System.out.println("---------------------");
        // output lower section
        System.out.println("Lower Section:");
        System.out.println(this.card.getScorelines().get(this.currGame.getDice() + 1).getName() + "       " 
            + this.card.getScorelines().get(this.currGame.getDice() + 1).getScore());
        System.out.println(this.card.getScorelines().get(this.currGame.getDice() + 2).getName() + "       " 
            + this.card.getScorelines().get(this.currGame.getDice() + 2).getScore());
        System.out.println(this.card.getScorelines().get(this.currGame.getDice() + 3).getName() + "        " 
            + this.card.getScorelines().get(this.currGame.getDice() + 3).getScore());
        System.out.println(this.card.getScorelines().get(this.currGame.getDice() + 4).getName() + "    " 
            + this.card.getScorelines().get(this.currGame.getDice() + 4).getScore());
        System.out.println(this.card.getScorelines().get(this.currGame.getDice() + 5).getName() + "    " 
            + this.card.getScorelines().get(this.currGame.getDice() + 5).getScore());
        System.out.println(this.card.getScorelines().get(this.currGame.getDice() + 6).getName() + "           " 
            + this.card.getScorelines().get(this.currGame.getDice() + 6).getScore());
        System.out.println(this.card.getScorelines().get(this.currGame.getDice() + 7).getName() + "            " 
            + this.card.getScorelines().get(this.currGame.getDice() + 7).getScore());
        System.out.println("---------------------");
        // compute lower total and grand total
        Integer lowerTotal = 0;
        for (int i = this.currGame.getDice(); i < this.card.getScorelines().size(); ++i) {
            lowerTotal += this.card.getScorelines().get(i).getScore();
        }
        System.out.println("Lower Total       " + lowerTotal);
        System.out.println("Upper Total       " + upperTotal);
        System.out.println("---------------------");
        System.out.println("Grand Total       " + (upperTotal + lowerTotal));
        System.out.println("---------------------");
        System.out.println();
    }

    /**
     * Method to sort the entire hand from smallest to largest side-up value.
     * 
     * @param currHand ArrayList of type Die holds the player's hand
     * @see "No Borrowed Code"
     */
    public void sortHand(ArrayList<Die> hand) {
        Boolean swap;
        Die temp;
        // bubble sort
        do {
            swap = false;
            for (int count = 0; count < hand.size() - 1; count++) {
                if (hand.get(count).getSideUp() > hand.get(count + 1).getSideUp()) {
                    temp = hand.get(count);
                    hand.set(count, hand.get(count + 1));
                    hand.set(count + 1, temp);
                    swap = true;
                }
            }
        } while (swap);
    }

    /**
     * Method to roll every die in a player's hand. As such, it loops throught
     * the length of the ArrayList of dice.
     * 
     * @return ArrayList of type Die holds a new hand of dice
     * @see "No Borrowed Code"
     */
    public ArrayList<Die> rollHand() {
        ArrayList<Die> newHand = new ArrayList<Die>();
        for (int i = 0; i < this.playerHand.size(); i++) {
            newHand.add(new Die(this.currGame.getSides()));
            newHand.get(i).roll();
        }
        return newHand;
    }

    /**
     * Method to roll only one die in a hand given a desired hand index.
     * 
     * @param Integer index location of die to be rolled
     * @see "No Borrowed Code"
     */
    private void rollDie(Integer index) {
        for (int i = 0; i < this.playerHand.size(); i++) {
            if (i == index) {
                this.playerHand.get(i).roll();
            }
        }
    }

    /**
     * Method to print the current hand of dice. Meaning, the current state of
     * the side-up value of each die in the ArrayList of dice.
     * 
     * @see "No Borrowed Code"
     */
    private void outputRoll() {
        for (int diePosition = 0; diePosition < this.playerHand.size(); ++diePosition) {
            System.out.print(this.playerHand.get(diePosition).getSideUp() + " ");
        }
    }
}
