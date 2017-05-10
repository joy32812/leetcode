package com.leetcode;

/**
 * Created by xiaoyuan on 10/05/2017.
 */
public class P348_DesignTicTacToe {

    private int[][] grid;

    /** Initialize your data structure here. */
    public P348_DesignTicTacToe(int n) {
        grid = new int[n][n];
    }

    /** Player {player} makes a move at ({row}, {col}).
     @param row The row of the board.
     @param col The column of the board.
     @param player The player, can be either 1 or 2.
     @return The current winning condition, can be either:
     0: No one wins.
     1: Player 1 wins.
     2: Player 2 wins. */
    public int move(int row, int col, int player) {
        grid[row][col] = player;

        // check col
        boolean win = true;
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][col] != player) {
                win = false;
                break;
            }
        }
        if (win) {return player;}


        // check row
        win = true;
        for (int i = 0; i < grid.length; i++) {
            if (grid[row][i] != player) {
                win = false;
                break;
            }
        }
        if (win) {return player;}

        // check diagonal
        if (row == col) {
            win = true;
            for (int i = 0; i < grid.length; i++) {
                if (grid[i][i] != player) {
                    win = false;
                    break;
                }
            }
            if (win) {return player;}
        }

        if (row + col == grid.length - 1) {
            win = true;
            for (int i = 0; i < grid.length; i++) {
                if (grid[i][grid.length - 1 - i] != player) {
                    win = false;
                    break;
                }
            }
            if (win) {return player;}
        }

        return 0;
    }

}
