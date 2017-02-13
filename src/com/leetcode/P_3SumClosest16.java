package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xiaoyuan on 12/02/2017.
 */
public class P_3SumClosest16 {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int result = 0, absValue = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int l = i + 1, r = nums.length - 1;
            while (l < r) {

                int sum = nums[i] + nums[l] + nums[r];
                if (Math.abs(sum - target) < absValue) {
                    result = sum;
                    absValue = Math.abs(sum - target);
                }

                if (sum == target) {
                    break;
                } else if (sum > target) {
                    r--;
                } else {
                    l++;
                }

            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, -4};

        System.out.println(new P_3SumClosest16().threeSumClosest(nums, 1));
    }

}
