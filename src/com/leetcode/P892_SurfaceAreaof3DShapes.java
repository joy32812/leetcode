package com.leetcode;

public class P892_SurfaceAreaof3DShapes {

    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    public int surfaceArea(int[][] grid) {
        int n = grid.length;

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int v = grid[i][j];
                if (v == 0) continue;

                ans += 4 * v + 2;

                for (int k = 0; k < dx.length; k++) {
                    int x = i + dx[k];
                    int y = j + dy[k];
                    if (x < 0 || x >= n || y < 0 || y >= n || grid[x][y] == 0) continue;
                    ans -= Math.min(grid[x][y], v);
                }
            }
        }

        return ans;
    }


}
