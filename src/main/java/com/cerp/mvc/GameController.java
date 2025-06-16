package com.cerp.mvc;

import com.cerp.facade.GameFacade;
import com.cerp.service.EvaluationResult;
import com.cerp.model.Level;

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

    public void handleQuery(String query) {
        EvaluationResult result = facade.processQuery(query);
        view.displayMessage(result.getFeedback());
    }

    public void showLevel() {
        Level level = facade.loadLevel(1);
        if (level != null) {
            view.showLevel(level);
        } else {
            view.displayMessage("Level goes here");
        }
    }
}
