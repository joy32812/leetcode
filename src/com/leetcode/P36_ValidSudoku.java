package com.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by xiaoyuan on 22/02/2017.
 */
public class P36_ValidSudoku {

    private final int ROW_NUM = 9;
    private final int COL_NUM = 9;

    public boolean checkSquare(char[][] board, int x, int y) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[x + i][y + j] == '.') {
                    continue;
                }
                int val = Integer.parseInt("" + board[x + i][y + j]);
                if (val <= 0 || val > 9 || set.contains(val)) {
                    return false;
                }
                set.add(val);
            }
        }
        return true;
    }

    public boolean checkColumn(char[][] board, int col) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < ROW_NUM; i++) {
            if (board[i][col] == '.') {
                continue;
            }
            int val = Integer.parseInt("" + board[i][col]);
            if (val <= 0 || val > 9 || set.contains(val)) {
                return false;
            }
            set.add(val);
        }
        return true;
    }

    public boolean checkRow(char[][] board, int row) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < COL_NUM; i++) {
            if (board[row][i] == '.') {
                continue;
            }
            int val = Integer.parseInt("" + board[row][i]);
            if (val <= 0 || val > 9 || set.contains(val)) {
                return false;
            }
            set.add(val);
        }

        return true;
    }

    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < ROW_NUM; i++) {
            if (!checkRow(board, i)) {
                return false;
            }
        }
        for (int i = 0; i < COL_NUM; i++) {
            if (!checkColumn(board, i)) {
                return false;
            }
        }
        for (int i = 0; i < ROW_NUM; i+=3) {
            for (int j = 0; j < COL_NUM; j+=3) {
                if (!checkSquare(board, i, j)) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        // too lazy for test
    }

}
