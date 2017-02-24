package com.leetcode;

/**
 * Created by xiaoyuan on 24/02/2017.
 */
public class P53_MaximumSubarray {

    public int maxSubArray(int[] nums) {
        int result = Integer.MIN_VALUE;

        int tmp = 0;
        for (int i = 0; i < nums.length;i++) {
            tmp += nums[i];
            result = Math.max(result, tmp);
            if (tmp > result) {
                result = tmp;
            }

            if (tmp < 0) {
                tmp = 0;
            }
        }

        return result;
    }

    public static void main(String[] args) {

        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};

        System.out.println(new P53_MaximumSubarray().maxSubArray(nums));

    }
}
