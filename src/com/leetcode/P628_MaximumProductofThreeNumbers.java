package com.leetcode;

import java.util.Arrays;

/**
 * Created by xiaoyuan on 01/07/2017.
 */
public class P628_MaximumProductofThreeNumbers {

    public int maximumProduct(int[] nums) {

        int n = nums.length;
        Arrays.sort(nums);
        return Math.max(nums[0] * nums[1] * nums[n - 1], nums[n - 1] * nums[n - 2] * nums[n - 3]);

    }

}
