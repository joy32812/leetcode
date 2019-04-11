package com.leetcode;

import java.util.*;

public class P909_SnakesandLadders {


    /**
     * medium
     * BFS
     * careful: the order and direction
     * @param board
     * @return
     */
    public int snakesAndLadders(int[][] board) {

        int m = board.length;
        int n = board[0].length;


        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) Arrays.fill(dp[i], Integer.MAX_VALUE);

        dp[m - 1][0] = 0;
        Queue<Integer> Q = new LinkedList<>();
        Q.add((m - 1) * n + 0);

        Set<Integer> inQ = new HashSet<>();
        inQ.add((m - 1) * n + 0);

        while (!Q.isEmpty()) {
            int now = Q.poll();
            inQ.remove(now);

            int x = now / n;
            int y = now % n;

            int tx = x;
            int ty = y;

            for (int i = 0; i < 6; i++) {
                if ((m - tx) % 2 == 1) ty ++;
                else ty --;

                if (ty <0 || ty >= n) {
                    tx --;

                    if ((m - tx) % 2 == 1) ty = 0;
                    else ty = n - 1;
                }

                if (tx < 0 || tx >= m || ty < 0 || ty >= n) break;

                int nx = tx;
                int ny = ty;

                if (board[tx][ty] != -1) {
                    int[] pos = getPos(m, n, board[tx][ty]);

                    nx = pos[0];
                    ny = pos[1];
                }

                if (dp[nx][ny] > dp[x][y] + 1) {
                    dp[nx][ny] = dp[x][y] + 1;

                    int val = nx * n + ny;
                    if (!inQ.contains(val)) {
                        Q.add(val);
                        inQ.add(val);
                    }
                }
            }
        }


        int ax = 0;
        int ay = 0;
        if (m % 2 == 1) ay = n - 1;

        return dp[ax][ay] != Integer.MAX_VALUE ? dp[ax][ay] : -1;
    }

    private int[] getPos(int m, int n, int num) {
        int line = (num - 1) / n + 1;
        int x = m - line;

        int col = (num - 1) % n;
        int y = col;
        if (line % 2 == 0) y = n - 1 - y;

        return new int[]{x, y};
    }

    public static void main(String[] args) {
        System.out.println(new P909_SnakesandLadders().snakesAndLadders(new int[][]{
                {-1, 4, -1},
                {6, 2, 6},
                {-1, 3, -1}
        }));
    }


}
