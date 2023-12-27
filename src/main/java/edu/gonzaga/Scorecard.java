/**
 * This program is a Yahtzee game.
 * CPSC 224-01, Spring 2022
 * HW #3
 * No sources to site
 * 
 * @author Jonathan Smoley
 * @version v3.5 3/5/2022
 */
package edu.gonzaga;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * ScoreCard class composed of a player's Yahtzee scores based on the current roll.
 * Computes a mix of boolean states and integer values to determine what scores to
 * provide for each possible Yahtzee score.
 * 
 * @author Jonathan Smoley
 * @see "No Borrowed Code"
 */
public class Scorecard {
    /**
     * ArrayList of Scoreline objects.
     */
    private ArrayList<Scoreline> scorelines;
    /** 
     * Scanner object to read user input.
     */
    private Scanner scan;
    
    /**
     * Constructor for Scorecard class.
     * 
     * @param hand ArrayList of Die objects to be used in the scorecard.
     * @param in Scanner object to read user input.
     * @see "No Borrowed Code"
     */
    public Scorecard(ArrayList<Die> hand, Scanner in) {
        // initialize upper scorelines in scorelines arraylist
        this.scorelines = new ArrayList<Scoreline>();
        for (int i = 0; i < hand.get(0).getNumSides(); ++i) {
            this.scorelines.add(new Scoreline((Integer.toString(i + 1) + "'s"), 0, 0, (Integer.toString(i + 1)), false));
        }
        // initialize lower scorelines in scorelines arraylist
        this.scorelines.add(new Scoreline("3 of a Kind", 0, 0, "3K", false));
        this.scorelines.add(new Scoreline("4 of a Kind", 0, 0, "4K", false));
        this.scorelines.add(new Scoreline("Full House", 0, 0, "FH", false));
        this.scorelines.add(new Scoreline("Small Straight", 0, 0, "SS", false));
        this.scorelines.add(new Scoreline("Large Straight", 0, 0, "LS", false));
        this.scorelines.add(new Scoreline("Yahtzee", 0, 0, "YZ", false));
        this.scorelines.add(new Scoreline("Chance", 0, 0, "CH", false));
        // copy scanner object to local variable
        this.scan = in;
    }

    /**
     * Method to access the scorelines arraylist in scorecard object.
     * 
     * @return ArrayList<Scoreline> scorelines
     * @see "No Borrowed Code"
     */
    public ArrayList<Scoreline> getScorelines() {
        return this.scorelines;
    }

    /**
     * Method to evaluate the possible scores for each line based on the hand.
     * 
     * @param hand reference to current hand of dice
     * @see "No Borrowed Code"
     */
    public void computePossibleScores(ArrayList<Die> hand) {
        // loop through each side on die
        Integer dieValue = 0;
        for (dieValue = 1; dieValue < hand.get(0).getNumSides() + 1; ++dieValue) {
            Integer currentCount = 0;
            // loop through each die in the hand
            for (int diePosition = 0; diePosition < hand.size(); ++diePosition) {
                if (hand.get(diePosition).getSideUp() == dieValue) {
                    currentCount++;
                }
            }
            // set new score values for each side type
            this.scorelines.get(dieValue - 1).setPossible(dieValue * currentCount);
        }
        // set 3 of a kind scores
        if (this.scorelines.get(dieValue -= 1).getUsed() == false &&  this.findMaxOfAKind(hand) >= 3) {
            this.scorelines.get(dieValue).setPossible(this.totalAllDice(hand));
        }
        // set 4 of a kind scores
        if (this.scorelines.get(dieValue++).getUsed() == false && this.findMaxOfAKind(hand) >= 4) {
            this.scorelines.get(dieValue).setPossible(this.totalAllDice(hand));
        }
        // set full house score
        if (this.scorelines.get(dieValue++).getUsed() == false && this.findFullHouse(hand)) {
            this.scorelines.get(dieValue).setPossible(25);
        }
        // set small straight score
        if (this.scorelines.get(dieValue++).getUsed() == false && this.findSmlStraight(hand)) {
            this.scorelines.get(dieValue).setPossible(30);
        }
        // set large straight score
        if (this.scorelines.get(dieValue++).getUsed() == false && this.findLrgStraight(hand)) {
            this.scorelines.get(dieValue).setPossible(40);
        }
        // set yahtzee score
        if (this.scorelines.get(dieValue++).getUsed() == false && this.findYahtzee(hand)) {
            this.scorelines.get(dieValue).setPossible(50);
        }
        else if (this.scorelines.get(dieValue).getUsed() == false && !this.findYahtzee(hand)) {
            this.scorelines.get(dieValue).setPossible(0);
        }
        // set chance score
        if (this.scorelines.get(dieValue++).getUsed() == false) {
            this.scorelines.get(dieValue).setPossible(this.totalAllDice(hand));
        }
    }

    /**
     * Method to print the upper and lower section scores to the console.
     * 
     * @see "No Borrowed Code"
     */
    public void outputScores() {
        for (int ndx = 0; ndx < this.scorelines.size(); ++ndx) {
            if (this.scorelines.get(ndx).getUsed() == false) {
                System.out.println("Score " + this.scorelines.get(ndx).getPossible() + " on the "
                        + this.scorelines.get(ndx).getName() + " line (" 
                        + this.scorelines.get(ndx).getCode() + ")");
            }
        }
        System.out.println();
    }

    /**
     * Method to initialize the status of each line before every round.
     * 
     * @see "No Borrowed Code"
     */
    public void setScores(Integer userIndex)
    {
        // set actual scores for each line not already used
        for (int ndx = 0; ndx < this.scorelines.size(); ++ndx)
        {
            if (this.scorelines.get(ndx).getCode() == this.scorelines.get(userIndex).getCode())
            {
                this.scorelines.get(ndx).setScore(this.scorelines.get(ndx).getPossible());
                this.scorelines.get(ndx).setUsed(true);
                break;
            }
        }
    }

    /**
     * Method to change the status of a the line depending on user's choice
     * to keep the score at that line.
     * 
     * @return Integer for index of line chosen
     * @see "No Borrowed Code"
     */
    public Integer getUserScoreLine()
    {
        System.out.println("Which score would you like to keep? Enter a line code given above: ");
        String userInput = this.scan.nextLine();
        // loop through each line code
        Integer userLine = 0;
        for (int i = 0; i < this.scorelines.size(); ++i)
        {
            // if the user input matches the line code then return the index
            if (userInput.equals(this.scorelines.get(i).getCode()))
            {
                userLine = i;
                break;
            }
        }
        return userLine;
    }

    /**
     * Method to determine what the largest count of a single side-up value is.
     * 
     * @param hand reference to current hand of dice
     * @return Integer value of the largest count of a single side-up value
     * @see "No Borrowed Code"
     */
    public Integer findMaxOfAKind(ArrayList<Die> hand) {
        Integer maxCount = 0;
        Integer currentCount;
        for (int dieValue = 1; dieValue < hand.get(0).getNumSides() + 1; dieValue++) {
            currentCount = 0;
            for (int diePosition = 0; diePosition < hand.size(); diePosition++) {
                if (hand.get(diePosition).getSideUp() == dieValue) {
                    currentCount++;
                }
            }
            if (currentCount > maxCount) {
                maxCount = currentCount;
            }
        }
        return maxCount;
    }
 
    /**
     * Method to determine if a small straight is present in the final hand of the round.
     * 
     * @param hand reference to current hand of dice
     * @return boolean value of whether or not a small straight is present
     * @see "No Borrowed Code"
     */
    public Boolean findSmlStraight(ArrayList<Die> hand) {
        Integer count = 1;
        for (int counter = 0; counter < (hand.size() - 1); counter++) {
            if (hand.get(counter).getSideUp() + 1 == hand.get(counter + 1).getSideUp()) {
                count++;
            }
            else if (hand.get(counter).getSideUp() + 1 < hand.get(counter + 1).getSideUp()) {
                count = 1;
            }
        }
        // test if straight is 1 less than size of hand
        if (count >= (hand.size() - 1)) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Method to determine if a large straight is present in the final hand of the round.
     * 
     * @param hand reference to current hand of dice
     * @return boolean value of whether or not a large straight is present
     * @see "No Borrowed Code"
     */
    public Boolean findLrgStraight(ArrayList<Die> hand) {
        Integer count = 1;
        for (int counter = 0; counter < (hand.size() - 1); counter++) {
            if (hand.get(counter).getSideUp() + 1 == hand.get(counter + 1).getSideUp()) {
                count++;
            }
            else if (hand.get(counter).getSideUp() + 1 < hand.get(counter + 1).getSideUp()) {
                count = 1;
            }
        }
        // test if straight is size of hand
        if (count == hand.size()) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Method to determine if a full house is present in the final hand of the round.
     * 
     * @param hand reference to current hand of dice
     * @return boolean value of whether or not a full house is present
     * @see "No Borrowed Code"
     */
    public Boolean findFullHouse(ArrayList<Die> hand) {
        Boolean foundFH = false;
        Boolean foundMaxK = false;
        Boolean foundMinK = false;
        Integer currentCount;
        // loop through each side type on a die
        for (int dieValue = 1; dieValue < hand.get(0).getNumSides() + 1; dieValue++) {
            currentCount = 0;
            // loop through each die in the hand
            for (int diePosition = 0; diePosition < hand.size(); diePosition++) {
                // count sides matching the current side type
                if (hand.get(diePosition).getSideUp() == dieValue) {
                    currentCount++;
                }
            }
            if (currentCount == 2) {
                foundMinK = true;
            }
            else if (currentCount == 3) {
                foundMaxK = true;
            }
        }
        if (foundMinK && foundMaxK) {
            foundFH = true;
        }
        return foundFH;
    }

    /**
     * Method to determine if a yahtzee is present in the final hand of the round.
     * 
     * @param currentHand reference to current hand of dice
     * @return boolean value of whether or not a yahtzee is present
     * @see "No Borrowed Code"
     */
    public Boolean findYahtzee(ArrayList<Die> hand) {
        int count = 0;
        for (int i = 1; i < hand.get(0).getNumSides() + 1; ++i) {
            count = 0;
            for (int j = 0; j < hand.size(); ++j) {
                if (hand.get(j).getSideUp() == i) {
                    count++;
                }
            }
            // if there is a Yahtzee detected, set the score and exit
            if (count == hand.size()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Method to sum the side-up values of each die in the hand ArrayList. To be 
     * used in the chance line and the 'n' of a kind lines.
     * 
     * @param currentHand reference to current hand of dice
     * @return Integer value of the sum of the side-up values of each die in the hand
     * @see "No Borrowed Code"
     */
    public Integer totalAllDice(ArrayList<Die> hand) {
        Integer total = 0;
        for (int diePosition = 0; diePosition < hand.size(); diePosition++) {
            total += hand.get(diePosition).getSideUp();
        }
        return total;
    }
}
