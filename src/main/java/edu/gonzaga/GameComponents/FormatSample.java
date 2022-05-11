package edu.gonzaga.GameComponents;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/** 
 * Class customizing JPanel formatting 
 */
public class FormatSample extends JPanel {

    ArrayList<GameLabel> colorSwatches = new ArrayList<>();
    JPanel colorPalette = new JPanel();
    int spaceBetweenSwatches = 5;
    int swatchWidth = 70;
    int colorPaletteWidth = (6 * swatchWidth) + (7 * spaceBetweenSwatches);
    int colorPaletteHeight;

    GameButton button = new GameButton("Click Me");
    GameLabel label = new GameLabel("I'm a Label");
    GameRadioButton radioButton = new GameRadioButton();
    GameRadioButton radioButton2 = new GameRadioButton(2);

    /**
     * formatting sample (did not use)
     */
    public FormatSample() {
        this.setLayout(null);
        this.setBackground(ColorPalette.backgroundColor);
        this.setBorder(BorderFactory.createLineBorder(ColorPalette.textColor));
        configureColorPalette();
        colorPalette.setLocation(5, 5);
        button.setSize(150, 30);
        button.setLocation(colorPaletteWidth + 10, 10);
        label.setSize(150, 30);
        label.setLocation(colorPaletteWidth + 10, button.getHeight() + 20);
        radioButton.setSize(20, 20);
        radioButton.setLocation(colorPaletteWidth + 10, button.getHeight() + label.getHeight() + 30);
        radioButton2.setSize(20, 20);
        radioButton2.setLocation(colorPaletteWidth + 10, button.getHeight() + label.getHeight() + radioButton.getHeight() + 40);
        this.setSize(colorPaletteWidth + 10 + button.getWidth() + 10, colorPaletteHeight + 10);
        this.add(colorPalette);
        this.add(button);
        this.add(label);
        this.add(radioButton);
        this.add(radioButton2);
    }

    /**
     * Color swatches for theme of game
     */
    public void makeSwatches() {
        makeSwatch(ColorPalette.lightRed, "<html>light<br>red</html>");
        makeSwatch(ColorPalette.red, "red");
        makeSwatch(ColorPalette.darkRed, "<html>dark<br>red</html>");
        makeSwatch(ColorPalette.lightGrey, "<html>light<br>grey</html>");
        makeSwatch(ColorPalette.grey, "grey");
        makeSwatch(ColorPalette.darkGrey, "<html>dark<br>grey</html>");
        makeSwatch(ColorPalette.lightGreen, "<html>light<br>green</html>");
        makeSwatch(ColorPalette.green, "green");
        makeSwatch(ColorPalette.darkGreen, "<html>dark<br>green</html>");
        makeSwatch(ColorPalette.lightTeal, "<html>light<br>teal</html>");
        makeSwatch(ColorPalette.teal, "teal");
        makeSwatch(ColorPalette.darkTeal, "<html>dark<br>teal</html>");
        makeSwatch(ColorPalette.lightPurple, "<html>light<br>purple</html>");
        makeSwatch(ColorPalette.purple, "purple");
        makeSwatch(ColorPalette.darkPurple, "<html>dark<br>purple</html>");
        makeSwatch(ColorPalette.lightBrown, "<html>light<br>brown</html>");
        makeSwatch(ColorPalette.brown, "brown");
        makeSwatch(ColorPalette.darkBrown, "<html>dark<br>brown</html>");
        makeSwatch(ColorPalette.lightBlue, "<html>light<br>blue</html>");
        makeSwatch(ColorPalette.blue, "blue");
        makeSwatch(ColorPalette.darkBlue, "<html>dark<br>blue</html>");
        makeSwatch(ColorPalette.lightOrange, "<html>light<br>orange</html>");
        makeSwatch(ColorPalette.orange, "orange");
        makeSwatch(ColorPalette.darkOrange, "<html>dark<br>orange</html>");
    }

    /**
     * makes the swatch for method above
     *
     * @see //makeSwatches()
     * @param color Color value to set background of swatch
     * @param text String value to label color swatch
     */
    public void makeSwatch(Color color, String text) {
        GameLabel tempSwatch;
        tempSwatch = new GameLabel(text, SwingConstants.CENTER);
        tempSwatch.setSize(swatchWidth, swatchWidth);
        tempSwatch.setOpaque(true);
        tempSwatch.setBackground(color);
        colorSwatches.add(tempSwatch);
    }

    /**
     * sets the location of the swatch
     */
    public void setSwatchLocations() {
        int row = 0;
        int column = 0;
        for (int i = 1; i <= colorSwatches.size(); i++) {
            colorSwatches.get(i - 1).setLocation((spaceBetweenSwatches * (column + 1)) + swatchWidth*column, (spaceBetweenSwatches * (row+1)) + swatchWidth*row);
            column++;
            if (i % 6 == 0) {
                row++;
                column = 0;
            }
        }
    }

    /**
     * adds the swatches to the overall color palette JPanel
     */
    public void addSwatchesToPalette() {
        for (int i = 0; i < colorSwatches.size(); i++) {
            colorPalette.add(colorSwatches.get(i));
        }
    }

    /**
     * Configures the color palette to display on JPanel
     */
    public void configureColorPalette() {
        makeSwatches();
        setSwatchLocations();
        int numSwatchesDown = colorSwatches.size() / 6;
        if (colorSwatches.size() % 6 != 0) {
            numSwatchesDown += 1;
        }
        colorPaletteHeight = (numSwatchesDown * swatchWidth) + ((numSwatchesDown + 1) * spaceBetweenSwatches);
        colorPalette.setSize(colorPaletteWidth, colorPaletteHeight);
        colorPalette.setLayout(null);
        colorPalette.setBackground(ColorPalette.white);
        addSwatchesToPalette();
    }
    
}
