package com.cerp.model;

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

    public Level(int id, int number, String title) {
        this.levelId = id;
        this.levelNumber = number;
        this.title = title;
    }

    public int getId() {
        return levelId;
    }

    public int getNumber() {
        return levelNumber;
    }

    public String getTitle() {
        return title;
    }

    public String getNarrative() {
        return narrative;
    }

    public void setNarrative(String narrative) {
        this.narrative = narrative;
    }

    public Challenge getChallenge() {
        return challenge;
    }

    public void setChallenge(Challenge challenge) {
        this.challenge = challenge;
    }

    public boolean isAccessible(int playerLevel) {
        return isUnlocked || playerLevel >= requiredLevel;
    }

    public void unlock() {
        this.isUnlocked = true;
    }
}
