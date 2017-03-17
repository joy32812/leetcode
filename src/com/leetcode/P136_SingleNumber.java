package com.leetcode;

/**
 * Created by xiaoyuan on 17/03/2017.
 */
public class P136_SingleNumber {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans ^= nums[i];
        }

        return ans;
    }

}
