package com.cerp.mvc;

import com.cerp.model.Level;

import javax.swing.*;
import java.awt.*;
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

    public SwingGameView() {
        frame = new JFrame("SQL Escape");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLayout(new BorderLayout());

        levelArea = new JTextArea();
        levelArea.setEditable(false);
        frame.add(new JScrollPane(levelArea), BorderLayout.NORTH);

        JPanel inputPanel = new JPanel(new BorderLayout());
        queryField = new JTextField();
        submitButton = new JButton("Enviar");
        inputPanel.add(queryField, BorderLayout.CENTER);
        inputPanel.add(submitButton, BorderLayout.EAST);
        frame.add(inputPanel, BorderLayout.CENTER);

        outputArea = new JTextArea();
        outputArea.setEditable(false);
        frame.add(new JScrollPane(outputArea), BorderLayout.SOUTH);
    }

    @Override
    public void displayMessage(String msg) {
        outputArea.setText(msg);
    }

    @Override
    public void showLevel(Level level) {
        StringBuilder sb = new StringBuilder();
        sb.append("Nivel ").append(level.getNumber()).append(" - ")
          .append(level.getTitle()).append("\n\n")
          .append(level.getNarrative()).append("\n\n")
          .append(level.getChallenge().getDescription());
        levelArea.setText(sb.toString());
        frame.setVisible(true);
    }

    @Override
    public String getUserQuery() {
        CountDownLatch latch = new CountDownLatch(1);
        final String[] result = new String[1];
        submitButton.addActionListener(e -> {
            result[0] = queryField.getText();
            latch.countDown();
        });
        try {
            latch.await();
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        return result[0];
    }
}
