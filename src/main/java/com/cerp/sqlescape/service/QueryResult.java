package com.cerp.sqlescape.service;

import java.sql.ResultSet;

/**
 * Wrapper of a query result and its metadata.
 */
public class QueryResult {
    private ResultSet resultSet;
    private boolean successful;
    private String errorMessage;
    private long executionTime;
    private int rowCount;

    public QueryResult(ResultSet resultSet) {
        this.resultSet = resultSet;
        this.successful = true;
    }

    public QueryResult(String errorMessage) {
        this.errorMessage = errorMessage;
        this.successful = false;
    }

    public boolean isSuccessful() {
        return successful;
    }

    public ResultSet getResultSet() {
        return resultSet;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public int getRowCount() {
        return rowCount;
    }

    public long getExecutionTime() {
        return executionTime;
    }
}
