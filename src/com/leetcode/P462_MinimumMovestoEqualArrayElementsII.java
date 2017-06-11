package com.leetcode;

import java.util.Arrays;

/**
 * Created by xiaoyuan on 10/06/2017.
 */
public class P462_MinimumMovestoEqualArrayElementsII {

    public int minMoves2(int[] nums) {

        Arrays.sort(nums);
        int l = 0;
        int r = nums.length -1;
        int ans = 0;
        while (l < r) {
            ans += (nums[r] - nums[l]);
            l++;
            r--;
        }

        return ans;
    }

}
