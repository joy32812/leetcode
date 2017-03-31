package com.leetcode;

/**
 * Created by xiaoyuan on 31/03/2017.
 */
public class P209_MinimumSizeSubarraySum {

    public int minSubArrayLen(int s, int[] nums) {

        int ans = Integer.MAX_VALUE;

        int begin = -1;
        int total = 0;

        for (int i = 0;i < nums.length; i++) {
            total += nums[i];
            if (total < s) {
                continue;
            }

            ans = Math.min(ans, i - begin);

            int tp = total;
            for (int j = begin + 1; j < i; j++) {
                tp -= nums[j];
                if (tp >= s) {
                    begin = j;
                    ans = Math.min(ans, i - begin);
                    total = tp;
                } else {
                    break;
                }
            }
        }

        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

}
