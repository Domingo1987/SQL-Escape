package com.cerp.sqlescape.facade;

import com.cerp.sqlescape.SqlEscapeGame;
import com.cerp.sqlescape.db.PlayerDAO;
import com.cerp.sqlescape.db.ProgressDAO;
import com.cerp.sqlescape.service.EvaluationResult;

/**
 * Facade that exposes high level operations for the controllers.
 */
public class GameFacade {
    private SqlEscapeGame game;
    private PlayerDAO playerDAO;
    private ProgressDAO progressDAO;

    public GameFacade(SqlEscapeGame game, PlayerDAO playerDAO, ProgressDAO progressDAO) {
        this.game = game;
        this.playerDAO = playerDAO;
        this.progressDAO = progressDAO;
    }

    public void startGame() {
        game.startGame();
    }

    public void loadPlayer(int id) {
        game.loadGame(id);
    }

    public EvaluationResult processQuery(String query) {
        return game.processPlayerInput(query);
    }
}
