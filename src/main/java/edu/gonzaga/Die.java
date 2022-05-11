/* (C)2021 */
package edu.gonzaga;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/** Class to store the state of a single die.
 *
 * @author Hailey Boe
 * @version final 5/5/2022  */
public class Die implements Comparable<Die> {

    private Integer sideUp; // Current die 'value' in range 1..numSides
    private Integer numSides;// Sides on the die (should be 1...INF integer)
    private Boolean locked;
    private static final Integer DEFAULT_NUM_SIDES = 6;
    private static final Integer DEFAULT_SIDE_UP = 1;
    private DieView dieView;

    /**
     * die constructor #1, default
     *
     * @return nothing
     */
    public Die() {
        this.numSides = DEFAULT_NUM_SIDES;
        this.sideUp = DEFAULT_SIDE_UP;
        this.locked = false;
        dieView = new DieView(sideUp);
        dieView.getRadioButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateLockedState();
            }
        });
    }

    /**
     * die constructor #2, number of sides is
     * specified
     *
     * @param numSides
     * @return nothing
     */
    public Die(Integer numSides) {
        this.numSides = numSides;
        this.sideUp = DEFAULT_SIDE_UP;
        this.locked = false;
        dieView = new DieView(sideUp);
        dieView.getRadioButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateLockedState();
            }
        });
    }

    /**
     * die constructor #3, number of sides and
     * starting side is specified
     *
     * @param numSides
     * @param startingSide
     * @return nothing
     */
    public Die(Integer numSides, Integer startingSide) {
        this.numSides = numSides;
        this.sideUp = startingSide;
        this.locked = true;
        dieView = new DieView(sideUp);
        dieView.getRadioButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateLockedState();
            }
        });
    }

    /**
     * rolls the die once generating a new
     * random value
     *
     * @return nothing
     */
    public void roll() {
        if (!locked) {
            Random rand = new Random();
            this.sideUp = rand.nextInt(this.numSides) + 1;
            dieView.updateDieAppearance(this.sideUp);
        }
    }

    /**
     * checks whether the button is selected or
     * not, if it is locked = true, if not
     * locked = false
     *
     * @return locked status
     */
    public boolean updateLockedState() {
        if (dieView.button.isSelected()) {
            locked = true;
        } else {
            locked = false;
        }
        return locked;
    }

    /**
     * changes the lacked state of the button
     *
     * @return nothing
     */
    public void changeLockedState() {
        if (locked) {
            locked = false;
        } else {
            locked = true;
        }
    }

    /**
     * sets the dice face value to the number
     * specified in the parameters
     *
     * @param newSideUp
     * @return nothing
     */
    public void setValue(int newSideUp) {
        this.sideUp = newSideUp;
        dieView.updateDieAppearance(newSideUp);
    }

    /**
     * deselects the button manually
     *
     * @return nothing
     */
    public void deselectButton() {
        dieView.button.setSelected(false);
        updateLockedState();
    }

    /**
     * sets the button's visibility on the
     * JPanel to false
     *
     * @return nothing
     */
    public void setButtonInvisibility() { dieView.button.setVisible(false); }

    /**
     * sets the button's visibility on the
     * JPanel to true
     *
     * @return nothing
     */
    public void setButtonVisibility() { dieView.button.setVisible(true); }

    /**
     * returns dieView JPanel
     *
     * @return dieView (JPanel)
     */
    public JPanel getView() { return dieView; }

    /**
     * returns the current side up on the dice
     *
     * @return sideUp
     */
    public int getSideUp() {return sideUp; }

    /**
     * returns the number of sides on the dice
     * in total
     *
     * @return numSides
     */
    public int getNumSides() { return numSides; }

    /**
    * Provides the ability to convert the Die
     * object into a string. representation, both with
    * .toString(), but also in System.out.println()
    *
    * @return String of whatever you want this die to say for itself
    */
    @Override
    public String toString() {
        String ret = "";
        ret += this.sideUp.toString();
        return ret;
    }

    /**
    * Makes two dice comparable using <, ==, >, etc. based on sideUp values.
    *
    * @param otherDie The die we're comparing to this one (two objects)
    * @return int -1, 0, 1 for less than, equal, greater than
    */
    @Override
    public int compareTo(Die otherDie) {
        return this.sideUp.compareTo(otherDie.sideUp);
    }
}
