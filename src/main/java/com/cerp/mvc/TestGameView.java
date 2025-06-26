
package com.cerp.mvc;

import com.cerp.model.Level;
import com.cerp.Logger;

import javax.swing.*;
        import java.awt.*;
        import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.concurrent.CountDownLatch;

/**
 * Simple test implementation of the game view with just input field and button.
 */
public class TestGameView extends GameView {
    private JFrame frame;
    private JTextArea levelArea;
    private JTextField queryField;
    private JButton submitButton;

    // componentes del output
    private JTextArea outputArea;

    private CountDownLatch latch;
    private String userInput;

    public TestGameView() {
        Logger.log("TestGameView.<init>");

        SwingUtilities.invokeLater(() -> {
            frame = new JFrame("Test Game View");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 400);
            frame.setLayout(new BorderLayout());

            // Panel principal con padding
            JPanel mainPanel = new JPanel(new BorderLayout());
            mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
            levelArea = new JTextArea(5, 40);
            levelArea.setEditable(false);

            // Campo de entrada
            queryField = new JTextField();
            queryField.setText("");
            queryField.addFocusListener(new FocusAdapter() {
                private boolean firstFocus = true;
                @Override
                public void focusGained(FocusEvent e) {
                    if (firstFocus) {
                        queryField.setText("");
                        firstFocus = false;
                    }
                }
            });
            queryField.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 14));
            queryField.setPreferredSize(new Dimension(300, 30));

            // Botón de envío
            submitButton = new JButton("Enviar");
            submitButton.setPreferredSize(new Dimension(80, 30));

            // Panel para input y botón
            JPanel inputPanel = new JPanel(new BorderLayout(10, 0));
            inputPanel.add (levelArea, BorderLayout.NORTH);
            inputPanel.add(queryField, BorderLayout.CENTER);
            inputPanel.add(submitButton, BorderLayout.EAST);

            // definimos los componentes y el panel del output
            outputArea = new JTextArea(5, 40);
            outputArea.setEditable(false);

            JPanel outputPanel = new JPanel(new BorderLayout(10,0));
            outputPanel.add(outputArea, BorderLayout.CENTER);

            mainPanel.add(inputPanel, BorderLayout.NORTH);
            mainPanel.add(outputPanel, BorderLayout.CENTER);
            frame.add(mainPanel, BorderLayout.CENTER);

            // Listener para envío
            ActionListener submitAction = e -> {
                if (latch != null) {
                    userInput = queryField.getText();
                    latch.countDown();
                }
            };

            submitButton.addActionListener(submitAction);
            queryField.addActionListener(submitAction); // Enter también envía

            // Mostrar ventana centrada
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);

            // Dar foco al campo de entrada
            //queryField.requestFocusInWindow();

        });

        // Esperar a que la ventana se construya
        try {
            SwingUtilities.invokeAndWait(() -> {
                // Ventana creada
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
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
        queryField.setText("Ingrese su consulta aqui: "); // Limpiar campo anterior
        try {
            latch.await(); // Esperar a que el usuario presione el botón
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        return userInput;
    }

}
