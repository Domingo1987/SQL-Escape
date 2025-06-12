package com.cerp;

import com.cerp.db.GameDatabase;
import com.cerp.model.Level;
import com.cerp.model.Player;
import com.cerp.service.EvaluationResult;
import com.cerp.service.SqlEvaluator;
import com.cerp.state.GameState;
import com.cerp.state.StartState;

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
        this.database = db;
        this.sqlEvaluator = new SqlEvaluator(db.getConnection());
    }

    public void startGame() {
        gameState.start();
    }

    public void loadGame(int playerId) {
        // load player from persistence
    }

    public void restartGame() {
        // reset progress
    }

    public Level getCurrentLevel() {
        return currentLevel;
    }

    public EvaluationResult processPlayerInput(String query) {
        // Evaluate query
        return sqlEvaluator.evaluateChallenge(query, currentLevel.getChallenge());
    }

    public boolean saveProgress() {
        return true;
    }

    public void exitGame() {
        gameState.end();
        database.disconnect();
    }
}
