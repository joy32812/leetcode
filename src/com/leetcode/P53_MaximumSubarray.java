package com.leetcode;

/**
 * Created by xiaoyuan on 24/02/2017.
 */
public class P53_MaximumSubarray {

    public int maxSubArray(int[] nums) {
        int result = nums[0];

        int last = nums[0];
        for (int i = 1; i < nums.length;i++) {
            result = Math.max(result, nums[i] + (last > 0 ? last : 0));
            last = nums[i] + (last > 0 ? last : 0);
        }

        return result;
    }

    public static void main(String[] args) {

        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};

        System.out.println(new P53_MaximumSubarray().maxSubArray(nums));

    }
}
