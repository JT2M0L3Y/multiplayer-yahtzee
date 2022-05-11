package edu.gonzaga;
import javax.swing.*;
import java.awt.*;

/** Class to change how a single die is viewed.
 *
 * @author Hailey Boe
 * @version final 5/5/2022  
 */
public class DieView extends JPanel {

    private static final int IMAGE_XCOORDINATE = 0;
    private static final int IMAGE_YCOORDINATE = 0;
    private static final int IMAGE_WIDTH = 50;
    private static final int IMAGE_HEIGHT = 50;
    private static final int BUTTON_XCOORDINATE = 13;
    private static final int BUTTON_YCOORDINATE = 50;
    private static final int BUTTON_WIDTH = 25;
    private static final int BUTTON_HEIGHT = 25;
    private static final int PANEL_WIDTH = IMAGE_WIDTH;
    private static final int PANEL_HEIGHT = IMAGE_HEIGHT + BUTTON_HEIGHT;

    JLabel icon;
    JRadioButton button;
    ImageIcon d6Side1 = new ImageIcon(System.getProperty("user.dir") + "/src/media/D6S1.png");
    ImageIcon d6Side2 = new ImageIcon(System.getProperty("user.dir") + "/src/media/D6S2.png");
    ImageIcon d6Side3 = new ImageIcon(System.getProperty("user.dir") + "/src/media/D6S3.png");
    ImageIcon d6Side4 = new ImageIcon(System.getProperty("user.dir") + "/src/media/D6S4.png");
    ImageIcon d6Side5 = new ImageIcon(System.getProperty("user.dir") + "/src/media/D6S5.png");
    ImageIcon d6Side6 = new ImageIcon(System.getProperty("user.dir") + "/src/media/D6S6.png");
    ImageIcon[] icons = new ImageIcon[6];

    /**
     * constructor for DieView class
     *
     * @param sideUp
     * @return nothing
     */
    public DieView(int sideUp){
        this.setLayout(null);
        setIcons(50, 50);
        icon = new JLabel(icons[sideUp - 1]);
        button = new JRadioButton();
        configureView();
    }

    /**
     * updates the die face to be the number
     * passed into parameters
     *
     * @param sideUp
     * @return nothing
     */
    public void updateDieAppearance(int sideUp) {
        icon.setIcon(icons[sideUp - 1]);
    }

    /**
     * pushes an icon and button onto the JPanel
     *
     * @return nothing
     */
    public void configureView(){
        icon.setBounds(IMAGE_XCOORDINATE, IMAGE_YCOORDINATE, IMAGE_WIDTH, IMAGE_HEIGHT);
        button.setBounds(BUTTON_XCOORDINATE, BUTTON_YCOORDINATE, BUTTON_WIDTH, BUTTON_HEIGHT);
        icon.setOpaque(false);
        this.setSize(PANEL_WIDTH, PANEL_HEIGHT);
        this.setOpaque(false);
        this.add(icon);
        this.add(button);
    }

    /**
     * returns a radio button
     *
     * @return radioButton
     */
    public JRadioButton getRadioButton() {
        return button;
    }

    /**
     * can change the sizes of the dice images
     *
     * @param height
     * @param width
     * @return nothing
     */
    public void setIcons(int width, int height){

        Image image = d6Side1.getImage(); // transform it 
        Image newimg = image.getScaledInstance(width, height,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        d6Side1 = new ImageIcon(newimg);  // transform it back
        icons[0] = d6Side1;

        image = d6Side2.getImage(); // transform it 
        newimg = image.getScaledInstance(width, height,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        d6Side2 = new ImageIcon(newimg);  // transform it back
        icons[1] = d6Side2;

        image = d6Side3.getImage(); // transform it 
        newimg = image.getScaledInstance(width, height,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        d6Side3 = new ImageIcon(newimg);  // transform it back
        icons[2] = d6Side3;
        
        image = d6Side4.getImage(); // transform it 
        newimg = image.getScaledInstance(width, height,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        d6Side4 = new ImageIcon(newimg);  // transform it back
        icons[3] = d6Side4;

        image = d6Side5.getImage(); // transform it 
        newimg = image.getScaledInstance(width, height,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        d6Side5 = new ImageIcon(newimg);  // transform it back
        icons[4] = d6Side5;

        image = d6Side6.getImage(); // transform it 
        newimg = image.getScaledInstance(width, height,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        d6Side6 = new ImageIcon(newimg);  // transform it back
        icons[5] = d6Side6;
    }

}