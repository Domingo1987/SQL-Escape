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
    private List<String> expectedQueries = new ArrayList<>(); // Lista de consultas esperadas
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

    /**
     * Returns the primary expected query (first one in the list)
     * @return the primary expected query or null if none exist
     */
    public String getExpectedQuery(){
        Logger.log("Challenge.getExpectedQuery");
        return expectedQueries.isEmpty() ? null : expectedQueries.get(0);
    }

    /**
     * Returns all expected queries for this challenge
     * @return list of expected queries
     */
    public List<String> getAllExpectedQueries() {
        Logger.log("Challenge.getAllExpectedQueries");
        return new ArrayList<>(expectedQueries);
    }

    /**
     * Sets the expected queries for this challenge
     * @param queries list of expected SQL queries
     */
    public void setExpectedQueries(List<String> queries) {
        Logger.log("Challenge.setExpectedQueries con " + queries.size() + " consultas");
        this.expectedQueries = new ArrayList<>(queries);
    }

    /**
     * Sets a single expected query (replaces any existing ones)
     * @param query the expected SQL query
     */
    public void setExpectedQuery(String query) {
        Logger.log("Challenge.setExpectedQuery: " + query);
        this.expectedQueries.clear();
        if (query != null) {
            this.expectedQueries.add(query);
        }
    }

    /**
     * Adds an additional expected query
     * @param query the SQL query to add
     */
    public void addExpectedQuery(String query) {
        Logger.log("Challenge.addExpectedQuery: " + query);
        if (query != null) {
            this.expectedQueries.add(query);
        }
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

    public void setPoints(int points) {
        Logger.log("Challenge.setPoints: " + points);
        this.points = points;
    }

    public DifficultyLevel getDifficulty() {
        Logger.log("Challenge.getDifficulty");
        return difficulty;
    }

    public int getChallengeId() {
        Logger.log("Challenge.getChallengeId");
        return challengeId;
    }
}