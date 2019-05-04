package com.leetcode;

public class P883_ProjectionAreaof3DShapes {

    public int projectionArea(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int n = grid.length;

        int ans = 0;
        for (int i = 0; i < n; i++) {
            int maxR = 0;
            int maxC = 0;

            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0) ans ++;
                maxR = Math.max(maxR, grid[i][j]);
                maxC = Math.max(maxC, grid[j][i]);
            }
            ans += maxR;
            ans += maxC;
        }

        return ans;
    }

}
