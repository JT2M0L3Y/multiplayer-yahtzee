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

import java.util.Random;

/** 
 * Class to store the state of a single die. 
 * 
 * @author Jonathan Smoley
 * @see "No Borrowed Code"
 */
public class Die implements Comparable<Die> {
    /**
     * Tracks the number of side facing up on the die.
     */
    private Integer sideUp;
    /**
     * Tracks the number of sides on the die.
     */
    private Integer numSides;
    /**
     * Provides a default value for the number of sides on the die.
     */
    private static final Integer DEFAULT_NUM_SIDES = 6;
    /**
     * Provides a default value for starting side up on the die.
     */
    private static final Integer DEFAULT_SIDE_UP = 1;

    // Constructor
    public Die() {
        this.numSides = DEFAULT_NUM_SIDES;
        this.sideUp = DEFAULT_SIDE_UP;
    }

    // Constructor Overload
    public Die(Integer numSides) {
        this.numSides = numSides;
        this.sideUp = DEFAULT_SIDE_UP;
    }

    // Constructor Overload
    public Die(Integer numSides, Integer startingSide) {
        this.numSides = numSides;
        this.sideUp = startingSide;
    }

    /** 
     * Rolls the die once, getting new random value. 
     * 
     * @see "No Borrowed Code"
     */
    public void roll() {
        Random rand = new Random();
        this.sideUp = rand.nextInt(this.numSides) + 1;
    }

    /**
    * Returns current die value (the side that's up).
    *
    * @return Integer Current Die's Side Up
    */
    public Integer getSideUp() {
        return this.sideUp;
    }
    
    /**
    * Returns quantity of sides on the die.
    *
    * @return Integer number of sides on the die
    */
    public Integer getNumSides() {
        return this.numSides;
    }

    /**
    * Provides the ability to convert the Die object into a string. representation, both with
    * .toString(), but also in System.out.println()
    *
    * @return String of whatever you want this die to say for itself
    */
    @Override
    public String toString() {
        String ret = "";
        // ret += "Die: " + this.sideUp.toString() + " of " + this.numSides.toString() + " sides";
        ret += this.sideUp.toString();
        return ret;
    }

    /**
    * Makes two dice comparable using <, ==, >, etc. based on sideUp values.
    *
    * @param otherDie The die we're comparing to this one (two objects)
    * @return int -1, 0, 1 for less than, equal, greater than
    */
    @Override
    public int compareTo(Die otherDie) {
        return this.sideUp.compareTo(otherDie.sideUp);
    }
}
