package com.leetcode;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by xiaoyuan on 24/06/2017.
 */
public class P523_ContinuousSubarraySum {

    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums == null || nums.length <= 1) {return false;}

        Long K = 0L + k;

        if (k == 0) {
            return workOnZero(nums);
        }
        if (K < 0) {K = -K;}

        Set<Long> modSet = new HashSet<>();
        modSet.add(0L);

        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }

        for (int i = 1; i < nums.length; i++) {
            if (modSet.contains(nums[i] % K)) {
                return true;
            }
            modSet.add(nums[i - 1] % K);
        }

        return false;
    }

    private boolean workOnZero(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == 0 && nums[i - 1] == 0) {return true;}
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new P523_ContinuousSubarraySum().checkSubarraySum(new int[]{23, 2, 4, 6, 7}, 16));
    }

}
