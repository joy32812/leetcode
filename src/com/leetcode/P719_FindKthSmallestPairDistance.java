package com.leetcode;

import java.util.Arrays;

/**
 * Created by xiaoyuan on 29/10/2017.
 */
public class P719_FindKthSmallestPairDistance {

    public int smallestDistancePair(int[] nums, int k) {

        Arrays.sort(nums);
        int n = nums.length;

        int l = 0;
        int r = nums[n - 1] - nums[0] + 1;

        while (l < r) {

            int m = (l + r) / 2;
            if (count(nums, m) < k) {
                l = m + 1;
            } else {
                r = m;
            }

        }


        return r;
    }

    private int count(int[] nums, int m) {
        int cnt = 0;

        for (int i = 0; i < nums.length; i++) {

            int t = nums[i] + m;

            int l = i + 1;
            int r = nums.length;
            while (l < r) {
                int mid = (l + r) / 2;
                if (nums[mid] <= t) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }

            cnt += l - 1 - i;
        }


        return cnt;
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            System.out.println(new P719_FindKthSmallestPairDistance().smallestDistancePair(new int[]{1, 1, 2, 5, 5}, i));
        }
    }

}
