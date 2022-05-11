package edu.gonzaga.ScoreCard;

import java.util.ArrayList;
import edu.gonzaga.ScoreCard.ScoreLines.*;

/**
 * ScoreCard is the class that holds the basic outline for score keeping in the yahtzee game
 * 
 * @author Anna Cardinal
 * @version 1.0 5/6/2022
 */
public class ScoreCard {

    private UpperScoreLine ones;
    private UpperScoreLine twos;
    private UpperScoreLine threes;
    private UpperScoreLine fours;
    private UpperScoreLine fives;
    private UpperScoreLine sixes;
    private ArrayList<ScoreLine> upperScoreLines = new ArrayList<>();

    private OfAKindLine threeOfAKindLine;
    private OfAKindLine fourOfAKindLine;
    private FullHouseLine fullHouseLine;
    private StraightLine smallStraightLine;
    private StraightLine largeStraightLine;
    private OfAKindLine yahtzeeLine;
    private ChanceLine chanceLine;
    private ArrayList<ScoreLine> lowerScoreLines = new ArrayList<>();

    private TotalScoreLine upperTotalLine;
    private BonusLine upperBonusLine;
    private TotalScoreLine upperGrandTotalLine;
    private TotalScoreLine lowerTotalLine;
    private TotalScoreLine lowerUpperTotalLine;
    private TotalScoreLine grandTotalScoreLine;
    private ArrayList<ScoreLine> totalLines = new ArrayList<>();

    private TitleLineView upperTitle;
    private TitleLineView lowerTitle;
    private ArrayList<TitleLineView> titleLines = new ArrayList<>();

    private ArrayList<ScoreLine> scoreLines = new ArrayList<>();
    private String name;
    private ScoreCardView view;
    private int numUpperScoringRows; 
    
    public ScoreCard(String name, int numDiceSides, int numPlayers) {
        this.name = name;
        this.numUpperScoringRows = numDiceSides;
        configureScoreLines(numPlayers);
        configureTotalLines(numPlayers);
        configureTitleLines(numPlayers);
        configureView(); 
    }

    /**
    * assigns the scorelines based on number of players
    *
    * @param numPlayers number of players to be recorded on card
    */
    public void configureScoreLines(int numPlayers) {
        ones = new UpperScoreLine(" Aces 1's", "Count and Add Only Aces", 1, numPlayers);
        twos = new UpperScoreLine(" Twos 2's", "Count and Add Only Twos", 2, numPlayers);
        threes = new UpperScoreLine(" Threes 3's", "Count and Add Only Threes", 3, numPlayers);
        fours = new UpperScoreLine(" Fours 4's", "Count and Add Only Fours", 4, numPlayers);
        fives = new UpperScoreLine(" Fives 5's", "Count and Add Only Fives", 5, numPlayers);
        sixes = new UpperScoreLine(" Sixes 6's", "Count and Add Only Sixes", 6, numPlayers);
        upperScoreLines.add(ones);
        upperScoreLines.add(twos);
        upperScoreLines.add(threes);
        upperScoreLines.add(fours);
        upperScoreLines.add(fives);
        upperScoreLines.add(sixes);

        threeOfAKindLine = new OfAKindLine(" 3 of a Kind", "Add Total of All Dice", 3, numPlayers);
        fourOfAKindLine = new OfAKindLine(" 4 of a Kind", "Add Total of All Dice", 4, numPlayers);
        fullHouseLine = new FullHouseLine(" Full House", "Score 25", numPlayers);
        smallStraightLine = new StraightLine(" Sm. Straight", "Score 30", 4, numPlayers);
        largeStraightLine = new StraightLine(" Lg. Straight", "Score 40", 5, numPlayers);
        yahtzeeLine = new OfAKindLine(" YAHTZEE", "Score 50", 5, numPlayers);
        chanceLine = new ChanceLine(" Chance", "Score Total of All Dice", numPlayers);
        lowerScoreLines.add(threeOfAKindLine);
        lowerScoreLines.add(fourOfAKindLine);
        lowerScoreLines.add(fullHouseLine);
        lowerScoreLines.add(smallStraightLine);
        lowerScoreLines.add(largeStraightLine);
        lowerScoreLines.add(yahtzeeLine);
        lowerScoreLines.add(chanceLine);

        for (int i = 0; i < numUpperScoringRows; i++) {
            scoreLines.add(upperScoreLines.get(i));
        }
        for (int i = 0; i < lowerScoreLines.size(); i++) {
            scoreLines.add(lowerScoreLines.get(i));
        }

    }

    /**
    * assigns the TotalLines based on the number of players 
    *
    * @param numPlayers int value corresponding to the number of players to be recorded on the card
    */
    public void configureTotalLines(int numPlayers) {
        upperTotalLine = new TotalScoreLine(" Total Score", "--->", numPlayers, upperScoreLines);
        upperBonusLine = new BonusLine(" Bonus", "If total score over 62, score 35", numPlayers, upperTotalLine);
        ArrayList<ScoreLine> allUpperLines = new ArrayList<>();
        for (int i = 0; i < upperScoreLines.size(); i++) {
            allUpperLines.add(upperScoreLines.get(i));
        }
        allUpperLines.add(upperBonusLine);
        upperGrandTotalLine = new TotalScoreLine(" Total", "--->", numPlayers, allUpperLines);
        lowerTotalLine = new TotalScoreLine(" Total (lower)", "--->", numPlayers, lowerScoreLines);
        lowerUpperTotalLine = new TotalScoreLine(" Total (upper)", "--->", numPlayers, allUpperLines);
        ArrayList<ScoreLine> allLines = new ArrayList<>() { { add(lowerTotalLine); add(lowerUpperTotalLine); } };
        grandTotalScoreLine = new TotalScoreLine(" Grand Total", "--->", numPlayers, allLines);
        grandTotalScoreLine.setBottomBorder();
        
        totalLines.add(upperTotalLine);
        totalLines.add(upperBonusLine);
        totalLines.add(upperGrandTotalLine);
        totalLines.add(lowerTotalLine);
        totalLines.add(lowerUpperTotalLine);
        totalLines.add(grandTotalScoreLine);
    }

    /**
    * assigns the TitleLines based on the number of player
    *
    * @param numPlayers int value corresponding to the number of players to be recorded on the card
    */
    public void configureTitleLines(int numPlayers) {
        ArrayList<String> scoreHeaders = new ArrayList<>();
        for (int i = 0; i < numPlayers; i++) {
            scoreHeaders.add("Score");
        }
        upperTitle = new TitleLineView(" Upper Section", "How to Score", scoreHeaders);
        lowerTitle = new TitleLineView(" Lower Section", "How to Score", scoreHeaders);
        titleLines.add(upperTitle);
        titleLines.add(lowerTitle);
    }

    /** creates a ScoreCardView object with card's visual information*/
    public void configureView() { view = new ScoreCardView(name, scoreLines, totalLines, titleLines); }

    /**
    * Gets the view
    *
    * @return ScoreCardView with visual information
    */
    public ScoreCardView getView() { return view; }

    /**
    * Gets the height of the card rows
    *
    * @return int value corresponding to the row height
    */
    public int getRowHeight() { return view.getRowHeight(); }

    /**
    * Gets the width of the card rows
    *
    * @return int value corresponding to the row width
    */
    public int getRowWidth() { return view.getRowWidth(); }

    /**
    * Gets all scorelines
    *
    * @return ArrayList<ScoreLines> with all scorelines
    */
    public ArrayList<ScoreLine> getScoreLines() { return scoreLines; }

    /**
    * Gets all totallines
    *
    * @return ArrayList<ScoreLines> with all totalLines
    */
    public ArrayList<ScoreLine> getTotalLines() { return totalLines; }

    /**
    * sets the score on a given row in a given column
    *
    * @param scoringRow int corresponding to the row where the score is to be recorded
    * @param scoringColumn int corresponding to the column where the score is to be recorded
    * @param score int corresponding to the new score to be recorded
    */
    public void setScore(int scoringRow, int scoringColumn, int score) {
        scoreLines.get(scoringRow - 1).setScore(scoringColumn, score);
    }

}
