package com.leetcode;

/**
 * Created by xiaoyuan on 16/04/2017.
 */
public class P268_MissingNumber {

    public int missingNumber(int[] nums) {

        int xor = 0;
        int i = 0;

        int n = nums.length;

        for (;i < n; i++) {
            xor = xor ^ i ^ nums[i];
        }

        return xor ^ n;
    }

}
