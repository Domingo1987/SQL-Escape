package com.cerp.model;

import com.cerp.Logger;

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
        Logger.log("Player.<init>");
        this.playerName = name;
        this.currentLevel = 1;
        this.totalScore = 0;
        this.gameStartTime = new Date();
        this.lastPlayTime = new Date();
    }

    public int getId() {
        Logger.log("Player.getId");
        return playerId;
    }

    public String getName() {
        Logger.log("Player.getName");
        return playerName;
    }

    public int getCurrentLevel() {
        Logger.log("Player.getCurrentLevel");
        return currentLevel;
    }

    public void setCurrentLevel(int level) {
        Logger.log("Player.setCurrentLevel");
        this.currentLevel = level;
    }

    public int getScore() {
        Logger.log("Player.getScore");
        return totalScore;
    }

    public void addScore(int points) {
        Logger.log("Player.addScore");
        this.totalScore += points;
    }

    public void updateLastPlayTime() {
        Logger.log("Player.updateLastPlayTime");
        this.lastPlayTime = new Date();
    }

    public long getPlayTime() {
        Logger.log("Player.getPlayTime");
        return lastPlayTime.getTime() - gameStartTime.getTime();
    }
}
