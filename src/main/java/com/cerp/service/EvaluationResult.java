package com.cerp.service;

import com.cerp.Logger;

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
        Logger.log("EvaluationResult.<init>");
        this.correct = isCorrect;
        this.score = score;
    }

    public boolean isCorrect() {
        Logger.log("EvaluationResult.isCorrect");
        return correct;
    }

    public int getScore() {
        Logger.log("EvaluationResult.getScore");
        return score;
    }

    public String getFeedback() {
        Logger.log("EvaluationResult.getFeedback");
        return feedback;
    }

    public void setFeedback(String feedback) {
        Logger.log("EvaluationResult.setFeedback");
        this.feedback = feedback;
    }

    public QueryResult getQueryResult() {
        Logger.log("EvaluationResult.getQueryResult");
        return queryResult;
    }

    public ValidationResult getValidationResult() {
        Logger.log("EvaluationResult.getValidationResult");
        return validationResult;
    }

    public void setQueryResult(QueryResult queryResult) {
        this.queryResult = queryResult;
    }
}
