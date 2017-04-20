package com.leetcode;

/**
 * Created by xiaoyuan on 20/04/2017.
 */
public class P289_GameofLife {

    private int m, n;
    private int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    private int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

    public void gameOfLife(int[][] board) {
        if (board.length == 0 || board[0].length == 0) {return;}

        m = board.length;
        n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int num = getNum(board, i, j);

                int val = board[i][j] % 10;
                if (val == 1) {
                    if (num < 2) {
                        // die
                    } else if (num >= 2 && num <= 3) {
                        board[i][j] += 10;
                    } else {
                        //die
                    }
                } else {
                    if (num == 3) {
                        board[i][j] += 10;
                    }
                }
            }
        }

        for (int i = 0; i< m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = board[i][j] / 10;
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }


    private int getNum(int[][] board, int x, int y) {
        int cnt = 0;
        for (int i = 0; i < dx.length; i++) {
            int tx = x + dx[i];
            int ty = y + dy[i];

            if (tx < 0 || tx >= m || ty < 0 || ty >= n) {continue;}

            int val = board[tx][ty] % 10;

            if (val == 1) {
                cnt ++;
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        new P289_GameofLife().gameOfLife(new int[][]{
                {1, 1},
                {1, 1}
        });
    }

}
