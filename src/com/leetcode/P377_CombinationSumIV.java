package com.leetcode;

import java.util.Arrays;

/**
 * Created by xiaoyuan on 19/05/2017.
 */
public class P377_CombinationSumIV {

    int[] dp;

    public int combinationSum4(int[] nums, int target) {
        dp = new int[target + 1];
        Arrays.fill(dp, -1);
        dp[0] = 1;

        return work(nums, target);
    }

    private int work(int[] nums, int n) {
        if (n < 0) {return 0;}
        if (dp[n] != -1) {return dp[n];}

        int ans = 0;
        for (int d : nums) {
            ans += work(nums, n - d);
        }

        dp[n] = ans;
        return ans;
    }


    public static void main(String[] args) {
        System.out.println(new P377_CombinationSumIV().combinationSum4(new int[]{1, 2, 3}, 4));
    }

}
