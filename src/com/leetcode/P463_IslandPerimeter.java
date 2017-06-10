package com.leetcode;

/**
 * Created by xiaoyuan on 10/06/2017.
 */
public class P463_IslandPerimeter {

    private int m, n;
    public int islandPerimeter(int[][] grid) {

        m = grid.length;
        n = grid[0].length;

        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {continue;}

                ans += count(grid, i, j);
            }
        }

        return ans;
    }

    int[] dx = {0, 0, 1, -1};
    int[] dy = {-1, 1, 0, 0};
    private int count(int[][] grid, int x, int y) {
        int res = 0;

        for (int i = 0; i < dx.length; i++) {
            int tx = x + dx[i];
            int ty = y + dy[i];

            if (tx < 0 || tx >= m || ty < 0 || ty >= n) {
                res ++;
                continue;
            }

            if (grid[tx][ty] == 0) {
                res++;
            }
        }

        return res;
    }

}
