package com.leetcode;

import java.util.Arrays;

/**
 * Created by xiaoyuan on 13/11/2017.
 */
public class P727_MinimumWindowSubsequence {

    public String minWindow(String S, String T) {

        int m = S.length();
        int n = T.length();

        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);

            dp[i][0] = S.charAt(i) == T.charAt(0) ? i : -1;
        }

        for (int j = 1; j < n; j++) {

            int k = -1;
            for (int i = 0; i < m; i++) {
                if (S.charAt(i) == T.charAt(j)) {
                    dp[i][j] = k;
                }

                if (dp[i][j - 1] != -1) k = dp[i][j - 1];
            }
        }

        int beg = -1;
        int len = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            if (dp[i][n - 1] != -1 && i - dp[i][n - 1] + 1 < len) {
                beg = dp[i][n - 1];
                len = i - dp[i][n - 1] + 1;
            }
        }


        if (beg == -1) return "";
        return S.substring(beg, beg + len);
    }

    public static void main(String[] args) {
        System.out.println(new P727_MinimumWindowSubsequence().minWindow("abcdebdde", "bde"));
    }

}
