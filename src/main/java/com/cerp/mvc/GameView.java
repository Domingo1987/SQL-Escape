package com.cerp.mvc;

import com.cerp.model.Level;
import java.util.Scanner;
import com.cerp.Logger;
import com.cerp.service.EvaluationResult;

/**
 * Simple console based view.
 */
public class GameView {
    private Scanner scanner = new Scanner(System.in);

    public void displayMessage(String msg) {
        Logger.log("GameView.displayMessage");
        System.out.println(msg);
    }

    public String getUserQuery() {
        Logger.log("GameView.getUserQuery");
        return scanner.nextLine();
    }

    public void showLevel(Level level) {
        Logger.log("GameView.showLevel");
        displayMessage(level.getTitle());
        displayMessage(level.getNarrative());
        displayMessage(level.getChallenge().getDescription());
    }
    public void showOutput (Level level, EvaluationResult result){

        displayMessage("Resultado: "+ result.getQueryResult().getResult() +"\n"+ level.getFeedback());
    }
}
