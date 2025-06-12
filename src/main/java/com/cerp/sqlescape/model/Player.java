package com.cerp.sqlescape.model;

import java.util.Date;

/**
 * Represents a player of the game.
 */
public class Player {
    private int playerId;
    private String playerName;
    private int currentLevel;
    private int totalScore;
    private Date gameStartTime;
    private Date lastPlayTime;

    public Player(String name) {
        this.playerName = name;
        this.currentLevel = 1;
        this.totalScore = 0;
        this.gameStartTime = new Date();
        this.lastPlayTime = new Date();
    }

    public int getId() {
        return playerId;
    }

    public String getName() {
        return playerName;
    }

    public int getCurrentLevel() {
        return currentLevel;
    }

    public void setCurrentLevel(int level) {
        this.currentLevel = level;
    }

    public int getScore() {
        return totalScore;
    }

    public void addScore(int points) {
        this.totalScore += points;
    }

    public void updateLastPlayTime() {
        this.lastPlayTime = new Date();
    }

    public long getPlayTime() {
        return lastPlayTime.getTime() - gameStartTime.getTime();
    }
}
