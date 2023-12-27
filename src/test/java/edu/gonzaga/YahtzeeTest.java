package edu.gonzaga;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class YahtzeeTest {
    @Test
    void testInit() {
        Yahtzee game = new Yahtzee();
        assertNotNull(game);
    }
}
