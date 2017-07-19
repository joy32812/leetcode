package com.leetcode;

/**
 * Created by xiaoyuan on 19/07/2017.
 */
public class P644_MaximumAverageSubarrayII {

    public double findMaxAverage(int[] nums, int k) {

        double l = Integer.MIN_VALUE;
        double r = Integer.MAX_VALUE;

        while (r - l > 0.00001) {
            double m = (l + r) / 2;

            if (okay(m, k, nums)) {
                l = m;
            } else {
                r = m;
            }
        }

        return l;
    }

    private boolean okay(double m, int k, int[] nums) {
        int n = nums.length;

        double[] copy = new double[n];
        for (int i = 0; i < n; i++) {copy[i] = nums[i] - m;}

        double now = 0;
        double last = 0;
        for (int i = 0; i < k; i++) {now += copy[i];}
        if (now >= 0) {return true;}


        for (int i = k; i < n; i++) {
            now += copy[i];
            last += copy[i - k];

            if (last < 0) {
                now -= last;
                last = 0;
            }
            if (now >= 0) {return true;}
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(new P644_MaximumAverageSubarrayII().findMaxAverage(new int[]{1, 12, -5, -6, 50, 3}, 4));
    }


}
