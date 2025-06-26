package com.cerp.service;

import com.cerp.model.Challenge;
import com.cerp.Logger;

import java.sql.*;
import java.util.List;

/**
 * Executes queries and compares them with expected results.
 */
public class SqlEvaluator {
    private Connection databaseConnectionNarrativa;
    private Connection databaseConnectionSQLEscape;
    private SqlSyntaxValidator syntaxValidator = new SqlSyntaxValidator();

    public SqlEvaluator(Connection connectionS) {
        Logger.logRed("SqlEvaluator.<init>");
        this.databaseConnectionSQLEscape = connectionS;
    }

    public ValidationResult validateQuery(String query) {
        Logger.log("SqlEvaluator.validateQuery");
        return syntaxValidator.validateSyntax(query);
    }

    public QueryResult executeQuery(String query) {
        Logger.log(query);
        try (Statement stmt = databaseConnectionSQLEscape.createStatement();
             ResultSet rs = stmt.executeQuery(query);) {
            return new QueryResult(rs);
        } catch (Exception e) {
            Logger.logError("Error ejecutando consulta: " + e.getMessage());
            return new QueryResult(e.getMessage());
        }
    }

    /**
     * Compares two result sets for equality
     * @param expected the expected result set
     * @param actual the actual result set from user query
     * @return true if results match, false otherwise
     */
    public boolean compareResults(ResultSet expected, ResultSet actual) {
        Logger.log("SqlEvaluator.compareResults");
        try {
            // Compare column count
            int expectedColumns = expected.getMetaData().getColumnCount();
            int actualColumns = actual.getMetaData().getColumnCount();

            if (expectedColumns != actualColumns) {
                Logger.log("Diferente número de columnas: esperado=" + expectedColumns + ", actual=" + actualColumns);
                return false;
            }

            // Compare column names (optional - some queries might use aliases)
            for (int i = 1; i <= expectedColumns; i++) {
                String expectedColName = expected.getMetaData().getColumnName(i);
                String actualColName = actual.getMetaData().getColumnName(i);
                Logger.log("Comparando columna " + i + ": " + expectedColName + " vs " + actualColName);
            }

            // Compare data row by row
            int rowCount = 0;
            while (expected.next() && actual.next()) {
                rowCount++;
                for (int i = 1; i <= expectedColumns; i++) {
                    String expectedValue = expected.getString(i);
                    String actualValue = actual.getString(i);

                    // Handle nulls
                    if (expectedValue == null && actualValue == null) continue;
                    if (expectedValue == null || actualValue == null) {
                        Logger.log("Diferencia en fila " + rowCount + ", columna " + i + ": uno es null");
                        return false;
                    }

                    if (!expectedValue.equals(actualValue)) {
                        Logger.log("Diferencia en fila " + rowCount + ", columna " + i + ": '" +
                                expectedValue + "' vs '" + actualValue + "'");
                        return false;
                    }
                }
            }

            // Check if one result set has more rows than the other
            if (expected.next() || actual.next()) {
                Logger.log("Diferente número de filas");
                return false;
            }

            Logger.log("Resultados coinciden perfectamente. Filas comparadas: " + rowCount);
            return true;

        } catch (Exception e) {
            Logger.logError("Error comparando resultados: " + e.getMessage());
            return false;
        }
    }

    /**
     * Normalizes a SQL query by removing extra whitespace and converting to lowercase
     * @param query the SQL query to normalize
     * @return normalized query string
     */
    private String normalizeQuery(String query) {
        if (query == null) return "";
        return query.trim()
                .replaceAll("\\s+", " ") // Replace multiple spaces with single space
                .toLowerCase();
    }

    /**
     * Checks if the user's query matches any of the expected queries (exact match)
     * @param userQuery the query submitted by the user
     * @param expectedQueries list of expected queries
     * @return true if there's an exact match
     */
    private boolean isExactQueryMatch(String userQuery, List<String> expectedQueries) {
        String normalizedUserQuery = normalizeQuery(userQuery);
        Logger.log("Consulta usuario normalizada: " + normalizedUserQuery);

        for (String expectedQuery : expectedQueries) {
            String normalizedExpected = normalizeQuery(expectedQuery);
            Logger.log("Comparando con consulta esperada: " + normalizedExpected);

            if (normalizedUserQuery.equals(normalizedExpected)) {
                Logger.log("¡COINCIDENCIA EXACTA encontrada!");
                return true;
            }
        }

        Logger.log("No se encontró coincidencia exacta");
        return false;
    }
    public String resultSetAString(ResultSet rs) throws SQLException {
        StringBuilder sb = new StringBuilder();
        ResultSetMetaData metaData = rs.getMetaData();
        int columnas = metaData.getColumnCount();

        while (rs.next()) {
            for (int i = 1; i <= columnas; i++) {
                sb.append(metaData.getColumnName(i))
                        .append(": ")
                        .append(rs.getString(i));

                if (i < columnas) {
                    sb.append(", ");
                }
            }
            sb.append("\\n"); // ⚠️ Importante: barra N, no salto real
        }

        return sb.toString();
    }


    public EvaluationResult evaluateChallenge(String query, Challenge challenge) throws SQLException {
        Logger.log("SqlEvaluator.evaluateChallenge");

        if (challenge == null) {
            Logger.logRed("Challenge es null");
            EvaluationResult eval = new EvaluationResult(false, 0);
            eval.setFeedback("Error: Challenge no encontrado");
            return eval;
        }

        List<String> expectedQueries = challenge.getAllExpectedQueries();
        Logger.logRed("Evaluando consulta: " + query);
        Logger.logRed("Consultas esperadas: " + expectedQueries);

        //0 Ver si query está en expectedQuery
        if(!expectedQueries.contains(query)){
            EvaluationResult eval = new EvaluationResult(false, 0);
            eval.setFeedback("BURRO");
            return eval;
        }
        /*
        // 1. Validar sintaxis
        ValidationResult validation = validateQuery(query);
        if (!validation.isValid()) {
            Logger.log("Consulta inválida sintácticamente");
            EvaluationResult eval = new EvaluationResult(false, 0);
            eval.setFeedback("Error de sintaxis: " + String.join(", ", validation.getErrors()));
            return eval;
        }
        */
        // 2. Ejecutar consulta del usuario
        QueryResult userResult = executeQuery(query);
        if (!userResult.isSuccessful()) {
            Logger.log("Error ejecutando consulta del usuario");
            EvaluationResult eval = new EvaluationResult(false, 0);
            eval.setFeedback("Error ejecutando consulta: " + userResult.getErrorMessage());
            return eval;

        }


        Logger.logGreen("Ejecutando SQL: " + query);

        try (Statement stmt = databaseConnectionSQLEscape.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                String consulta = rs.getString("consulta");
                Logger.logRed("xxxxxxxxxxxxxx" + consulta);
            }



        } catch (Exception e) {
            Logger.logError("Error en output" + e.getMessage());
            e.printStackTrace();
        }




        /*
        // 3. Verificar coincidencia exacta primero (más eficiente)
        if (isExactQueryMatch(query, expectedQueries)) {
            Logger.log("Consulta exacta correcta!");
            EvaluationResult eval = new EvaluationResult(true, challenge.getPoints());
            eval.setFeedback("¡Perfecto! Tu consulta es exactamente la esperada.");
            return eval;
        }

        // 4. Si no hay coincidencia exacta, comparar resultados
        Logger.log("No hay coincidencia exacta, comparando resultados...");

        boolean resultsMatch = false;
        String matchingQuery = null;

        for (String expectedQuery : expectedQueries) {
            Logger.log("Ejecutando consulta esperada: " + expectedQuery);
            QueryResult expectedResult = executeQuery(expectedQuery);

            if (expectedResult.isSuccessful()) {
                if (compareResults(expectedResult.getResultSet(), userResult.getResultSet())) {
                    resultsMatch = true;
                    matchingQuery = expectedQuery;
                    break;
                }
            } else {
                Logger.logError("Error ejecutando consulta esperada: " + expectedResult.getErrorMessage());
            }
        }
        */
        // 5. Generar resultado final
        EvaluationResult eval;
        //if (resultsMatch) {
            Logger.log("¡Los resultados coinciden!");
            eval = new EvaluationResult(true, challenge.getPoints());
            String res = resultSetAString(userResult.getResultSet());
            Logger.logGreen(res);
            userResult.setResult(res);
            eval.setQueryResult(userResult);
            eval.setFeedback("¡Correcto! Tu consulta produce el resultado esperado.\n" +
                    "Consulta esperada: " + query);
        /*} else {
            Logger.log("Los resultados no coinciden");
            eval = new EvaluationResult(false, 0);
            eval.setFeedback("Incorrecto. Tu consulta no produce el resultado esperado.\n" +
                    "Consulta esperada: " + challenge.getExpectedQuery());
        }*/

        return eval;
    }

    public java.util.List<String> getSyntaxErrors(String query) {
        Logger.log("SqlEvaluator.getSyntaxErrors");
        return syntaxValidator.checkForbiddenCommands(query);
    }
}