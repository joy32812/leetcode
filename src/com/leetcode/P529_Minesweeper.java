package com.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by xiaoyuan on 05/07/2017.
 */
public class P529_Minesweeper {

    int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
    public char[][] updateBoard(char[][] board, int[] click) {

        int x = click[0];
        int y = click[1];
        if (board[x][y] == 'M') {
            board[x][y] = 'X';
            return board;
        }

        int m = board.length;
        int n = board[0].length;

        Queue<Integer> Q = new LinkedList<>();
        Set<Integer> inQ = new HashSet<>();
        Q.add(x * n + y);

        while (!Q.isEmpty()) {
            int tp = Q.poll();
            x = tp / n;
            y = tp % n;

            int mineNum = getMineNumber(board, x, y);
            if (mineNum > 0) {
                board[x][y] = (char)('0' + mineNum);
                continue;
            }

            board[x][y] = 'B';
            for (int i = 0; i < dx.length; i++) {
                int tx = x + dx[i];
                int ty = y + dy[i];

                if (tx < 0 || tx >= m || ty < 0 || ty >= n) {continue;}
                int now = tx * n + ty;
                if (inQ.contains(now)) {continue;}

                Q.add(now);
                inQ.add(now);
            }
        }

        return board;
    }


    private int getMineNumber(char[][] board, int x, int y) {
        int total = 0;
        for (int i = 0; i < dx.length; i++) {
            int tx = x + dx[i];
            int ty = y + dy[i];

            if (tx >= 0 && tx < board.length && ty >= 0 && ty < board[0].length && board[tx][ty] == 'M') {
                total++;
            }
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println(new P529_Minesweeper().updateBoard(
                new char[][] {
                        "EEEEE".toCharArray(),
                        "EEMEE".toCharArray(),
                        "EEEEE".toCharArray(),
                        "EEEEE".toCharArray(),
                },
                new int[]{3, 0}
        ));
    }

}
