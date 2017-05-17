package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xiaoyuan on 17/05/2017.
 */
public class P368_LargestDivisibleSubset {

    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        if (nums == null || nums.length == 0) {return ans;}

        int n = nums.length;
        int[] dp = new int[n];
        int[] from = new int[n];
        Arrays.fill(dp, 1);

        Arrays.sort(nums);
        int max = 1;
        int pos = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        from[i] = j;
                    }
                }
            }

            if (max < dp[i]) {
                max = dp[i];
                pos = i;
            }
        }

        while (max > 0) {
            ans.add(nums[pos]);
            max--;
            pos = from[pos];
        }

        return ans;
    }

}
