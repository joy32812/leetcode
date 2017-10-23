package com.leetcode;

/**
 * Created by xiaoyuan on 22/10/2017.
 */
public class P712_MinimumASCIIDeleteSumforTwoStrings {

    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) dp[i][j] = Integer.MAX_VALUE;
        }

        dp[0][0] = 0;
        for (int i = 1; i<= m; i++) {
            dp[i][0] = dp[i - 1][0] + (s1.charAt(i - 1));
        }
        for (int j = 1; j <= n; j++) {
            dp[0][j] = dp[0][j - 1] + (s2.charAt(j - 1));
        }

        for (int i = 1; i <= m; i++) {

            for (int j = 1; j <= n; j++) {

                char a = s1.charAt(i - 1);
                char b = s2.charAt(j - 1);

                dp[i][j] = Math.min(dp[i - 1][j] + (a), dp[i][j - 1] + (b));
                if (a == b) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1]);
                }
            }
        }


        return dp[m][n];
    }

    public static void main(String[] args) {
        System.out.println(new P712_MinimumASCIIDeleteSumforTwoStrings().minimumDeleteSum("a", "at"));
        System.out.println(new P712_MinimumASCIIDeleteSumforTwoStrings().minimumDeleteSum("delete", "leet"));
    }

}
