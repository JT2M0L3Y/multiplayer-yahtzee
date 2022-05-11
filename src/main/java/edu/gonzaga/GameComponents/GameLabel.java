/* (C)2022 */
package edu.gonzaga.GameComponents;

import javax.swing.*;
import java.awt.*;

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

/** Class Customizing the java swing component JLabel */
public class GameLabel extends JLabel {

    String fontName = "Candara";
    Font defaultTextFont = new Font("Candara", Font.PLAIN, 15);

    /**
     * default game label, no parameters
     */
    public GameLabel() {
        super();
        this.setFont(defaultTextFont);
        this.setForeground(ColorPalette.textColor);
    }

    /**
     * default game label with text parameter
     *
     * @param text
     */
    public GameLabel(String text) {
        super(text);
        this.setFont(defaultTextFont);
        this.setForeground(ColorPalette.textColor);
    }

    /**
     * default game label with text and boolean 'bold' parameter
     *
     * @param text
     * @param bold
     */
    public GameLabel(String text, boolean bold) {
        super(text);
        if (bold) {
            this.setFont(new Font(fontName, Font.BOLD, 15));
        } else {
            this.setFont(defaultTextFont);
        }
        this.setForeground(ColorPalette.textColor);
    }

    /**
     * default game label with text parameter and
     * alignment (horizontal) parameter
     *
     * @param text
     * @param horizontalAlignment
     */
    public GameLabel(String text, int horizontalAlignment) {
        super(text, horizontalAlignment);
        this.setFont(defaultTextFont);
        this.setForeground(ColorPalette.textColor);
    }

    /**
    * sets the size of the text in the Game Label
    *
    * @param textSize int value representing the new text size
    */
    public void setTextSize(int textSize) {
        this.setFont(new Font(fontName, Font.PLAIN, textSize));
    }

    /**
     * sets the text settings 
     *
     * @param bold boolean whether or not text is bolded
     * @param textSize integer that sets text size
     */
    public void setTextSettings(Boolean bold, int textSize) {
        if (bold) {
            this.setFont(new Font(fontName, Font.BOLD, textSize));
        } else {
            this.setFont(new Font(fontName, Font.PLAIN, textSize));
        }
    }

    /**
     * sets the text to bold
     */
    public void setTextBold() {
        this.setFont(new Font(fontName, Font.BOLD, 15));
    }
}
