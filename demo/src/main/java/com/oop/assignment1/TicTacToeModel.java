package com.oop.assignment1;

/**
 * Main bit of Tic Tac Toe
 */
public class TicTacToeModel {
    private char[][] board;
    private char currentPlayer;

    // Emoji Markers (windows terminal didnt like unicode so fellback to generic X and O </3)
    private static final char PLAYER_X = 'X'; // X
    private static final char PLAYER_O = 'O'; // O

    // Starts the game
    public TicTacToeModel() {
        board = new char[3][3];
        resetBoard();
    }

    // Returns whos currently playing
    public char getCurrentPlayer() {
        return currentPlayer;
    }

    // Sends back a copy of the board
    public char[][] getBoard() {
        char[][] copy = new char[3][3];
        for (int r = 0; r < 3; r++) {
            System.arraycopy(board[r], 0, copy[r], 0, 3);
        }
        return copy;
    }

    // Places the marker down onto the board or makes the player retry
    public boolean makeMove(int row, int col) {
        if (row < 0 || row > 2 || col < 0 || col > 2) {
            throw new IllegalArgumentException("Pick a spot within the board (0-2).");
        }
        if (board[row][col] != '-') {
            return false;
        }
        board[row][col] = currentPlayer;
        return true;
    }

    // Check if someone has won
    public boolean hasPlayerWon() {
        return checkRows() || checkColumns() || checkDiagonals();
    }

    // Flip to the next player
    public void nextTurn() {
        currentPlayer = (currentPlayer == PLAYER_X) ? PLAYER_O : PLAYER_X;
    }

    // Start a new board
    public void resetBoard() {
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                board[r][c] = '-';
            }
        }
        currentPlayer = PLAYER_X; // X always starts
    }

    // Check the full board, if it's full and there is no winner, it's a draw
    public boolean isBoardFull() {
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                if (board[r][c] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    // --- Win conditions ---

    private boolean checkRows() {
        for (int r = 0; r < 3; r++) {
            if (board[r][0] == currentPlayer &&
                board[r][1] == currentPlayer &&
                board[r][2] == currentPlayer) {
                return true;
            }
        }
        return false;
    }

    private boolean checkColumns() {
        for (int c = 0; c < 3; c++) {
            if (board[0][c] == currentPlayer &&
                board[1][c] == currentPlayer &&
                board[2][c] == currentPlayer) {
                return true;
            }
        }
        return false;
    }

    private boolean checkDiagonals() {
        if (board[0][0] == currentPlayer &&
            board[1][1] == currentPlayer &&
            board[2][2] == currentPlayer) {
            return true;
        }
        if (board[0][2] == currentPlayer &&
            board[1][1] == currentPlayer &&
            board[2][0] == currentPlayer) {
            return true;
        }
        return false;
    }
}
