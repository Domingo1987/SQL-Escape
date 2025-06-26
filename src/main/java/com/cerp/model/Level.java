package com.cerp.model;

import com.cerp.Logger;

/**
 * Represents a level of the game containing a challenge and narrative.
 */
public class Level {
    private int levelId;
    private int levelNumber;
    private String title;
    private String narrative;
    private Challenge challenge;
    private boolean isUnlocked;
    private int requiredLevel;
    private String feedback;

    public Level(int id, int number, String title) {
        Logger.log("Level.<init>");
        this.levelId = id;
        this.levelNumber = number;
        this.title = title;
    }

    public int getId() {
        Logger.log("Level.getId");
        return levelId;
    }

    public int getNumber() {
        Logger.log("Level.getNumber");
        return levelNumber;
    }

    public String getTitle() {
        Logger.log("Level.getTitle");
        return title;
    }

    public String getNarrative() {
        Logger.log("Level.getNarrative");
        return narrative;
    }

    public void setNarrative(String narrative) {
        Logger.log("Level.setNarrative");
        this.narrative = narrative;
    }

    public Challenge getChallenge() {
        Logger.log("Level.getChallenge");
        return challenge;
    }

    public void setChallenge(Challenge challenge) {
        Logger.log("Level.setChallenge");
        this.challenge = challenge;
    }

    public boolean isAccessible(int playerLevel) {
        Logger.log("Level.isAccessible");
        return isUnlocked || playerLevel >= requiredLevel;
    }

    public void unlock() {
        Logger.log("Level.unlock");
        this.isUnlocked = true;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}
