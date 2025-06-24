package com.cerp.mvc;

import com.cerp.model.Level;
import com.cerp.Logger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.concurrent.CountDownLatch;

/**
 * Swing based implementation of the game view.
 */
public class SwingGameView extends GameView {
    private JFrame frame;
    private JTextArea levelArea;
    private JTextField queryField;
    private JTextArea outputArea;
    private JButton submitButton;

    private CountDownLatch latch;
    private String userQuery;

    public SwingGameView() {
        Logger.log("SwingGameView.<init>");

        frame = new JFrame("SQL Escape");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout());

        levelArea = new JTextArea(5, 40);
        levelArea.setEditable(false);
        frame.add(new JScrollPane(levelArea), BorderLayout.NORTH);

        JPanel inputPanel = new JPanel(new BorderLayout());
        queryField = new JTextField();
        submitButton = new JButton("Enviar");
        inputPanel.add(queryField, BorderLayout.CENTER);
        inputPanel.add(submitButton, BorderLayout.EAST);
        frame.add(inputPanel, BorderLayout.CENTER);

        outputArea = new JTextArea(5, 40);
        outputArea.setEditable(false);
        frame.add(new JScrollPane(outputArea), BorderLayout.SOUTH);

        // Mostrar ventana
        frame.setVisible(true);

        // Agregamos el listener una sola vez
        submitButton.addActionListener(e -> {
            if (latch != null) {
                userQuery = queryField.getText();
                latch.countDown();
            }
        });
    }

    @Override
    public void displayMessage(String msg) {
        Logger.log("SwingGameView.displayMessage");
        outputArea.setText(msg);
    }

    @Override
    public void showLevel(Level level) {
        Logger.log("SwingGameView.showLevel");
        StringBuilder sb = new StringBuilder();
        sb.append("Nivel ").append(level.getNumber()).append(" - ")
                .append(level.getTitle()).append("\n\n")
                .append(level.getNarrative()).append("\n\n")
                .append(level.getChallenge().getDescription());
        levelArea.setText(sb.toString());
    }

    @Override
    public String getUserQuery() {
        Logger.log("SwingGameView.getUserQuery");
        latch = new CountDownLatch(1);
        queryField.setText(""); // Limpiar campo anterior
        try {
            latch.await(); // Esperar a que el usuario presione el botón
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        return userQuery;
    }
}
