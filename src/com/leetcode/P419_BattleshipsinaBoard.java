package com.leetcode;

/**
 * Created by xiaoyuan on 03/06/2017.
 */
public class P419_BattleshipsinaBoard {

    public int countBattleships(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {return 0;}

        int ans = 0;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                char ch = board[i][j];
                if (ch == '.') {continue;}
                if (i - 1 >= 0 && board[i - 1][j] == ch) {continue;}
                if (j - 1 >= 0 && board[i][j - 1] == ch) {continue;}
                ans++;
            }
        }

        return ans;
    }

}
