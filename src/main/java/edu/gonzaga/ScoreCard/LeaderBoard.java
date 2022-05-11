package edu.gonzaga.ScoreCard;

import java.util.ArrayList;
import edu.gonzaga.Player;

/**
 * LeaderBoard is the class that presents the players final scores in EndGameWindow
 * 
 * @author Anna Cardinal
 * @version 1.0 5/6/2022
 */
public class LeaderBoard extends ScoreCard {

    LeaderBoardView view;

    public LeaderBoard(ArrayList<Player> players) {
        super("Leaderboard", 6, players.size());
        view = new LeaderBoardView(super.getView(), players);
    }

    /**
    * gets the view
    *
    * @return LeaderBoardView with board view information
    */
    public LeaderBoardView getLeaderBoardView() { return view; }
    
}
