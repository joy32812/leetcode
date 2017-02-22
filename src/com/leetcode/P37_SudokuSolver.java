package com.leetcode;

/**
 * Created by xiaoyuan on 22/02/2017.
 * 暴力搜索
 * 应该可以进行一些优化, 比如先从选择少的空填起
 */
public class P37_SudokuSolver {

    public boolean okay(char[][] board, int x, int y, int val) {
        // row
        for (int i = 0; i < 9; i++) {
            if (i != y && board[x][i] != '.' && Integer.parseInt("" +board[x][i]) == val) {
                return false;
            }
        }

        // col
        for (int i = 0; i < 9; i++) {
            if (i != x && board[i][y] != '.' && Integer.parseInt("" + board[i][y]) == val) {
                return false;
            }
        }

        int px = (x / 3) * 3;
        int py = (y / 3) * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int nx = px + i;
                int ny = py + j;

                if (nx != x && ny != y && board[nx][ny] != '.' && Integer.parseInt("" + board[nx][ny]) == val) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean dfs(char[][] board, int level) {
        if (level >= 81) {
            return true;
        }
        int x = level / 9, y = level % 9;

        if (board[x][y] == '.') {
            for (int i = 1; i <= 9; i++) {
                if (okay(board, x, y, i)) {
                    board[x][y] = Character.forDigit(i, 10);
                    if (dfs(board, level + 1)) {
                        return true;
                    }
                    board[x][y] = '.';
                }
            }
        } else {
            return dfs(board, level + 1);
        }

        return false;
    }

    public void solveSudoku(char[][] board) {
        dfs(board, 0);
    }

    public static void main(String[] args) {

        char[][] board = {
                "..9748...".toCharArray(),
                "7........".toCharArray(),
                ".2.1.9...".toCharArray(),
                "..7...24.".toCharArray(),
                ".64.1.59.".toCharArray(),
                ".98...3..".toCharArray(),
                "...8.3.2.".toCharArray(),
                "........6".toCharArray(),
                "...2759..".toCharArray()
        };

        new P37_SudokuSolver().solveSudoku(board);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

}
