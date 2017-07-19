package com.leetcode;

/**
 * Created by xiaoyuan on 18/07/2017.
 */
public class P643_MaximumAverageSubarrayI {

    public double findMaxAverage(int[] nums, int k) {

        long max = Long.MIN_VALUE;
        long total = 0;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
            if (i == k - 1) {
                max = total;
            } else if (i >= k) {
                total -= nums[i - k];
                max = Math.max(max, total);
            }
        }

        if (max == Long.MIN_VALUE) {max = total;}

        return (0.0 + max) / k;
    }

    public static void main(String[] args) {
        System.out.println(new P643_MaximumAverageSubarrayI().findMaxAverage(new int[]{
                9, 7, 3, 5, 6, 2, 0, 8, 1, 9
        }, 6));
    }

}
