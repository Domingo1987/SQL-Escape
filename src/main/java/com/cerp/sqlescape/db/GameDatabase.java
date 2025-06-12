package com.cerp.sqlescape.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Singleton that manages the database connection used by the game.
 */
public class GameDatabase {
    private static GameDatabase instance;
    private Connection connection;
    private String connectionUrl;
    private String username;
    private String password;

    private GameDatabase(String url, String user, String pass) {
        this.connectionUrl = url;
        this.username = user;
        this.password = pass;
    }

    public static synchronized GameDatabase getInstance(String url, String user, String pass) {
        if (instance == null) {
            instance = new GameDatabase(url, user, pass);
        }
        return instance;
    }

    public boolean connect() {
        try {
            connection = DriverManager.getConnection(connectionUrl, username, password);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void disconnect() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (Exception e) {
            // ignore
        }
    }

    public ResultSet executeQuery(String sql) {
        try {
            Statement stmt = connection.createStatement();
            return stmt.executeQuery(sql);
        } catch (Exception e) {
            return null;
        }
    }

    public int executeUpdate(String sql) {
        try (Statement stmt = connection.createStatement()) {
            return stmt.executeUpdate(sql);
        } catch (Exception e) {
            return 0;
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public boolean isConnected() {
        return connection != null;
    }
}
