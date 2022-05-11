/* (C)2022 */
package edu.gonzaga.GameComponents;

import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;
import javax.swing.border.BevelBorder;

/*
*  This Program lets a user play single player yahtzee using a Graphical User Interface. Game settings are customizable, 
*  allowing the user to pick how many dice are in the game, how many sides the dice have, and how many rolls are allowed per turn
*  CPSC 224, Spring 2022
*  Homework 4
*  Sources: Yahtzee written by Aaron Crandall
*           https://whaa.dev/how-to-overwrite-a-file-in-java - how to use FileWriter
* 
*  @author Anna Cardinal
*  @version v1.4 4/10/2022
*/

/** Class customizing java swing component JButton */
public class GameButton extends JButton {

    private Color mainColor = ColorPalette.red;
    private Color clickedColor = ColorPalette.darkRed;

    /**
     * default game button with text parameter
     *
     * @Param text
     */
    public GameButton(String text) {
        super(text);
        this.setColorSettings();
        this.setFont(new Font("Candara", Font.PLAIN, 20));
        this.setFocusPainted(false);
        this.setContentAreaFilled(false);
        this.setOpaque(true);
        this.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
    }

    /**
     * default game button with text parameter and
     * gameType (did not change the game type to
     * lizard spock yahtzee)
     *
     * @param text
     * @param gameType
     */
    public GameButton(String text, int gameType) { 
        super(text);
        this.setColorSettings();
        this.setFont(new Font("Candara", Font.PLAIN, 20));
        this.setFocusPainted(false);
        this.setContentAreaFilled(false);
        this.setOpaque(true);
        this.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
    }

    /**
    * sets color scheme of Game button based on the game type, or the number of sides on the game dice
    */
    public void setColorSettings() {
        this.setBackground(mainColor);
        this.setForeground(ColorPalette.textColor);
        addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent event) {
                if (getModel().isPressed()) {
                    setBackground(clickedColor);
                    setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
                } else if (getModel().isRollover()) {
                    setBackground(mainColor);
                    setBorder(BorderFactory.createLineBorder(clickedColor, 2));
                } else {
                    setBackground(mainColor);
                    setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
                }
            }
        });
    }

    /**
     * sets the main color of the game (did not use)
     */
    public void setColors(Color mainColor, Color clickedColor) {
        this.mainColor = mainColor;
        this.clickedColor = clickedColor;
        setColorSettings();
    }

    /**
     * changes the text size of text displayed on JPanel
     *
     * @param textSize int that sets teh size of text
     */
    public void setTextSize(int textSize) {
        this.setFont(new Font("Candara", Font.PLAIN, textSize));
    }

    /**
    * Returns the color of the game button when clicked (did not use)
    *
    * @return Color value representing the color of the button when clicked
    */
    public Color getClickedColor() {
        return this.clickedColor;
    }
    
}
