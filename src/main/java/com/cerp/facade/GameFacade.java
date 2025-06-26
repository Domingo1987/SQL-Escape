package com.cerp.facade;

import com.cerp.SqlEscapeGame;
import com.cerp.Logger;
import com.cerp.db.PlayerDAO;
import com.cerp.db.ProgressDAO;
import com.cerp.db.LevelDAO;
import com.cerp.db.ConsultasDAO;
import com.cerp.model.Level;
import com.cerp.service.EvaluationResult;

import java.sql.SQLException;

/**
 * Facade that exposes high level operations for the controllers.
 */
public class GameFacade {
    private SqlEscapeGame game;
    private PlayerDAO playerDAO;
    private ProgressDAO progressDAO;
    private LevelDAO levelDAO;
    private ConsultasDAO consultasDAO;

    public GameFacade(SqlEscapeGame game, PlayerDAO playerDAO, ProgressDAO progressDAO,
                      LevelDAO levelDAO, ConsultasDAO consultasDAO) {
        this.game = game;
        this.playerDAO = playerDAO;
        this.progressDAO = progressDAO;
        this.levelDAO = levelDAO;
        this.consultasDAO = consultasDAO;
    }

    public void startGame() {
        Logger.log("GameFacade.startGame");
        game.startGame();
    }

    public void loadPlayer(int id) {
        Logger.log("GameFacade.loadPlayer");
        game.loadGame(id);
    }

    public EvaluationResult processQuery(String query) throws SQLException {
        Logger.log("GameFacade.processQuery");
        return game.processPlayerInput(query);
    }

    public Level loadLevel(int number) {
        Logger.log("GameFacade.loadLevel");
        Level level = levelDAO.findByNumber(number);

        if (level != null) {
            Logger.log("Nivel cargado exitosamente: " + level.getTitle());
            Logger.log("Challenge: " + level.getChallenge().getDescription());
            Logger.log("Consulta esperada: " + level.getChallenge().getExpectedQuery());
            game.setCurrentLevel(level);
        } else {
            Logger.logError("No se pudo cargar el nivel " + number);
        }

        return level;
    }
}