package com.leetcode;

import java.util.Arrays;

/**
 * Created by xiaoyuan on 15/04/2017.
 */
public class P259_3SumSmaller {

    public int threeSumSmaller(int[] nums, int target) {

        Arrays.sort(nums);

        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int now = nums[i] + nums[j] + nums[k];
                if (now < target) {
                    ans += (k - j);
                    j++;
                } else {
                    k--;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new P259_3SumSmaller().threeSumSmaller(new int[]{3, 1, 0, -2}, 4));
    }
}
