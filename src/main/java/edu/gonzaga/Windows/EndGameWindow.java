package edu.gonzaga.Windows;

import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import edu.gonzaga.*;
import edu.gonzaga.ScoreCard.*;
import java.awt.event.*;
import edu.gonzaga.GameComponents.*;

/**
 * Class to make a final window with results of the game.
 * 
 * @author Jonathan Smoley
 * @version 2.0 4/24/2022
 */
public class EndGameWindow extends JPanel {

    LeaderBoard leaderBoard;
    JLabel winner;
    GameButton toTitleScreen;
    ArrayList<Player> players;

    /**
     * Default constructor for the EndGameWindow class.
     * 
     * @param players arraylist of players after the game
     * @see GameWindow.java
     */
    public EndGameWindow(ArrayList<Player> players) {
        this.players = players;
        this.setLayout(null);
        this.setSize(800, 800);

        leaderBoard = new LeaderBoard(players);
        leaderBoard.getLeaderBoardView().setLocation(400 - (leaderBoard.getLeaderBoardView().getWidth()/2) - 5, 60);
        add(leaderBoard.getLeaderBoardView(), BorderLayout.CENTER);

        toTitleScreen = new GameButton("Return to Title");
        toTitleScreen.setSize(150, 30);
        toTitleScreen.setLocation(400 - 75  , 60 + leaderBoard.getLeaderBoardView().getHeight() + 10);
        add(toTitleScreen);
    }

    /**
     * Method to set the behavior of a button to return to the title screen.
     * 
     * @param titleWindow reference to the title window
     */
    public void setSwitchButton(JFrame main, JPanel titleWindow) {
        toTitleScreen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                TitleWindow titleWindow = new TitleWindow();
                titleWindow.setSwitchButton(main, titleWindow);
                main.add(titleWindow);
                titleWindow.setVisible(true);
                setVisible(false);
            }
        });
    }

    // getters for unit testing purposes
    public LeaderBoard getLeaderBoard() { return leaderBoard; }
    public GameButton getToTitleScreen() { return toTitleScreen; }
    public ArrayList<Player> getPlayers() { return players; }
}
