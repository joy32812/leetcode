package com.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class P1034_ColoringABorder {

    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};

    /**
     * BFS
     * clarify the problem!!!!
     * @param grid
     * @param r0
     * @param c0
     * @param color
     * @return
     */
    public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
        int m = grid.length;
        int n = grid[0].length;

        int now = grid[r0][c0];
        Queue<Integer> Q = new LinkedList<>();
        Q.add(r0 * n + c0);

        Set<Integer> inQ = new HashSet<>();
        inQ.add(r0 * n + c0);

        while (!Q.isEmpty()) {
            int tp = Q.poll();
            int x = tp / n;
            int y = tp % n;

            for (int k = 0; k < dx.length; k ++) {
                int tx = x + dx[k];
                int ty = y + dy[k];

                if (tx < 0 || tx >= m || ty < 0 || ty >= n || grid[tx][ty] != now) continue;
                if (!inQ.contains(tx * n + ty)) {
                    inQ.add(tx * n + ty);
                    Q.add(tx * n + ty);
                }
            }
        }

        int[][] ans = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) ans[i][j] = grid[i][j];
        }

        for (int tp : inQ) {
            int x = tp / n;
            int y = tp % n;

            boolean okay = false;
            for (int k = 0; k < dx.length; k ++) {
                int tx = x + dx[k];
                int ty = y + dy[k];

                if (tx < 0 || tx >= m || ty < 0 || ty >= n || grid[tx][ty] != now) {
                    okay = true;
                    break;
                }
            }

            if (okay) ans[x][y] = color;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new P1034_ColoringABorder().colorBorder(new int[][]{
                {1, 1, 1},
                {1, 1, 1}
        }, 1, 1, 3));
    }

}
