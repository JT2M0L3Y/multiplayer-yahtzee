package edu.gonzaga;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import edu.gonzaga.Windows.*;
import java.util.ArrayList;

public class EndGameTest {
    @Test
    public void testPlayerAccess() {
        ArrayList<Player> players = new ArrayList<Player>();
        Player newPlayer = new Player("First");
        players.add(newPlayer);

        EndGameWindow test = new EndGameWindow(players);
        Assertions.assertEquals("First", test.getPlayers().get(0).getName());
    }

    @Test
    public void testTitleButtonInit() {
        ArrayList<Player> players = new ArrayList<Player>();
        Player newPlayer = new Player("First");
        players.add(newPlayer);

        EndGameWindow test = new EndGameWindow(players);
        Assertions.assertEquals("Return to Title", test.getToTitleScreen().getText());
    }

    @Test
    public void testLeaderBoardInit() {
        ArrayList<Player> players = new ArrayList<Player>();
        Player newPlayer = new Player("First");
        players.add(newPlayer);

        EndGameWindow test = new EndGameWindow(players);
        Assertions.assertEquals("First is the winner!", test.getLeaderBoard().getLeaderBoardView().getWinnerLabel().getText());
    }
}
