package com.cerp.mvc;

import com.cerp.facade.GameFacade;
import com.cerp.service.EvaluationResult;

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
        view.displayMessage("Level goes here");
    }
}
