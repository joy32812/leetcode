package com.leetcode;

/**
 * Created by xiaoyuan on 13/11/2017.
 */
public class P724_FindPivotIndex {

    public int pivotIndex(int[] nums) {
        int n = nums.length;
        if (n == 0) return -1;

        int[] ll = new int[n];
        int[] rr = new int[n];
        for (int i = 0; i < n; i++) {
            ll[i] = nums[i] + (i - 1 >= 0 ? ll[i - 1] : 0);
        }


        for (int i = n - 1; i >= 0; i--) {
            rr[i] = nums[i] + (i + 1 <= n - 1 ? rr[i + 1] : 0);
        }

        for (int i = 0; i < n; i++) {
            int left = i - 1 >= 0 ? ll[i - 1] : 0;
            int right = i + 1 <= n - 1 ? rr[i + 1] : 0;

            if (left == right) return i;
        }

        return -1;
    }

}
