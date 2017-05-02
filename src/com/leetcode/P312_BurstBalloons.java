package com.leetcode;

import java.util.Arrays;

/**
 * Created by xiaoyuan on 02/05/2017.
 */
public class P312_BurstBalloons {

    private int[][] dp;
    public int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0) {return 0;}

        int n = nums.length;
        dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {dp[i][j] = -1;}
        }


        return dfs(nums, 0, n - 1);
    }

    private int dfs(int[] nums, int l, int r) {
        if (l > r) {return 0;}
        if (dp[l][r] >= 0) {return dp[l][r];}

        if (l == r) {
            int a = getValue(nums, l - 1);
            int b = getValue(nums, r + 1);
            return dp[l][r] = a * b * nums[l];
        }

        int max = 0;
        for (int i = l; i <= r; i++) {
            max = Math.max(max, nums[i] * getValue(nums, l - 1) * getValue(nums, r + 1) + dfs(nums, l, i - 1) + dfs(nums, i + 1, r));
        }


        return dp[l][r] = max;
    }

    private int getValue(int[] nums, int x) {
        if (x < 0 || x >= nums.length) {return 1;}
        return nums[x];
    }

    public static void main(String[] args) {
        System.out.println(new P312_BurstBalloons().maxCoins(new int[]{3, 1, 5, 8}));
//        System.out.println(new P312_BurstBalloons().maxCoins(new int[]{3, 1, 5, 8}));
    }

}
