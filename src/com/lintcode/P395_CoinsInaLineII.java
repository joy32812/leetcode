package com.lintcode;

public class P395_CoinsInaLineII {

    public boolean firstWillWin(int[] values) {
        int n = values.length;
        if (n <= 2) return true;

        int[] dp = new int[n];

        dp[n - 1] = values[n - 1];
        dp[n - 2] = values[n - 1] + values[n - 2];

        for (int i = n - 3; i >= 0; i--) {
            dp[i] = Math.max(values[i] - dp[i + 1], values[i] + values[i + 1] - dp[i + 2]);
        }

        return dp[0] > 0;
    }

    public static void main(String[] args) {
        System.out.println(new P395_CoinsInaLineII().firstWillWin(new int[]{1, 2, 4}));
    }

}
