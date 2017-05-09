package com.leetcode;

/**
 * Created by xiaoyuan on 09/05/2017.
 */
public class P334_IncreasingTripletSubsequence {

    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length <= 2) {return false;}

        int oneMin = Integer.MAX_VALUE;
        int twoMin = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > twoMin) {
                return true;
            }

            if (nums[i] < oneMin) {
                oneMin = nums[i];
            } else if (nums[i] > oneMin) {
                twoMin = Math.min(twoMin, nums[i]);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(new P334_IncreasingTripletSubsequence().increasingTriplet(new int[]{1, 2, 2, 4, 4}));
        System.out.println(new P334_IncreasingTripletSubsequence().increasingTriplet(new int[]{4, 2, 2, 4, 4}));
    }

}
