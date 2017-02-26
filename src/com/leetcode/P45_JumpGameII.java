package com.leetcode;

/**
 * Created by xiaoyuan on 26/02/2017.
 * Simple DP
 */
public class P45_JumpGameII{

    public int jump(int[] nums) {
        int lastPostion = 1;
        int[] dp = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            int pos = Math.max(lastPostion, i);
            int maxPos = Math.min(i + nums[i], nums.length - 1);
            for (int j = pos; j <= maxPos; j++) {
                if (dp[j] == 0) {
                    dp[j] = dp[i] + 1;
                } else {
                    dp[j] = Math.min(dp[j], dp[i] + 1);
                }
            }
            lastPostion = maxPos + 1;
        }

        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(new P45_JumpGameII().jump(nums));
    }
}
