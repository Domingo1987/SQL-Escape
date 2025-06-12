package com.cerp.model;

import java.util.Date;

/**
 * Tracks the progress of a player for a specific level.
 */
public class PlayerProgress {
    private int progressId;
    private int playerId;
    private int levelId;
    private boolean isCompleted;
    private int attempts;
    private Date completionTime;
    private String bestQuery;

    public PlayerProgress(int playerId, int levelId) {
        this.playerId = playerId;
        this.levelId = levelId;
    }

    public void markAsCompleted() {
        this.isCompleted = true;
        this.completionTime = new Date();
    }

    public void incrementAttempts() {
        this.attempts++;
    }

    public void setBestQuery(String query) {
        this.bestQuery = query;
    }

    public int getAttempts() {
        return attempts;
    }

    public boolean isLevelCompleted() {
        return isCompleted;
    }
}
