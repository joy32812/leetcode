package com.leetcode;

/**
 * Created by xiaoyuan on 11/06/2017.
 */
public class P474_OnesandZeroes {

    public int findMaxForm(String[] strs, int m, int n) {

        int[][][] dp = new int[strs.length][m + 1][n + 1];

        for (int i = 0; i < strs.length; i++) {
            String s = strs[i];
            int zeros = 0;
            int ones = 0;
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == '0') {zeros++;}
                else {ones++;}
            }

            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    dp[i][j][k] = Math.max(j > 0 ? dp[i][j - 1][k] : 0, k > 0 ? dp[i][j][k - 1] : 0);
                    dp[i][j][k] = Math.max(dp[i][j][k], i > 0 ? dp[i - 1][j][k] : 0);

                    if (j >= zeros && k >= ones) {
                        dp[i][j][k] = Math.max(dp[i][j][k], (i > 0 ? dp[i - 1][j - zeros][k - ones] : 0) + 1);
                    }
                }
            }
        }

        return dp[strs.length - 1][m][n];
    }

    public static void main(String[] args) {
        System.out.println(new P474_OnesandZeroes().findMaxForm(new String[]{
                "10",
                "0001",
                "111001",
                "1",
                "0"
        }, 5, 3));

        System.out.println(new P474_OnesandZeroes().findMaxForm(new String[]{
                "10",
                "1",
                "0"
        }, 1, 1));
    }

}
