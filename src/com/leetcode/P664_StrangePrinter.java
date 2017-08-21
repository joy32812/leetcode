package com.leetcode;

/**
 * Created by xiaoyuan on 21/08/2017.
 */
public class P664_StrangePrinter {

    public int strangePrinter(String s) {
        if (s == null || s.length() == 0) {return 0;}
        int n = s.length();
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        for (int step = 2; step <= n; step++) {
            for (int i = 0; i < n; i++) {

                int j = i + step - 1;
                if (j >= n) {continue;}

                int min = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    min = Math.min(min, dp[i][k] + dp[k + 1][j] + (s.charAt(i) == s.charAt(j) ? -1 : 0));
                }

                dp[i][j] = min;
            }
        }

        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        System.out.println(new P664_StrangePrinter().strangePrinter("aaabbb"));
        System.out.println(new P664_StrangePrinter().strangePrinter("aabbbcca"));
        System.out.println(new P664_StrangePrinter().strangePrinter("aba"));
    }

}
