package edu.gonzaga.ScoreCardTests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import edu.gonzaga.Player;
import edu.gonzaga.ScoreCard.LeaderBoard;
import java.util.ArrayList;

public class LeaderBoardTest {

    @Test
    void testWinner(){
        Player player = new Player("Jack");
        Player player2 = new Player("John");
        for(int i = 1; i <= 13; i++){
            player.recordScore(i, 1);
            player2.recordScore(i, 2);
        }
        LeaderBoard dummyBoard = new LeaderBoard(new ArrayList<>() {{
            add(player);
            add(player2);
        }});
        String expectedWinner = "John is the winner!";
        String actualWinner = dummyBoard.getLeaderBoardView().getWinnerLabel().getText();
        assertEquals(expectedWinner, actualWinner);
    }
    
}
