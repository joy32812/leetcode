package com.leetcode;

/**
 * Created by xiaoyuan on 05/08/2017.
 */
public class P518_CoinChange2 {

    public int change(int amount, int[] coins) {

        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int i = 0; i < coins.length; i++) {
            for (int j = 0; j <= amount; j++) {
                if (coins[i] + j > amount) {break;}
                dp[coins[i] + j] += dp[j];
            }
        }

        return dp[amount];
    }

}
