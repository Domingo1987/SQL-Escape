package com.cerp.facade;

import com.cerp.SqlEscapeGame;
import com.cerp.Logger;
import com.cerp.db.PlayerDAO;
import com.cerp.db.ProgressDAO;
import com.cerp.db.LevelDAO;
import com.cerp.model.Level;
import com.cerp.service.EvaluationResult;

/**
 * Facade that exposes high level operations for the controllers.
 */
public class GameFacade {
    private SqlEscapeGame game;
    private PlayerDAO playerDAO;
    private ProgressDAO progressDAO;
    private LevelDAO levelDAO;

    public GameFacade(SqlEscapeGame game, PlayerDAO playerDAO, ProgressDAO progressDAO, LevelDAO levelDAO) {
        this.game = game;
        this.playerDAO = playerDAO;
        this.progressDAO = progressDAO;
        this.levelDAO = levelDAO;
    }

    public void startGame() {
        Logger.log("GameFacade.startGame");
        game.startGame();
    }

    public void loadPlayer(int id) {
        Logger.log("GameFacade.loadPlayer");
        game.loadGame(id);
    }

    public EvaluationResult processQuery(String query) {
        Logger.log("GameFacade.processQuery");
        return game.processPlayerInput(query);
    }

    public Level loadLevel(int number) {
        Logger.log("GameFacade.loadLevel");
        Level level = levelDAO.findByNumber(number);
        Logger.log("TEST"+ level.toString());
        if (level != null) {
            game.setCurrentLevel(level);
        }
        return level;
    }
}
