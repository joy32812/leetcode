package com.leetcode;

/**
 * Created by xiaoyuan on 28/02/2017.
 *
 * Simple DP
 */
public class P62_UniquePaths {

    public int uniquePaths(int m, int n) {

        int[][] dp = new int[m + 1][n + 1];
        for (int j = 0; j <= n; j++) {dp[0][j] = 1;}
        for (int i = 0; i <= m; i++) {dp[i][0] = 1;}

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        System.out.println(new P62_UniquePaths().uniquePaths(1, 2));
    }

}
