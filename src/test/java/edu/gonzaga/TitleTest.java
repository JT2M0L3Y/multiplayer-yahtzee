package edu.gonzaga;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import edu.gonzaga.Windows.*;

public class TitleTest {
    @Test
    void testPanelInit() {
        TitleWindow titleWindow = new TitleWindow();
        Assertions.assertNotNull(titleWindow);
    }

    @Test
    void testTitleInit() {
        TitleWindow titleWindow = new TitleWindow();
        Assertions.assertNotNull(titleWindow.getTitle());
    }

    @Test
    void testButtonInit() {
        TitleWindow titleWindow = new TitleWindow();
        Assertions.assertEquals("Start", titleWindow.getToNameWindow().getText());
    }

    @Test
    void testDropBoxInit() {
        TitleWindow titleWindow = new TitleWindow();
        Assertions.assertEquals(0, titleWindow.getNumPlayerDropBox().getSelectedIndex());
    }

    @Test
    void testDropBoxUse() {
        TitleWindow titleWindow = new TitleWindow();
        titleWindow.getNumPlayerDropBox().setSelectedIndex(7);
        Assertions.assertEquals(7, titleWindow.getNumPlayerDropBox().getSelectedIndex());
    }
}
