package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiaoyuan on 07/05/2017.
 */
public class P325_MaximumSizeSubarraySumEqualsk {

    public int maxSubArrayLen(int[] nums, int k) {

        Map<Long, Integer> posMap = new HashMap<>();

        int ans = 0;
        long total = 0;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
            if (total == k) {ans = i + 1;}
            if (!posMap.containsKey(total)) {
                posMap.put(total, i);
            }

            long delta = total - k;
            if (posMap.containsKey(delta)) {
                ans = Math.max(ans, i - posMap.get(delta));
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new P325_MaximumSizeSubarraySumEqualsk().maxSubArrayLen(new int[]{1, -1, 5, -2, 3}, 3));
        System.out.println(new P325_MaximumSizeSubarraySumEqualsk().maxSubArrayLen(new int[]{1, -2, -100, -1, 3, -1}, 1000));
    }

}
