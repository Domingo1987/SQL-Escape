package com.cerp.sqlescape.model;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
        this.challengeId = id;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public ResultSet getExpectedResult() {
        return expectedResult;
    }

    public void addHint(String hint) {
        hints.add(hint);
    }

    public List<String> getHints() {
        return hints;
    }

    public int getPoints() {
        return points;
    }

    public DifficultyLevel getDifficulty() {
        return difficulty;
    }
}
