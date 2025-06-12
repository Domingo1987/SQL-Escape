package com.cerp.mvc;

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
}
