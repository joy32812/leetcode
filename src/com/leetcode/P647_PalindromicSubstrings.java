package com.leetcode;

/**
 * Created by xiaoyuan on 27/07/2017.
 */
public class P647_PalindromicSubstrings {

    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) {return 0;}

        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        for (int i = 0; i < n; i++) {dp[i][i] = true;}

        for (int k = 2; k <= n; k++) {
            for (int i = 0; i < n; i++) {
                int j = i + k - 1;
                if (j >= n) {break;}

                if (s.charAt(i) == s.charAt(j) && (i + 1 > j - 1 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (dp[i][j]) {ans++;}
            }
        }

        return ans;
    }

}
