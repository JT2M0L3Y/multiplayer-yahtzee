package edu.gonzaga;

import edu.gonzaga.ScoreCard.PlayerScoreCard;
import edu.gonzaga.ScoreCard.PlayerScoreCardView;

import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.*;

/**
 * Player is the class that defines what a player has and does during the Yahtzee game.
 * 
 * @author Anna Cardinal
 * @version 1.0 4/22/2022
 */
public class Player {

    private PlayerScoreCard playerScoreCard;
    private String name;
    private Boolean playing = false;

    /**
     * Overloaded Constructor for the Player class
     * 
     * @param name the name the give the created player
     */
    public Player(String name) {
        this.name = name;
        playerScoreCard = new PlayerScoreCard(name, 6);
        setNotPlaying();
        hideScoringMenu();
    }

    /**
     * Overloaded Constructor for the Player class
     * 
     * @param name the name the give the created player
     * @param scoreButton the button used to change scorelines in the player's card
     */
    public Player(String name, JButton scoreButton) {
        this.name = name;
        playerScoreCard = new PlayerScoreCard(name, 6);
        setNotPlaying();
        hideScoringMenu();
        attachScoreButton(scoreButton);
    }

    /**
     * Overloaded Constructor for the Player class
     * 
     * @param name the name the give the created player
     * @param scoreButton the button used to change scorelines in the player's card
     * @param playing boolean value to determine if it is/was this player's turn
     */
    public Player(String name, JButton scoreButton, boolean playing) {
        this.name = name;
        playerScoreCard = new PlayerScoreCard(name, 6);
        if (playing) {
            setPlaying();
        } else {
            setNotPlaying();
        }
        hideScoringMenu();
        attachScoreButton(scoreButton);
    }

    /**
     * Method to add the score button to the window
     * 
     * @param scoreButton the button used to change scorelines in the player's card
     * @see Player constructor(s)
     */
    public void attachScoreButton(JButton scoreButton) {
        int numButtons = playerScoreCard.getPlayerScoreCardView().getScoringMenu().getButtons().size();
        JRadioButton tempButton;
        for (int i = 0; i < numButtons; i++) {
            tempButton = playerScoreCard.getPlayerScoreCardView().getScoringMenu().getButtons().get(i);
            tempButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent event) {
                    scoreButton.setVisible(true);
                }
            });
        }
    }

    /**
     * Getter for the player's score on a given row.
     * 
     * @param row the row to get the score from
     * @return int the score on the given row
     * @see GameWindow.java
     */
    public int getScore(int row) {
        return playerScoreCard.getScore(row);
    }

    /**
     * Getter for the player's total score.
     * 
     * @param row the row to get the score from
     * @return int the total score
     * @see GameWindow.java
     */
    public int getTotalScore(int row) {
        return playerScoreCard.getTotalScore(row);
    }

    /**
     * Getter for the player's final score.
     * 
     * @return int the final score
     * @see EndGameWindow.java
     */
    public int getFinalScore() {
        return playerScoreCard.getFinalScore();
    }

    /**
     * Getter for the view object associated with Player's scorecard.
     * 
     * @return PlayerScoreCardView the view object associated with Player's scorecard
     * @see PlayerScoreCard.java
     */
    public PlayerScoreCardView getView() {
        return playerScoreCard.getPlayerScoreCardView();
    }
    
    /**
     * Getter for the player's name.
     * 
     * @return String the player's name
     * @see GameWindow.java, EndGameWindow.java
     */
    public String getName() {
        return name;
    }

    /**
     * Method to determine if game has ended by looking for an unscored line.
     * 
     * @return boolean true if all lines are full, false otherwise
     * @see GameWindow.java
     */
    public boolean checkScoreCardFull() {
        return playerScoreCard.checkFull();
    }

    /**
     * Method to check if there a available lines on a player's scorecard.
     * 
     * @return int the number of available lines
     * @see GameWindow.java
     */
    public int checkScoreCardAvailableSpace() {
        return playerScoreCard.checkAvailableSpace();
    }

    /**
     * Method to set current player to viewable player.
     * 
     * @see GameWindow.java
     */
    public void setPlaying() {
        this.playing = true;
        this.playerScoreCard.getPlayerScoreCardView().setVisible(true);
    }

    /**
     * Method to set current player to non-viewable player.
     * 
     * @see GameWindow.java
     */
    public void setNotPlaying() {
        this.playing = false;
        this.playerScoreCard.getPlayerScoreCardView().setVisible(false);
    }

    /**
     * Method to show a possible score for every line that has not been filled.
     * 
     * @param currentHand used to compute the possible scores for each roll
     * @see GameWindow.java
     */
    public void showPossibleScores(Hand currentHand) {
        playerScoreCard.displayPossibleScores(currentHand);
    }

    /**
     * Method to clear the possible scores list upon end of turn/start of new turn.
     * 
     * @see GameWindow.java
     */
    public void resetPossibleScores() {
        playerScoreCard.resetPossibleScores();
    }

    /**
     * Method to make a score permanent on the player's scorecard.
     * 
     * @see GameWindow.java
     */
    public void recordScore() {
        playerScoreCard.score(); 
    }

    /**
     * Overloaded method to be used in testing a player's scorecard.
     * 
     * @param row the row to set a score on
     * @param score the score to be set on the given row
     * @see PlayerTest.java
     */
    public void recordScore(int row, int score) {
        playerScoreCard.manualSetScore(row, score);
    }

    /**
     * Method to hide the buttons for scoring next to the scorecard.
     * 
     * @see GameWindow.java
     */
    public void hideScoringMenu() {
        playerScoreCard.hideScoringMenu();
    }

    /**
     * Method to show the buttons for scoring next to the scorecard.
     * 
     * @see GameWindow.java
     */
    public void revealScoringMenu() {
        playerScoreCard.revealScoringMenu();
    }

    /**
     * Method to check if the player is currently playing.
     * 
     * @return Boolean true if player is up, false otherwise
     */
    public Boolean checkifPlaying() {
        return playing;
    }

    /**
     * Getter for the player's scorecard.
     * 
     * @return PlayerScoreCard the player's scorecard
     * @see Player.java, GameWindow.java
     */
    public PlayerScoreCard getScoreCard() {
        return playerScoreCard;
    }

}
