package com.leetcode;

/**
 * Created by xiaoyuan on 25/04/2017.
 */
public class P303_RangeSumQuery {

    private int[] total;

    public P303_RangeSumQuery(int[] nums) {
        total = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            total[i] = (i - 1 >= 0 ? total[i - 1] : 0) + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        if (i == 0) {return total[j];}
        return total[j] - total[i - 1];
    }

}
