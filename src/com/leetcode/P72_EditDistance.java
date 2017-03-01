package com.leetcode;

import java.util.Arrays;

/**
 * Created by xiaoyuan on 01/03/2017.
 */
public class P72_EditDistance {

    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];

        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        dp[0][0] = 0;
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j < dp[0].length; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                char ch1 = word1.charAt(i - 1);
                char ch2 = word2.charAt(j - 1);
                int val = Integer.MAX_VALUE;
                if (dp[i - 1][j - 1] != -1) {
                    val = Math.min(val, dp[i - 1][j - 1] + (ch1 == ch2 ? 0 : 1));
                }
                if (dp[i - 1][j] != -1) {
                    val = Math.min(val, dp[i - 1][j] + 1);
                }
                if (dp[i][j - 1] != -1) {
                    val = Math.min(val, dp[i][j - 1] + 1);
                }

                dp[i][j] = val;
            }
        }


        return dp[word1.length()][word2.length()];

    }

    public static void main(String[] args) {
        System.out.println(new P72_EditDistance().minDistance("aab", "b"));
    }

}
