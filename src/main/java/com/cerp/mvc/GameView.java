package com.cerp.mvc;

import com.cerp.model.Level;
import java.util.Scanner;

/**
 * Simple console based view.
 */
public class GameView {
    private Scanner scanner = new Scanner(System.in);

    public void displayMessage(String msg) {
        System.out.println(msg);
    }

    public String getUserQuery() {
        return scanner.nextLine();
    }

    public void showLevel(Level level) {
        displayMessage(level.getTitle());
        displayMessage(level.getNarrative());
        displayMessage(level.getChallenge().getDescription());
    }
}
