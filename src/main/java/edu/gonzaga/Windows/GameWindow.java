package edu.gonzaga.Windows;

import javax.swing.*;
import java.awt.event.*;
import edu.gonzaga.*;
import edu.gonzaga.GameComponents.*;

import java.util.ArrayList;

/**
 * Class to create and update the actual game mechanics
 * while user(s) are playing the game.
 * 
 * @author Anna Cardinal
 * @author Jonathan Smoley
 * @version 2.0 4/24/2022
 */
public class GameWindow extends JPanel {

    GameLabel currentPlayerName = new GameLabel();
    GameLabel footer = new GameLabel();
    JPanel currentPlayerScoreCardView = new JPanel();
    GameButton toEndScreen;
    GameButton toTitleScreen;
    GameButton endTurn;
    Hand gameHand;
    ArrayList<Player> players;
    Player currentPlayer;

    /**
     * Default constructor for the GameWindow class.
     * 
     * @param window the frame object of the program
     * @param titleWindow reference to the intro window
     * @param nameCollectors an arraylist of textfields holding player names
     */
    public GameWindow(JFrame window, TitleWindow titleWindow, ArrayList<JTextField> nameCollectors) {
        this.setLayout(null);
        this.setSize(800, 800);
        gameHand = new Hand();
        toEndScreen = new GameButton("Finish Game");
        toTitleScreen = new GameButton("Return to Title");
        endTurn = new GameButton("End Turn");
        footer.setBackground(ColorPalette.darkRed);
        footer.setOpaque(true);
        initPlayers(nameCollectors);
        players.get(0).setPlaying();
        setRollButtonMechanics();
        setEndTurnButton();
        setToEndScreen(window, titleWindow, players);
        configureView();
    }

    /**
     * Method to create player objects using the names collected.
     * 
     * @param nameCollectors an arraylist of textfields holding player names
     * @see GameWindow constructor
     */
    public void initPlayers(ArrayList<JTextField> nameCollectors) {
        players = new ArrayList<>();
        for (int i = 0; i < nameCollectors.size(); i++) {
            Player newPlayer = new Player(nameCollectors.get(i).getText(), endTurn);
            players.add(newPlayer);
        }
        currentPlayer = players.get(0);
        currentPlayerName.setText(currentPlayer.getName() + "'s Turn");
        currentPlayerName.setBackground(ColorPalette.darkRed);
        currentPlayerName.setOpaque(true);
        currentPlayerName.setHorizontalAlignment(SwingConstants.CENTER);
        currentPlayerName.setTextBold();
    }

    /**
     * Method to initialize the scorecard components
     * 
     * @see configureView method
     */
    public void getPlayerScoreCards() {
        int scoreCardWidth = players.get(0).getView().getWidth();
        int scoreCardHeight = players.get(0).getView().getHeight();
        currentPlayerScoreCardView.setSize(scoreCardWidth, scoreCardHeight);
        currentPlayerScoreCardView.setLayout(null);
        for (int i = 0; i < players.size(); i++) {
            players.get(i).getView().setLocation(0, 0);
            currentPlayerScoreCardView.add(players.get(i).getView());
        }
    }

    /**
     * Method to "loop" through players and update playing status
     */
    public void incrementCurrentPlayer() {
        if (players.size() > 1) {
            for (int i = 0; i < players.size(); i++) {
                if (players.get(i).checkifPlaying()) {
                    if (checkCurrentPlayerLastPlayer()) {
                        players.get(0).setPlaying();
                        currentPlayer = players.get(0);
                    } else {
                        players.get(i + 1).setPlaying();
                        currentPlayer = players.get(i + 1);
                    }
                    players.get(i).setNotPlaying();
                    i = players.size() - 1;
                }
            }
            currentPlayerName.setText(currentPlayer.getName() + "'s Turn");
            currentPlayer.resetPossibleScores();
        }
    }

    /**
     * Method to set the behavior of the roll button
     * belonging to the hand
     * 
     * @see GameWindow constructor
     */
    public void setRollButtonMechanics() {
        gameHand.getRollButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                gameHand.RollNewHand();
                currentPlayer.showPossibleScores(gameHand);
                if (gameHand.isTurnOver()) {
                    currentPlayer.revealScoringMenu();
                }
            }
        });
    }

    /**
     * Method to set the behavior of the end turn button
     * 
     * @see GameWindow constructor
     */
    public void setEndTurnButton() {
        endTurn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                currentPlayer.recordScore();
                currentPlayer.hideScoringMenu();
                if (checkCurrentPlayerLastPlayer() && currentPlayer.checkScoreCardFull()) {
                    toEndScreen.setVisible(true);
                    toTitleScreen.setVisible(false);
                } else {
                    incrementCurrentPlayer();
                    gameHand.reset();
                }
                endTurn.setVisible(false);
            }
        });
    }

    /**
     * Method to set the screen switching behavior once scorecards are full.
     * 
     * @param main the frame object of the program
     * @param titleWindow reference to the intro window
     * @param players an arraylist of player objects
     */
    public void setToEndScreen(JFrame main, TitleWindow titleWindow, ArrayList<Player> players) {
        toEndScreen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                EndGameWindow endGameWindow = new EndGameWindow(players);
                endGameWindow.setSwitchButton(main, titleWindow);
                main.add(endGameWindow);
                endGameWindow.setVisible(true);
                setVisible(false);
                players.get(0).getScoreCard().resetCount();
            }
        });
        toTitleScreen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                TitleWindow titleWindow = new TitleWindow();
                titleWindow.setSwitchButton(main, titleWindow);
                main.add(titleWindow);
                titleWindow.setVisible(true);
                setVisible(false);
                players.get(0).getScoreCard().resetCount();
            }
        });
    }

    /**
     * Method to check for the last player in the loop.
     * 
     * @return boolean true if last, false if not
     * @see setEndTurnButton method, incrementCurrentPlayer method
     */
    public boolean checkCurrentPlayerLastPlayer() {
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).checkifPlaying()) {
                if (i == players.size() - 1) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Method to configure sizes of the components in this panel
     * 
     * @see configureView method
     */
    public void setComponentSizes() {
        currentPlayerName.setSize(800, 30);
        toEndScreen.setSize(150, 30);
        toTitleScreen.setSize(150, 30);
        endTurn.setSize(120, 30);
        footer.setSize(800, 100);
    }

    /**
     * Method to configure where in the panel each component will go
     * 
     * @see configureView method
     */
    public void setComponentLocations() {
        currentPlayerName.setLocation(0, 0);
        currentPlayerScoreCardView.setLocation(30, currentPlayerName.getHeight() + 40);
        gameHand.getAppearance().setLocation(currentPlayerScoreCardView.getWidth() + 20, currentPlayerName.getHeight() + 40);
        //toEndScreen.setLocation(10, currentPlayerName.getHeight() + currentPlayerScoreCardView.getHeight() + 50);
        //toTitleScreen.setLocation(10 + toEndScreen.getWidth() + 10, currentPlayerName.getHeight() + currentPlayerScoreCardView.getHeight() + 50);
        toEndScreen.setLocation(400 - 75, 705);
        toTitleScreen.setLocation(400 - 75, 705);
        //endTurn.setLocation(170, currentPlayerName.getHeight() + currentPlayerScoreCardView.getHeight() + 50);
        endTurn.setLocation(currentPlayerScoreCardView.getWidth() + 20 + 20, currentPlayerName.getHeight() + gameHand.getAppearance().getHeight() - endTurn.getHeight() + 40);
        footer.setLocation(0, 680);
    }

    /**
     * Method to finally add all components to the current panel
     * 
     * @see configureView method
     */
    public void addComponents() {
        this.add(endTurn);
        this.add(currentPlayerName);
        this.add(currentPlayerScoreCardView);
        this.add(gameHand.getAppearance());
        this.add(toEndScreen);
        this.add(toTitleScreen);
        this.add(footer);
    }

    /**
     * Method to do most of setting up the game window panel
     * 
     * @see GameWindow constructor
     */
    public void configureView() {
        toEndScreen.setVisible(false);
        endTurn.setVisible(false);
        gameHand.hideDiceButtons();
        getPlayerScoreCards();
        setComponentSizes();
        setComponentLocations();
        addComponents();
    }
    
}
