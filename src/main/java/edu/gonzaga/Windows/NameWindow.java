package edu.gonzaga.Windows;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import edu.gonzaga.GameComponents.*;

/**
 * Class defining the window to add names for the number of 
 * players requested by the user.
 * 
 * @author Jonathan Smoley
 * @version 2.0 4/24/2022
 */
public class NameWindow extends JPanel {
    JFrame window;
    JPanel contentNorth;
    JPanel contentCenter;
    JPanel contentSouth;
    GameLabel instructions;
    GameLabel constraintNotice;
    ArrayList<GameLabel> playerNumLabels;
    ArrayList<JTextField> playerNameCollectors;
    GameButton toGameWindow;
    int numPlayers;

    /**
     * Default constructor for the NameWindow class.
     * 
     * @param main the frame object of the program
     * @param numPlayers number of players requested by the user
     * @see TitleWindow.java
     */
    public NameWindow(JFrame main, Integer numPlayers) {
        window = main;
        this.numPlayers = numPlayers;

        initPlayerLists();

        setNorthContent();
        add(contentNorth, BorderLayout.NORTH);

        setCenterContent(numPlayers);
        add(contentCenter, BorderLayout.CENTER);

        setSouthContent();
        add(contentSouth, BorderLayout.SOUTH);
    }

    /**
     * Creates a list of components to gather player names.
     * 
     * @see NameWindow constructor
     */
    private void initPlayerLists() {
        playerNumLabels = new ArrayList<>();
        playerNameCollectors = new ArrayList<>();

        for (int i = 0; i < numPlayers; i++) {
            GameLabel tempGameLabel = new GameLabel("Player " + (i + 1) + ": ");
            JTextField tempTextField = new JTextField(10);
            playerNumLabels.add(i, tempGameLabel);
            playerNameCollectors.add(i, tempTextField);
        }
    }

    /**
     * Creates and adds components to the north panel.
     * 
     * @see NameWindow constructor
     */
    private void setNorthContent() {
        contentNorth = new JPanel();
        contentNorth.setLayout(new BorderLayout());
        contentNorth.setPreferredSize(new Dimension(800, 100));
        contentNorth.setBackground(ColorPalette.darkRed);

        instructions = new GameLabel("Enter Player Names");
        instructions.setTextSize(50);
        instructions.setHorizontalAlignment(SwingConstants.CENTER);
        
        contentNorth.add(instructions);
    }

    /**
     * Creates and adds components to the panel going
     * in the center of the window.
     * 
     * @param playerCount
     * @see NameWindow constructor
     */
    private void setCenterContent(Integer playerCount) {
        contentCenter = new JPanel();
        contentCenter.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        contentCenter.setPreferredSize(new Dimension(600, 500));

        for (int i = 0; i < numPlayers; i++) {
            playerNumLabels.get(i).setTextSize(30);

            gbc.gridx = 0;
            gbc.gridy = i;
            gbc.gridwidth = 1;
            gbc.gridheight = 1;
            gbc.insets = new Insets(5, 0, 5, 5);

            contentCenter.add(playerNumLabels.get(i), gbc);

            playerNameCollectors.get(i).setFont(new Font("Candara", Font.PLAIN, 30));

            gbc.gridx = 1;
            gbc.gridy = i;
            gbc.gridwidth = 1;
            gbc.gridheight = 1;
            gbc.insets = new Insets(5, 5, 5, 0);

            contentCenter.add(playerNameCollectors.get(i), gbc);
        }
    }

    /**
     * Sets ups the content at the bottom of the window.
     * 
     * @see NameWindow constructor
     */
    private void setSouthContent() {
        contentSouth = new JPanel();
        BoxLayout layout = new BoxLayout(contentSouth , BoxLayout.Y_AXIS);
        contentSouth.setPreferredSize(new Dimension(450, 150));

        toGameWindow = new GameButton("Start Game");
        toGameWindow.setTextSize(30);
        toGameWindow.setPreferredSize(new Dimension(200, 50));

        contentSouth.add(toGameWindow, layout);

        constraintNotice = new GameLabel("*must enter a name for each player*");
        constraintNotice.setTextSize(20);
        constraintNotice.setVisible(false);

        contentSouth.add(constraintNotice, layout);
    }

    /**
     * Sets the behavior of the button pressed to start the game.
     * 
     * @param main the frame object of the program
     * @param titleWindow intro panel reference passed to game window
     * @see TitleWindow.java
     */
    public void setSwitchButton(JFrame main, TitleWindow titleWindow) {
        toGameWindow.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                Boolean allNamesEntered = true;
                for (int i = 0; i < playerNameCollectors.size(); i++) {
                    if (playerNameCollectors.get(i).getText().equals("")) {
                        allNamesEntered = false;
                    }
                }
                if (allNamesEntered) {
                    GameWindow gameWindow = new GameWindow(main, titleWindow, playerNameCollectors);
                    main.add(gameWindow);
                    gameWindow.setVisible(true);
                    setVisible(false);
                } else {
                    constraintNotice.setVisible(true);
                }
                
            }
        });
    }

    // to be used for unit testing purposes
    public ArrayList<GameLabel> getPlayerNumLabels() { return playerNumLabels; }
    public ArrayList<JTextField> getPlayerNameCollectors() { return playerNameCollectors; }
    public GameLabel getInstructions() { return instructions; }
    public GameLabel getConstraintNotice() { return constraintNotice; }
    public GameButton getToGameWindow() { return toGameWindow; }
    public JPanel getContentNorth() { return contentNorth; }
    public JPanel getContentCenter() { return contentCenter; }
    public JPanel getContentSouth() { return contentSouth; }
}
