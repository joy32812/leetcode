package com.leetcode;

import java.util.Arrays;

/**
 * Created by xiaoyuan on 30/07/2017.
 */
public class P650_2KeysKeyboard {

    public int minSteps(int n) {

        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[1] = 0;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                if (i % j != 0) {continue;}

                dp[i] = Math.min(dp[i], (i / j) + dp[j]);
            }
        }

        return dp[n];
    }

}
