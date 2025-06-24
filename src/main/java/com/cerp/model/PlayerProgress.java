package com.cerp.model;

import com.cerp.Logger;

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
        Logger.log("PlayerProgress.<init>");
        this.playerId = playerId;
        this.levelId = levelId;
    }

    public void markAsCompleted() {
        Logger.log("PlayerProgress.markAsCompleted");
        this.isCompleted = true;
        this.completionTime = new Date();
    }

    public void incrementAttempts() {
        Logger.log("PlayerProgress.incrementAttempts");
        this.attempts++;
    }

    public void setBestQuery(String query) {
        Logger.log("PlayerProgress.setBestQuery");
        this.bestQuery = query;
    }

    public int getAttempts() {
        Logger.log("PlayerProgress.getAttempts");
        return attempts;
    }

    public boolean isLevelCompleted() {
        Logger.log("PlayerProgress.isLevelCompleted");
        return isCompleted;
    }
}
