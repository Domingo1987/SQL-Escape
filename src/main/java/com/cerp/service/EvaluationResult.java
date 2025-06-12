package com.cerp.service;

/**
 * Represents the result of evaluating a player's query against a challenge.
 */
public class EvaluationResult {
    private boolean correct;
    private int score;
    private String feedback;
    private QueryResult queryResult;
    private ValidationResult validationResult;

    public EvaluationResult(boolean isCorrect, int score) {
        this.correct = isCorrect;
        this.score = score;
    }

    public boolean isCorrect() {
        return correct;
    }

    public int getScore() {
        return score;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public QueryResult getQueryResult() {
        return queryResult;
    }

    public ValidationResult getValidationResult() {
        return validationResult;
    }
}
