package edu.gonzaga;

import org.junit.jupiter.api.Test;
import javax.swing.*;
import java.awt.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DieViewTest {

    @Test
    void testImageCoordinates() {
        int x = 0, y = 0, width = 0, height = 0;
        DieView dieView = new DieView(1);
        dieView.icon.setBounds(5, 5, 100, 100);
        x = dieView.icon.getX();
        y = dieView.icon.getY();
        width = dieView.icon.getWidth();
        height = dieView.icon.getHeight();
        dieView.configureView();
        assertTrue(x == 5 && y == 5 && width == 100 && height == 100);
    }

    @Test
    void testButtonCoordinates() {
        int x = 0, y = 0, width = 0, height = 0;
        DieView dieView = new DieView(1);
        dieView.button.setBounds(5, 5, 100, 100);
        x = dieView.button.getX();
        y = dieView.button.getY();
        width = dieView.button.getWidth();
        height = dieView.button.getHeight();
        dieView.configureView();
        assertTrue(x == 5 && y == 5 && width == 100 && height == 100);
    }

    @Test
    void testIcon() {
        DieView dieView = new DieView(1);
        ImageIcon testImage;
        testImage = (ImageIcon) dieView.icon.getIcon();
        assertTrue(testImage == dieView.icons[0]);
    }

    @Test
    void testFileImportSide1() {
        boolean fileImport;
        DieView dieView = new DieView(3);
        if((dieView.d6Side1.getImageLoadStatus() != MediaTracker.COMPLETE) || (dieView.icon == null)) {
            fileImport = false;
        }
        else {
            fileImport = true;
        }
        assertTrue(fileImport == true);
    }

    @Test
    void testFileImportSide2() {
        boolean fileImport;
        DieView dieView = new DieView(3);
        if((dieView.d6Side2.getImageLoadStatus() != MediaTracker.COMPLETE) || (dieView.icon == null)) {
            fileImport = false;
        }
        else {
            fileImport = true;
        }
        assertTrue(fileImport == true);
    }

    @Test
    void testFileImportSide3() {
        boolean fileImport;
        DieView dieView = new DieView(3);
        if((dieView.d6Side3.getImageLoadStatus() != MediaTracker.COMPLETE) || (dieView.icon == null)) {
            fileImport = false;
        }
        else {
            fileImport = true;
        }
        assertTrue(fileImport == true);
    }

    @Test
    void testFileImportSide4() {
        boolean fileImport;
        DieView dieView = new DieView(3);
        if((dieView.d6Side4.getImageLoadStatus() != MediaTracker.COMPLETE) || (dieView.icon == null)) {
            fileImport = false;
        }
        else {
            fileImport = true;
        }
        assertTrue(fileImport == true);
    }

    @Test
    void testFileImportSide5() {
        boolean fileImport;
        DieView dieView = new DieView(3);
        if((dieView.d6Side5.getImageLoadStatus() != MediaTracker.COMPLETE) || (dieView.icon == null)) {
            fileImport = false;
        }
        else {
            fileImport = true;
        }
        assertTrue(fileImport == true);
    }

    @Test
    void testFileImportSide6() {
        boolean fileImport;
        DieView dieView = new DieView(3);
        if((dieView.d6Side6.getImageLoadStatus() != MediaTracker.COMPLETE) || (dieView.icon == null)) {
            fileImport = false;
        }
        else {
            fileImport = true;
        }
        assertTrue(fileImport == true);
    }

    @Test
    void updateDieAppearanceTest() {
        boolean isIconCorrect;
        DieView dieView = new DieView(1);
        dieView.updateDieAppearance(6);
        if (dieView.icon.getIcon() == dieView.d6Side6)  {
            isIconCorrect = true;
        }
        else {
            isIconCorrect = false;
        }
        assertTrue(isIconCorrect == true);
    }

    @Test
    void getRadioButtonTest() {
        boolean radioButtonReceived;
        DieView dieView = new DieView(1);
        if (dieView.getRadioButton() != null) {
            radioButtonReceived = true;
        }
        else {
            radioButtonReceived = false;
        }
        assertTrue(radioButtonReceived == true);
    }

}
