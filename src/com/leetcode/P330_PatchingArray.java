package com.leetcode;

/**
 * Created by xiaoyuan on 08/05/2017.
 */
public class P330_PatchingArray {

    public int minPatches(int[] nums, int n) {

        int ans = 0;
        long patch = 1;
        int i = 0;
        while (patch <= n) {
            if (i < nums.length && nums[i] <= patch) {
                patch += nums[i++];
            } else {
                ans++;
                patch += patch;
            }
        }

        return ans;
    }

}
