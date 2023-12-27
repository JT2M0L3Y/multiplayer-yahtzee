package edu.gonzaga;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class LineTest {
    @Test
    void testNameInit() {
        String expectedValue = "Test";
        Scoreline line = new Scoreline("Test", null, null, null, null);
        assertEquals(expectedValue, line.getName());
    }

    @Test
    void testScoreInit() {
        Integer expectedValue = 9001;
        Scoreline line = new Scoreline(null, 9001, null, null, null);
        assertEquals(expectedValue, line.getScore());
    }

    @Test
    void testPossibleInit() {
        Integer expectedValue = 42;
        Scoreline line = new Scoreline(null, null, 42, null, null);
        assertEquals(expectedValue, line.getPossible());
    }

    @Test
    void testCodeInit() {
        String expectedValue = "TS";
        Scoreline line = new Scoreline(null, null, null, "TS", null);
        assertEquals(expectedValue, line.getCode());
    }

    @Test
    void testStatusInit() {
        Boolean expectedValue = true;
        Scoreline line = new Scoreline(null, null, null, null, true);
        assertEquals(expectedValue, line.getUsed());
    }
}
