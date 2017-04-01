package com.leetcode;

/**
 * Created by xiaoyuan on 01/04/2017.
 */

public class P213_HouseRobberII {

    public int rob(int[] nums) {
        if (nums.length == 0) {return 0;}
        if (nums.length == 1) {return nums[0];}

        return Math.max(nums[0] + getMax(nums, 2, nums.length - 2), getMax(nums, 1, nums.length - 1));
    }

    private int getMax(int[] nums, int l, int r) {

        int before = 0;
        int last = 0;
        for (int i = l; i <= r; i++) {
            int max = Math.max(nums[i] + before, last);

            before = last;
            last = max;
        }

        return last;
    }

}
