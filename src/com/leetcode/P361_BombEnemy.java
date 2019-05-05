package com.leetcode;

/**
 * Created by xiaoyuan on 14/05/2017.
 */
public class P361_BombEnemy {

    public int maxKilledEnemies(char[][] grid) {

        if (grid == null || grid.length == 0 || grid[0].length == 0) {return 0;}

        int m = grid.length;
        int n = grid[0].length;

        int ans = 0;
        int[][] dp = new int[m][n];

        // left
        for (int i = 0; i < m; i++) {
            for (int j = 0, num = 0; j < n; j++) {
                dp[i][j] += grid[i][j] == 'W' ? num = 0 : (grid[i][j] == 'E' ? ++ num : num);
            }
        }

        // right
        for (int i = 0; i < m; i++) {
            for (int j = n - 1, num = 0; j >= 0; j--) {
                dp[i][j] += grid[i][j] == 'W' ? num = 0 : (grid[i][j] == 'E' ? ++ num : num);
            }
        }


        // up
        for (int j = 0; j < n; j++) {
            for (int i = 0, num = 0; i < m; i++) {
                dp[i][j] += grid[i][j] == 'W' ? num = 0 : (grid[i][j] == 'E' ? ++ num : num);
            }
        }

        // down
        for (int j = 0; j < n; j++) {
            for (int i = m - 1, num = 0; i >= 0; i--) {
                dp[i][j] += grid[i][j] == 'W' ? num = 0 : (grid[i][j] == 'E' ? ++ num : num);
            }
        }




        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '0') {
                    ans = Math.max(ans, dp[i][j]);
                }
            }
        }

        return ans;
    }



}
