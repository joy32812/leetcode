package com.leetcode;

import java.util.Arrays;

/**
 * Created by xiaoyuan on 01/07/2017.
 */
public class P611_ValidTriangleNumber {

    public int triangleNumber(int[] nums) {

        int ans = 0;
        Arrays.sort(nums);

        for (int i = nums.length - 1; i >= 2; i--){
            int l = 0;
            int r = i - 1;

            while (l < r) {
                if (nums[l] + nums[r] > nums[i]) {
                    ans += r - l;
                    r--;
                } else {
                    l++;
                }
            }
        }

        return ans;
    }

}
