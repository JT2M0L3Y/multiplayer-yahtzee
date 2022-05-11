/* (C)2022 */
package edu.gonzaga.GameComponents;

import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;

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

/** Class customizing the java swing element JRadioButton */
public class GameRadioButton extends JRadioButton {

    private String directory = System.getProperty("user.dir") + "\\src\\media\\";
    private ImageIcon defaultIconImage = new ImageIcon(directory + "DefaultRadioButton.png");
    private ImageIcon rolloverIconImage = new ImageIcon(directory + "RolloverRadioButton.png");
    private ImageIcon pressedIconImage = new ImageIcon(directory + "SelectedRadioButton.png");
    private ImageIcon selectedIconImage = new ImageIcon(directory + "SelectedRadioButton.png");
    private ImageIcon crossIconImage = new ImageIcon(directory + "CrossRadioButton.png");
    private ImageIcon emptyIconImage = new ImageIcon(directory + "Blank.png");
    private Icon defaultIcon;
    private Icon rolloverIcon;
    private Icon pressedIcon;
    private Icon selectedIcon;

    /**
     * default game radio button
     */
    public GameRadioButton() {
        resizeImages(17, 17);
        assignIcons();
        this.setIcon(defaultIcon);
        this.setRolloverIcon(rolloverIcon);
        this.setPressedIcon(pressedIcon);
        this.setSelectedIcon(selectedIcon);
    }

    /**
     * default game radio button with type parameter
     *
     * @param type
     */
    public GameRadioButton(int type) {
        resizeImages(17, 17);
        assignAltIcons();
        this.setIcon(defaultIcon);
        this.setRolloverIcon(rolloverIcon);
        this.setPressedIcon(pressedIcon);
        this.setSelectedIcon(selectedIcon);
        setHorizontalAlignment(SwingConstants.CENTER);
        setVerticalAlignment(SwingConstants.CENTER);
        setBackground(ColorPalette.white);
        setBorderPainted(true);
        setBorder(BorderFactory.createLineBorder(ColorPalette.textColor, 2));
        addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent event) {
                if (getModel().isPressed()) {
                    setBorder(BorderFactory.createLineBorder(ColorPalette.textColor, 2));
                } else if (getModel().isRollover()) {
                    setBorder(BorderFactory.createLineBorder(ColorPalette.textColor, 1));
                } else {
                    setBorder(BorderFactory.createLineBorder(ColorPalette.textColor, 2));
                }
            }
        });
    }

    /**
     * resizes the images with width and height parameters
     *
     * @param width int that sets width of all images
     * @param height int that sets height of all images
     */
    public void resizeImages(int width, int height) {
        Image image = defaultIconImage.getImage(); // transform it
        Image newimg = image.getScaledInstance(width, height,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        defaultIconImage = new ImageIcon(newimg);  // transform it back

        image = rolloverIconImage.getImage(); // transform it 
        newimg = image.getScaledInstance(width, height,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        rolloverIconImage = new ImageIcon(newimg);  

        image = pressedIconImage.getImage(); // transform it 
        newimg = image.getScaledInstance(width, height,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        pressedIconImage = new ImageIcon(newimg);

        image = selectedIconImage.getImage(); // transform it 
        newimg = image.getScaledInstance(width, height,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        selectedIconImage = new ImageIcon(newimg);

        image = crossIconImage.getImage(); // transform it 
        newimg = image.getScaledInstance(15, 15,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        crossIconImage = new ImageIcon(newimg);

        image = emptyIconImage.getImage(); // transform it 
        newimg = image.getScaledInstance(width, height,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        emptyIconImage = new ImageIcon(newimg);
    }

    /**
     * assigns icons to image
     */
    public void assignIcons() {
        defaultIcon = defaultIconImage;
        rolloverIcon = rolloverIconImage;
        pressedIcon = pressedIconImage;
        selectedIcon = selectedIconImage;
    }

    /**
     * assigns icon to empty image
     */
    public void assignAltIcons() {
        defaultIcon = emptyIconImage;
        rolloverIcon = emptyIconImage;
        pressedIcon = emptyIconImage;
        selectedIcon = crossIconImage;
    }
    
}
