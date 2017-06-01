package com.leetcode;

/**
 * Created by xiaoyuan on 01/06/2017.
 */
public class P416_PartitionEqualSubsetSum {


    public boolean canPartition(int[] nums) {

        int total = 0;
        for (int d : nums) {
            total += d;
        }
        if (total % 2 == 1) {
            return false;
        }

        boolean[] dp = new boolean[total + 1];
        dp[0] = true;


        int max = 0;
        for (int d : nums) {
            for (int i = max; i >= 0; i--) {
                if (dp[i]) {dp[i + d] = true;}
            }
            max += d;
        }

        return dp[total / 2];
    }

    public static void main(String[] args) {
        System.out.println(new P416_PartitionEqualSubsetSum().canPartition(new int[]{1, 5, 11, 5}));
    }

}
