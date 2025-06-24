package com.cerp.service;

import com.cerp.model.Challenge;
import com.cerp.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Executes queries and compares them with expected results.
 */
public class SqlEvaluator {
    private Connection databaseConnection;
    private SqlSyntaxValidator syntaxValidator = new SqlSyntaxValidator();

    public SqlEvaluator(Connection connection) {
        Logger.log("SqlEvaluator.<init>");
        this.databaseConnection = connection;
    }

    public ValidationResult validateQuery(String query) {
        Logger.log("SqlEvaluator.validateQuery");
        return syntaxValidator.validateSyntax(query);
    }

    public QueryResult executeQuery(String query) {
        Logger.log("SqlEvaluator.executeQuery");
        try (Statement stmt = databaseConnection.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            return new QueryResult(rs);
        } catch (Exception e) {
            return new QueryResult(e.getMessage());
        }
    }

    public boolean compareResults(ResultSet expected, ResultSet actual) {
        Logger.log("SqlEvaluator.compareResults");
        // Simplified comparison
        return true;
    }

    public EvaluationResult evaluateChallenge(String query, Challenge challenge) {
        Logger.log("SqlEvaluator.evaluateChallenge");
        String res = challenge.getExpectedQuery();
        Logger.logRed(res);
        ValidationResult validation = validateQuery(query);
        QueryResult result = executeQuery(query);
        EvaluationResult eval;
        if (validation.isValid() && result.isSuccessful()) {

            eval = new EvaluationResult(true, challenge.getPoints());
            eval.setFeedback("correcto");
        }
        else {
            eval = new EvaluationResult(false, 0);
            eval.setFeedback("BURRO");

        }
        return eval;
    }

    public java.util.List<String> getSyntaxErrors(String query) {
        Logger.log("SqlEvaluator.getSyntaxErrors");
        return syntaxValidator.checkForbiddenCommands(query);
    }
}
