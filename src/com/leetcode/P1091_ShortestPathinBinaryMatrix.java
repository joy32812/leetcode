package com.leetcode;

import java.util.*;

public class P1091_ShortestPathinBinaryMatrix {

    int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

    /**
     * medium
     * BFS, you have 8 directions to go.
     * So dp is not an option
     * @param grid
     * @return
     */
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if (grid[0][0] != 0) return -1;

        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) Arrays.fill(dp[i], Integer.MAX_VALUE);

        dp[0][0] = 1;


        Queue<Integer> Q = new LinkedList<>();
        Q.add(0);
        Set<Integer> inQ = new HashSet<>();
        inQ.add(0);

        while (!Q.isEmpty()) {
            int tp = Q.poll();

            int x = tp / n;
            int y = tp % n;

            for (int k = 0; k < dx.length; k++) {

                int tx = x + dx[k];
                int ty = y + dy[k];
                if (tx < 0 || tx >= m || ty < 0 || ty >= n) continue;
                if (grid[tx][ty] == 1) continue;

                if (dp[tx][ty] > dp[x][y] + 1) {
                    dp[tx][ty] = dp[x][y] + 1;

                    if (!inQ.contains(tx * n + ty)) {
                        inQ.add(tx * n + ty);
                        Q.add(tx * n + ty);
                    }
                }
            }

        }


        return dp[m - 1][n - 1] == Integer.MAX_VALUE ? -1 : dp[m - 1][n - 1];

    }

}
