package com.cerp.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import com.cerp.Logger;

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
        Logger.log("GameDatabase.connect");
        try {
            connection = DriverManager.getConnection(connectionUrl, username, password);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void disconnect() {
        Logger.log("GameDatabase.disconnect");
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (Exception e) {
            // ignore
        }
    }

    public ResultSet executeQuery(String sql) {
        Logger.log("GameDatabase.executeQuery");
        try {
            Statement stmt = connection.createStatement();
            return stmt.executeQuery(sql);
        } catch (Exception e) {
            return null;
        }
    }

    public int executeUpdate(String sql) {
        Logger.log("GameDatabase.executeUpdate");
        try (Statement stmt = connection.createStatement()) {
            return stmt.executeUpdate(sql);
        } catch (Exception e) {
            return 0;
        }
    }

    public Connection getConnection() {
        Logger.log("GameDatabase.getConnection");
        return connection;
    }

    public boolean isConnected() {
        Logger.log("GameDatabase.isConnected");
        return connection != null;
    }
}
