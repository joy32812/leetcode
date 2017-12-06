package com.leetcode;

/**
 * Created by xiaoyuan on 06/12/2017.
 */
public class P741_CherryPickup {

    public int cherryPickup(int[][] grid) {

        int n = grid.length;
        int[][][] dp = new int[n][n][n];

        // init
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        dp[0][0][0] = grid[0][0];


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (i == 0 && j == 0) continue;
                    int z = i + j - k;
                    if (z < 0 || z >= n) continue;
                    if (grid[i][j] == -1 || grid[k][z] == -1) continue;

                    int total = -1;

                    int ni = i - 1;
                    int nj = j;
                    int nk = k - 1;
                    int nz = z;
                    if (ni >= 0 && nj >=0 && nk >= 0 && nz >= 0 && grid[ni][nj] != -1 && grid[nk][nz] != -1 && dp[ni][nj][nk] != -1) {
                        total = Math.max(total, dp[ni][nj][nk] + grid[i][j] + grid[k][z] + (i == k && grid[i][j] == 1 ? -1 : 0));
                    }


                    ni = i - 1;
                    nj = j;
                    nk = k;
                    nz = z - 1;
                    if (ni >= 0 && nj >=0 && nk >= 0 && nz >= 0 && grid[ni][nj] != -1 && grid[nk][nz] != -1 && dp[ni][nj][nk] != -1) {
                        total = Math.max(total, dp[ni][nj][nk] + grid[i][j] + grid[k][z] + (i == k && grid[i][j] == 1 ? -1 : 0));
                    }

                    ni = i;
                    nj = j - 1;
                    nk = k - 1;
                    nz = z;
                    if (ni >= 0 && nj >=0 && nk >= 0 && nz >= 0 && grid[ni][nj] != -1 && grid[nk][nz] != -1 && dp[ni][nj][nk] != -1) {
                        total = Math.max(total, dp[ni][nj][nk] + grid[i][j] + grid[k][z] + (i == k && grid[i][j] == 1 ? -1 : 0));
                    }

                    ni = i;
                    nj = j - 1;
                    nk = k;
                    nz = z - 1;
                    if (ni >= 0 && nj >=0 && nk >= 0 && nz >= 0 && grid[ni][nj] != -1 && grid[nk][nz] != -1 && dp[ni][nj][nk] != -1) {
                        total = Math.max(total, dp[ni][nj][nk] + grid[i][j] + grid[k][z] + (i == k && grid[i][j] == 1 ? -1 : 0));
                    }

                    dp[i][j][k] = total;
                }
            }
        }

        return dp[n - 1][n - 1][n - 1] == -1 ? 0 : dp[n - 1][n - 1][n - 1];
    }

    public static void main(String[] args) {

        System.out.println(new P741_CherryPickup().cherryPickup(new int[][]{
                {0, 1, -1},
                {1, 0, -1},
                {1, 1, 1},
        }));

    }

}
