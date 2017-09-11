package com.leetcode;

/**
 * Created by xiaoyuan on 10/09/2017.
 */
public class P674_LongestContinuousIncreasingSubsequence {

    public int findLengthOfLCIS(int[] nums) {

        if (nums == null || nums.length == 0) {return 0;}

        int ans = 1;
        int cnt = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                cnt++;
            } else {
                ans = Math.max(ans, cnt);

                cnt = 1;
            }
        }

        ans = Math.max(ans, cnt);

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new P674_LongestContinuousIncreasingSubsequence().findLengthOfLCIS(new int[]{1, 3, 5, 4, 7}));
        System.out.println(new P674_LongestContinuousIncreasingSubsequence().findLengthOfLCIS(new int[]{1, 3, 5, 6, 7}));
    }

}
