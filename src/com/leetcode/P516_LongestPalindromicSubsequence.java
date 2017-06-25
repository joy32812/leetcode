package com.leetcode;

/**
 * Created by xiaoyuan on 25/06/2017.
 */
public class P516_LongestPalindromicSubsequence {

    public int longestPalindromeSubseq(String s) {

        if (s == null || s.length() == 0) {return 0;}
        if (s.length() == 1) {return 1;}

        int n = s.length();
        int[][] dp = new int[n][n + 1];

        for (int l = 1; l <= n; l++) {
            for (int i = 0; i < n && i + l - 1 < n; i++) {
                int j = i + l - 1;
                if (i == j) {
                    dp[i][j] = 1;
                    continue;
                }

                dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = Math.max(dp[i][j], i + 1 == j ? 2 : dp[i + 1][j - 1] + 2);
                }
            }

        }

        return dp[0][n - 1];
    }

    public static void main(String[] args) {
//        System.out.println(new P516_LongestPalindromicSubsequence().longestPalindromeSubseq("cbbd"));
        System.out.println(new P516_LongestPalindromicSubsequence().longestPalindromeSubseq("bbbab"));
    }

}
