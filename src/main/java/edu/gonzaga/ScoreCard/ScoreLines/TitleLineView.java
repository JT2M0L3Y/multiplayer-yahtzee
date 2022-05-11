package edu.gonzaga.ScoreCard.ScoreLines;

import java.util.ArrayList;

/**
 * TitleLineView is the class that represents the lines on the scorecard containing titles instead of scores
 * 
 * @author Anna Cardinal
 * @version 1.0 5/6/2022
 */
public class TitleLineView extends ScoreLineView {

    public TitleLineView(String nameHeader, String scoringExplanationHeader, ArrayList<String> scoreHeaders) {
        super(nameHeader, scoringExplanationHeader, scoreHeaders.size());
        setScoreHeaders(scoreHeaders);
    }

    /**
    * sets the text on the score header cells
    *
    * @param scoreHeaders ArrayList<Strings> with header texts to be assigned
    */
    public void setScoreHeaders(ArrayList<String> scoreHeaders) {
        for (int i = 0; i < scoreHeaders.size(); i++) {
            updateScoreCell(scoreHeaders.get(i), i + 1);
        }
    }
    
}
