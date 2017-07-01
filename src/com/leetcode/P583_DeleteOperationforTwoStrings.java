package com.leetcode;

/**
 * Created by xiaoyuan on 01/07/2017.
 */
public class P583_DeleteOperationforTwoStrings {

    public int minDistance(String word1, String word2) {

        if (word1.length() == 0 || word2.length() == 0) {return word1.length() + word2.length();}

        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);

                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j + 1], dp[i][j] + 1);
                }
            }
        }

        int lcs = dp[m][n];
        return word1.length() + word2.length() - 2 * lcs;
    }

    public static void main(String[] args) {
        System.out.println(new P583_DeleteOperationforTwoStrings().minDistance("sea", "eat"));
    }

}
