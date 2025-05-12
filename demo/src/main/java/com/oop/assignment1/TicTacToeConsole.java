package com.oop.assignment1;

import java.util.Scanner;

/**
 * Console UI version of Tic Tac Toe.
 */
public class TicTacToeConsole {
    private TicTacToeModel model;
    private Scanner scanner;

    public TicTacToeConsole() {
        model = new TicTacToeModel();
        scanner = new Scanner(System.in);
    }

    public void startGame() {
        System.out.println("Tic tac toe!");
        while (true) {
            printBoard();
            System.out.println("Player " + model.getCurrentPlayer() + "'s turn");
            int row = getInput("Choose next marker row (0-2): ");
            int col = getInput("Choose next marker col (0-2): ");

            // method name
            if (!model.makeMove(row, col)) {
                System.out.println("Box already taken, Try again.");
                continue;
            }

            // method name
            if (model.hasPlayerWon()) {
                printBoard();
                System.out.println("Player " + model.getCurrentPlayer() + " Wins!");
                break;
            } else if (model.isBoardFull()) {
                printBoard();
                System.out.println("Both players draw.");
                break;
            }

            // method name
            model.nextTurn();
        }
    }

    private int getInput(String prompt) {
        int input = -1;
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                input = scanner.nextInt();
                if (input >= 0 && input <= 2) {
                    break;
                }
            } else {
                scanner.next(); // discard invalid input
            }
            System.out.println("Invalid input, enter a number between 0 and 2.");
        }
        return input;
    }

    private void printBoard() {
        char[][] board = model.getBoard();
        System.out.println("Board Display:");
        for (int i = 0; i < 3; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print("[" + board[i][j] + "] ");
            }
            System.out.println();
        }
        System.out.println("   0   1   2");
    }

    public static void main(String[] args) {
        TicTacToeConsole game = new TicTacToeConsole();
        game.startGame();
    }
}
