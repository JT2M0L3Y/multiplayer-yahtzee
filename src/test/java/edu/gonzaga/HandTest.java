package edu.gonzaga;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


public class HandTest {

    @Test
    void testHandConstructorSize() {
        int expectedSize = 5;
        Hand hand = new Hand();
        assertEquals(hand.getSize(), expectedSize);
    }

    @Test
    void testHandConstructorFill() {
        int expectedFill = 1;
        Hand hand = new Hand();
        for (int i = 0; i < hand.getSize(); ++i)
            assertEquals(hand.returnValue(i), expectedFill);
    }

    @Test
    void testHandRollNewKeepAll() {
        Hand hand = new Hand();
        int expectedFill = 1;
        for (int i = 0; i < hand.getSize(); ++i)
            hand.getDie(i).changeLockedState();
        hand.RollNewHand();
        for (int i = 0; i < hand.getSize(); ++i)
            assertEquals(hand.returnValue(i), expectedFill);
    }

    @Test
    void testHandRollNewKeepFour() {
        Hand hand = new Hand();
        int expectedFill = 1;
        //Test roll 1
        for (int i = 1; i < hand.getSize(); ++i)
            hand.getDie(i).changeLockedState();
        while (hand.getDie(0).getSideUp() == 1)
            hand.RollNewHand();
        assertNotEquals(hand.returnValue(0), expectedFill);
    }

    @Test
    void testHandSum1() {
        Hand hand1 = new Hand();
        Integer expectedSum1 = 15;
        for (int i = 0; i < hand1.getSize(); ++i)
            hand1.getDie(i).setValue(3);
        assertEquals(hand1.sum(), expectedSum1);
    }

    @Test
    void testHandSum2() {
        Hand hand2 = new Hand();
        Integer expectedSum2 = 10;
        for (int i = 0; i < hand2.getSize(); ++i)
            hand2.getDie(i).setValue(2);
        assertEquals(hand2.sum(), expectedSum2);
    }

    @Test
    void testHandToString() {
        Hand hand = new Hand();
        String expectedOutput = "Hand: 1 | 1 | 1 | 1 | 1 | ";
        String output = hand.toString();
        assertEquals(output, expectedOutput);
    }

    @Test
    void testHandIsTurnOverFalse() {
        Hand hand = new Hand();
        hand.RollNewHand();
        hand.RollNewHand();
        assertEquals(false, hand.isTurnOver());
    }

    @Test
    void testHandIsTurnOverTrue() {
        Hand hand = new Hand();
        hand.RollNewHand();
        hand.RollNewHand();
        hand.RollNewHand();
        assertEquals(true, hand.isTurnOver());
    }

    @Test
    void testHandSize() {
        Hand hand = new Hand();
        int expectedSize = 5;
        assertEquals(expectedSize, hand.getSize());
    }

    @Test
    void testHandReset() {
        Hand hand = new Hand();
        Hand expectedHand = new Hand();
        for (int i = 0; i < hand.getSize(); ++i)
            hand.getDie(i).setValue(3);
        hand.reset();
        for (int i = 0; i < hand.getSize(); ++i)
            assertEquals(hand.returnValue(i), expectedHand.returnValue(i));
    }


}


