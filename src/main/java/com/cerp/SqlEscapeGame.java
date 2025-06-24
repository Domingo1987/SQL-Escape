package com.cerp;

import com.cerp.db.GameDatabase;
import com.cerp.model.Level;
import com.cerp.model.Player;
import com.cerp.service.EvaluationResult;
import com.cerp.service.SqlEvaluator;
import com.cerp.state.GameState;
import com.cerp.state.StartState;
import com.cerp.Logger;

/**
 * Core game class orchestrating players, levels and states.
 */
public class SqlEscapeGame {
    private Player currentPlayer;
    private Level currentLevel;
    private GameState gameState = new StartState();
    private GameDatabase database;
    private SqlEvaluator sqlEvaluator;

    public SqlEscapeGame(GameDatabase db) {
        Logger.log("SqlEscapeGame.<init>");
        this.database = db;
        this.sqlEvaluator = new SqlEvaluator(db.getConnection());
    }

    public void startGame() {
        Logger.log("SqlEscapeGame.startGame");
        gameState.start();
    }

    public void loadGame(int playerId) {
        Logger.log("SqlEscapeGame.loadGame");
        // load player from persistence
    }

    public void restartGame() {
        Logger.log("SqlEscapeGame.restartGame");
        // reset progress
    }

    public Level getCurrentLevel() {
        Logger.log("SqlEscapeGame.getCurrentLevel");
        return currentLevel;
    }

    public void setCurrentLevel(Level level) {
        Logger.log("SqlEscapeGame.setCurrentLevel");
        this.currentLevel = level;
    }

    public EvaluationResult processPlayerInput(String query) {
        Logger.log("SqlEscapeGame.processPlayerInput");
        // Evaluate query
        return sqlEvaluator.evaluateChallenge(query, currentLevel.getChallenge());
    }

    public boolean saveProgress() {
        Logger.log("SqlEscapeGame.saveProgress");
        return true;
    }

    public void exitGame() {
        Logger.log("SqlEscapeGame.exitGame");
        gameState.end();
        database.disconnect();
    }
}
