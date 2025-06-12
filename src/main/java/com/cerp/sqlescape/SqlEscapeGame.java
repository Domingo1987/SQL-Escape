package com.cerp.sqlescape;

import com.cerp.sqlescape.db.GameDatabase;
import com.cerp.sqlescape.model.Level;
import com.cerp.sqlescape.model.Player;
import com.cerp.sqlescape.service.EvaluationResult;
import com.cerp.sqlescape.service.SqlEvaluator;
import com.cerp.sqlescape.service.QueryResult;
import com.cerp.sqlescape.state.GameState;
import com.cerp.sqlescape.state.StartState;

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
