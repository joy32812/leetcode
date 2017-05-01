package com.leetcode;

import java.util.Arrays;

/**
 * Created by xiaoyuan on 01/05/2017.
 */
public class P322_CoinChange {

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {return 0;}

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;


        for (int i = 0; i < amount; i++) {
            if (dp[i] == -1) {continue;}

            for (int j = 0; j < coins.length; j++) {
                if (coins[j] > amount) {continue;}
                if (i + coins[j] > amount) {continue;}
                if (dp[i + coins[j]] == -1) {
                    dp[i + coins[j]] = dp[i] + 1;
                } else {
                    dp[i + coins[j]] = Math.min(dp[i + coins[j]], dp[i] + 1);
                }
            }
        }

        return dp[amount];
    }

    public static void main(String[] args) {
        System.out.println(new P322_CoinChange().coinChange(new int[]{1,2147483647}, 2));
        System.out.println(new P322_CoinChange().coinChange(new int[]{1, 2, 5}, 11));
    }

}
