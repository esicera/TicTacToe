package com.oop.assignment1;

import javax.swing.*;
import java.awt.*;

/**
 * GUI vers of Tic Tac Toe
 */

public class TicTacToeView extends JFrame {
    private JButton[][] boardButtons;
    private JLabel messageLabel;
    private JButton restartButton;
    private TicTacToeModel model;

    public TicTacToeView() {
        model = new TicTacToeModel();

        setTitle("Tic Tac Toe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        messageLabel = new JLabel("Player " + model.getCurrentPlayer() + "'s turn", SwingConstants.CENTER);
        add(messageLabel, BorderLayout.NORTH);

        JPanel boardPanel = new JPanel(new GridLayout(3, 3));
        boardButtons = new JButton[3][3];

        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                JButton button = new JButton("");
                button.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 50));
                int finalR = r;
                int finalC = c;

                button.addActionListener(e -> handleMove(finalR, finalC, button));
                boardButtons[r][c] = button;
                boardPanel.add(button);
            }
        }

        add(boardPanel, BorderLayout.CENTER);

        // Restart button at bottom!
        restartButton = new JButton("Restart Game");
        restartButton.addActionListener(e -> resetGame());
        add(restartButton, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void handleMove(int row, int col, JButton button) {
        if (model.makeMove(row, col)) {
            button.setText(String.valueOf(model.getCurrentPlayer()));
            button.setEnabled(false);

            if (model.hasPlayerWon()) {
                messageLabel.setText("Player " + model.getCurrentPlayer() + " wins! 🎉");
                disableAllButtons();
            } else if (model.isBoardFull()) {
                messageLabel.setText("Its a draw!");
                disableAllButtons();
            } else {
                model.nextTurn();
                messageLabel.setText("Player " + model.getCurrentPlayer() + "'s turn");
            }
        }
    }

    private void disableAllButtons() {
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                boardButtons[r][c].setEnabled(false);
            }
        }
    }

    private void resetGame() {
        model.resetBoard();
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                boardButtons[r][c].setText("");
                boardButtons[r][c].setEnabled(true);
            }
        }
        messageLabel.setText("New game! Player " + model.getCurrentPlayer() + "'s turn!");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TicTacToeView());
    }
}
