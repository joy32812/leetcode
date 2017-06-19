package com.leetcode;

/**
 * Created by xiaoyuan on 11/06/2017.
 */
public class P477_TotalHammingDistance {

    public int totalHammingDistance(int[] nums) {

        int ans = 0;
        for (int i = 31; i >= 0; i--) {
            int zeros = 0;
            int ones = 0;
            for (int d : nums) {
                if ((d & (1 << i)) != 0) {
                    ones++;
                } else {
                    zeros++;
                }
            }

            ans += ones * zeros;

        }

        return ans;
    }

}
