package com.cerp.mvc;

import com.cerp.facade.GameFacade;
import com.cerp.service.EvaluationResult;
import com.cerp.model.Level;
import com.cerp.Logger;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.List;

/**
 * Controller part of the MVC architecture.
 */
public class GameController {
    private GameFacade facade;
    private GameView view;

    public GameController(GameFacade facade, GameView view) {
        this.facade = facade;
        this.view = view;
    }


    public void handleQuery(String query) throws SQLException {
        Logger.log(query);
        EvaluationResult result = facade.processQuery(query);
        view.showOutput (facade.getGame().getCurrentLevel(), result);
        Logger.logGreen(facade.getGame().getCurrentLevel().getFeedback());

    }



    public void showLevel() {
        Logger.log("GameController.showLevel");
        Level level = facade.loadLevel(1);
        if (level != null) {
            view.showLevel(level);
        } else {
            view.displayMessage("Level goes here");
        }
    }
}
