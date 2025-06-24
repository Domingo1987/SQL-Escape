package com.cerp.model;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.cerp.Logger;

/**
 * Represents an SQL challenge of a level.
 */
public class Challenge {
    private int challengeId;
    private String description;
    private String expectedQuery;
    private ResultSet expectedResult;
    private List<String> hints = new ArrayList<>();
    private DifficultyLevel difficulty;
    private int points;

    public Challenge(int id, String description) {
        Logger.log("Challenge.<init>");
        this.challengeId = id;
        this.description = description;
    }

    public String getDescription() {
        Logger.log("Challenge.getDescription");
        return description;
    }

    public String getExpectedQuery(){
        Logger.log("Challenge.getExpectedQuery");
        return expectedQuery;
    }

    public ResultSet getExpectedResult() {
        Logger.log("Challenge.getExpectedResult");
        return expectedResult;
    }

    public void addHint(String hint) {
        Logger.log("Challenge.addHint");
        hints.add(hint);
    }

    public List<String> getHints() {
        Logger.log("Challenge.getHints");
        return hints;
    }

    public int getPoints() {
        Logger.log("Challenge.getPoints");
        return points;
    }

    public DifficultyLevel getDifficulty() {
        Logger.log("Challenge.getDifficulty");
        return difficulty;
    }
}
