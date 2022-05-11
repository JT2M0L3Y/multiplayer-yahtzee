package edu.gonzaga;

import edu.gonzaga.Windows.*;

import javax.swing.*;
import java.awt.*;

/** Main program class for launching Yahtzee program. 
 * 
 * @author Jonathan Smoley
 * @version 2.0 4/24/2022
*/
public class Yahtzee {
    
    /**
     * Start point for the Yahtzee program.
     * 
     * @param args command line arguments
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame("Yahtzee");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);

        TitleWindow titleWindow = new TitleWindow();
        frame.add(titleWindow, BorderLayout.CENTER);
        titleWindow.setSwitchButton(frame, titleWindow);
        
        frame.setVisible(true);
    }

}
