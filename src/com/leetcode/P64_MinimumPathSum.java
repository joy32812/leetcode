package com.leetcode;

/**
 * Created by xiaoyuan on 28/02/2017.
 * Simple DP
 */
public class P64_MinimumPathSum {

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        if (m == 0) {return 0;}

        int n = grid[0].length;
        if (n == 0) {return 0;}


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int nowAns = Integer.MAX_VALUE;
                if (i > 0 && nowAns > grid[i - 1][j]) {
                    nowAns = grid[i - 1][j];
                }
                if (j > 0 && nowAns > grid[i][j - 1]) {
                    nowAns = grid[i][j - 1];
                }

                if (nowAns != Integer.MAX_VALUE) {
                    grid[i][j] += nowAns;
                }
            }
        }

        return grid[m - 1][n - 1];
    }


    public static void main(String[] args) {

    }

}
