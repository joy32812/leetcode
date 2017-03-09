package com.leetcode;

/**
 * Created by xiaoyuan on 09/03/2017.
 */
public class P115_DistinctSubsequences {

    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        if (m < n) {return 0;}

        int[][] dp = new int[s.length() + 1][t.length() + 1];

        for (int i = 0; i <= m; i++) {dp[i][0] = 1;}

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char sCh = s.charAt(i - 1);
                char tCh = t.charAt(j - 1);

                dp[i][j] = dp[i - 1][j];
                if (sCh == tCh) {dp[i][j] += dp[i - 1][j - 1];}
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {

    }

}
