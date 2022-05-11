package edu.gonzaga;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import javax.swing.*;
import edu.gonzaga.Windows.*;

public class NameTest {
    @Test
    void testPanelInit() {
        JFrame frame = new JFrame();
        NameWindow nameWindow = new NameWindow(frame, 1);
        Assertions.assertNotNull(nameWindow);
    }

    @Test
    void testLabelListInit() {
        JFrame frame = new JFrame();
        NameWindow nameWindow = new NameWindow(frame, 4);
        Assertions.assertEquals(4, nameWindow.getPlayerNumLabels().size());
    }

    @Test
    void testCollectorListInit() {
        JFrame frame = new JFrame();
        NameWindow nameWindow = new NameWindow(frame, 4);
        Assertions.assertEquals(4, nameWindow.getPlayerNameCollectors().size());
    }

    @Test
    void testInstructionLabelInit() {
        NameWindow nameWindow = new NameWindow(null, 1);
        Assertions.assertEquals("Enter Player Names", nameWindow.getInstructions().getText());
    }

    @Test
    void testConstraintLabelInit() {
        NameWindow nameWindow = new NameWindow(null, 1);
        Assertions.assertEquals("*must enter a name for each player*", nameWindow.getConstraintNotice().getText());
    }

    @Test
    void testGameButtonInit() {
        NameWindow nameWindow = new NameWindow(null, 1);
        Assertions.assertEquals("Start Game", nameWindow.getToGameWindow().getText());
    }

    @Test
    void testNorthInit() {
        NameWindow nameWindow = new NameWindow(null, 1);
        Assertions.assertNotNull(nameWindow.getContentNorth());
    }

    @Test
    void testCenterInit() {
        NameWindow nameWindow = new NameWindow(null, 1);
        Assertions.assertNotNull(nameWindow.getContentCenter());
    }

    @Test
    void testSouthInit() {
        NameWindow nameWindow = new NameWindow(null, 1);
        Assertions.assertNotNull(nameWindow.getContentSouth());
    }

    @Test
    void testTextFieldUse() {
        NameWindow nameWindow = new NameWindow(null, 1);
        nameWindow.getPlayerNameCollectors().get(0).setText("test");
        Assertions.assertEquals("test", nameWindow.getPlayerNameCollectors().get(0).getText());
    }
}
