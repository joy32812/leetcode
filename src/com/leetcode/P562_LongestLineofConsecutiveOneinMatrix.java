package com.leetcode;

/**
 * Created by xiaoyuan on 30/06/2017.
 */
public class P562_LongestLineofConsecutiveOneinMatrix {

    public int longestLine(int[][] M) {
        if (M == null || M.length == 0) return 0;

        int ans = 0;

        int m = M.length;
        int n = M[0].length;
        int[][][] dp = new int[m][n][4];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (M[i][j] == 0) continue;
                dp[i][j][0] = dp[i][j][1] = dp[i][j][2] = dp[i][j][3] = 1;

                if (j - 1 >= 0) dp[i][j][0] += dp[i][j - 1][0];
                if (i - 1 >= 0) dp[i][j][1] += dp[i - 1][j][1];
                if (i - 1 >= 0 && j - 1 >= 0) dp[i][j][2] += dp[i - 1][j - 1][2];
                if (i - 1 >= 0 && j + 1 < n) dp[i][j][3] += dp[i - 1][j + 1][3];

                for (int k = 0; k < 4; k++) ans = Math.max(ans, dp[i][j][k]);
            }
        }


        return ans;
    }

    public static void main(String[] args) {
        int[][] grid =
        {
                {1,1,0,0,1,0,0,1,1,0},
                {1,0,0,1,0,1,1,1,1,1},
                {1,1,1,0,0,1,1,1,1,0},
                {0,1,1,1,0,1,1,1,1,1},
                {0,0,1,1,1,1,1,1,1,0},
                {1,1,1,1,1,1,0,1,1,1},
                {0,1,1,1,1,1,1,0,0,1},
                {1,1,1,1,1,0,0,1,1,1},
                {0,1,0,1,1,0,1,1,1,1},
                {1,1,1,0,1,0,1,1,1,1}
        };

        System.out.println(new P562_LongestLineofConsecutiveOneinMatrix().longestLine(grid));
    }

}
