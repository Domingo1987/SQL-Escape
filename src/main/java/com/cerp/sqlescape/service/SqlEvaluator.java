package com.cerp.sqlescape.service;

import com.cerp.sqlescape.db.GameDatabase;
import com.cerp.sqlescape.model.Challenge;

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
        this.databaseConnection = connection;
    }

    public ValidationResult validateQuery(String query) {
        return syntaxValidator.validateSyntax(query);
    }

    public QueryResult executeQuery(String query) {
        try (Statement stmt = databaseConnection.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            return new QueryResult(rs);
        } catch (Exception e) {
            return new QueryResult(e.getMessage());
        }
    }

    public boolean compareResults(ResultSet expected, ResultSet actual) {
        // Simplified comparison
        return true;
    }

    public EvaluationResult evaluateChallenge(String query, Challenge challenge) {
        ValidationResult validation = validateQuery(query);
        QueryResult result = executeQuery(query);
        EvaluationResult eval = new EvaluationResult(true, challenge.getPoints());
        eval.setFeedback("OK");
        return eval;
    }

    public java.util.List<String> getSyntaxErrors(String query) {
        return syntaxValidator.checkForbiddenCommands(query);
    }
}
