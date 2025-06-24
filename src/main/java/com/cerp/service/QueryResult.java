package com.cerp.service;

import java.sql.ResultSet;
import com.cerp.Logger;

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
        Logger.log("QueryResult.<init>ResultSet");
        this.resultSet = resultSet;
        this.successful = true;
    }

    public QueryResult(String errorMessage) {
        Logger.log("QueryResult.<init>Error");
        this.errorMessage = errorMessage;
        this.successful = false;
    }

    public boolean isSuccessful() {
        Logger.log("QueryResult.isSuccessful");
        return successful;
    }

    public ResultSet getResultSet() {
        Logger.log("QueryResult.getResultSet");
        return resultSet;
    }

    public String getErrorMessage() {
        Logger.log("QueryResult.getErrorMessage");
        return errorMessage;
    }

    public int getRowCount() {
        Logger.log("QueryResult.getRowCount");
        return rowCount;
    }

    public long getExecutionTime() {
        Logger.log("QueryResult.getExecutionTime");
        return executionTime;
    }
}
