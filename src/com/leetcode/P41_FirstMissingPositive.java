package com.leetcode;

/**
 * Created by xiaoyuan on 25/02/2017.
 */
public class P41_FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {
        boolean[] flag = new boolean[nums.length + 5];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0 || nums[i] >= flag.length) {
                continue;
            }
            flag[nums[i]] = true;
        }

        int ans = 1;
        for (int i = 1; i < flag.length; i++) {
            if (flag[i] == false) {
                ans = i;
                break;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1000, 0};

        System.out.println(new P41_FirstMissingPositive().firstMissingPositive(nums));
    }
}
