package com.oop.assignment1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TicTacToeModelTest {

    // Fill the cells
    private void fillAndTestWin(TicTacToeModel model, int[][] positions) {
        for (int[] pos : positions) {
            model.makeMove(pos[0], pos[1]);
        }
        assertTrue(model.hasPlayerWon(), "Expected win condition failed.");
    }

    @Test
    public void testRowWinTop() {
        TicTacToeModel model = new TicTacToeModel();
        fillAndTestWin(model, new int[][]{{0, 0}, {0, 1}, {0, 2}});
    }

    @Test
    public void testRowWinMiddle() {
        TicTacToeModel model = new TicTacToeModel();
        fillAndTestWin(model, new int[][]{{1, 0}, {1, 1}, {1, 2}});
    }

    @Test
    public void testRowWinBottom() {
        TicTacToeModel model = new TicTacToeModel();
        fillAndTestWin(model, new int[][]{{2, 0}, {2, 1}, {2, 2}});
    }

    @Test
    public void testColWinLeft() {
        TicTacToeModel model = new TicTacToeModel();
        fillAndTestWin(model, new int[][]{{0, 0}, {1, 0}, {2, 0}});
    }

    @Test
    public void testColWinMiddle() {
        TicTacToeModel model = new TicTacToeModel();
        fillAndTestWin(model, new int[][]{{0, 1}, {1, 1}, {2, 1}});
    }

    @Test
    public void testColWinRight() {
        TicTacToeModel model = new TicTacToeModel();
        fillAndTestWin(model, new int[][]{{0, 2}, {1, 2}, {2, 2}});
    }

    @Test
    public void testDiagWinLeftToRight() {
        TicTacToeModel model = new TicTacToeModel();
        fillAndTestWin(model, new int[][]{{0, 0}, {1, 1}, {2, 2}});
    }

    @Test
    public void testDiagWinRightToLeft() {
        TicTacToeModel model = new TicTacToeModel();
        fillAndTestWin(model, new int[][]{{0, 2}, {1, 1}, {2, 0}});
    }
}
