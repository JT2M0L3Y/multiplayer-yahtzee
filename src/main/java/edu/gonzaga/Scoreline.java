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

/**
 * Scoreline class stores necessary attributes of each line in Yahtzee.
 * 
 * @author Jonathan Smoley
 * @see Scorecard class for instantiation
 */
public class Scoreline {
    /**
     * Name for score line.
     */
    private String lineName;
    /**
     * Actual score for line.
     */
    private Integer currentScore;
    /**
     * Possible score for line.
     */
    private Integer possibleScore;
    /**
     * Code user enters for this line.
     */
    private String lineCode;
    /**
     * Whether or not the line has been included for actual score.
     */
    private Boolean used;

    /**
     * Constructor for Scoreline class.
     * 
     * @param name name of score line
     * @param score recorded score for line
     * @param possible possible score for line
     * @param code code user enters for this line
     * @param status whether or not the line has been included for actual score
     * @see Scorecard class for instantiation
     */
    public Scoreline(String name, Integer score, Integer possible, String code, Boolean status) {
        this.lineName = name;
        this.currentScore = score;
        this.possibleScore = possible;
        this.lineCode = code;
        this.used = status;
    }

    /**
     * Accessor for the line name.
     * 
     * @return String name of line.
     * @see "No Borrowed Code"
     */
    public String getName() {
        return this.lineName;
    }

    /**
     * Accessor for the line's tracked score.
     * 
     * @return Integer score of line.
     * @see "No Borrowed Code"
     */
    public Integer getScore() {
        return this.currentScore;
    }

    /**
     * Accessor for the line's possible score.
     * 
     * @return Integer possible score of line.
     * @see "No Borrowed Code"
     */
    public Integer getPossible () {
        return this.possibleScore;
    }

    /**
     * Accessor for the line's code.
     * 
     * @return String code of line.
     * @see "No Borrowed Code"
     */
    public String getCode() {
        return this.lineCode;
    }

    /**
     * Accessor for the line's used status.
     * 
     * @return Boolean used status of line.
     * @see "No Borrowed Code"
     */
    public Boolean getUsed() {
        return this.used;
    }

    /**
     * Setter for line name.
     * 
     * @param name String name of line.
     * @see "No Borrowed Code"
     */
    public void setName(String name) {
        this.lineName = name;
    }

    /**
     * Setter for line's tracked score.
     * 
     * @param score the score to be set
     * @see "No Borrowed Code"
     */
    public void setScore(Integer score) {
        this.currentScore = score;
    }

    /**
     * Setter for line's possible score.
     * 
     * @param possible Integer possible score of line.
     * @see "No Borrowed Code"
     */
    public void setPossible(Integer possible) {
        this.possibleScore = possible;
    }

    /**
     * Setter for line's code.
     * 
     * @param code the code to set
     * @see "No Borrowed Code"
     */
    public void setCode(String code) {
        this.lineCode = code;
    }

    /**
     * Setter for line's used status.
     * 
     * @param status the used status to set
     * @see "No Borrowed Code"
     */
    public void setUsed(Boolean status) {
        this.used = status;
    }
}
