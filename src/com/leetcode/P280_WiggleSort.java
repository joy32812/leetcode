package com.leetcode;

import java.util.Arrays;

/**
 * Created by xiaoyuan on 18/04/2017.
 */
public class P280_WiggleSort {

    public void wiggleSort(int[] nums) {
        boolean bigger = true;
        for (int i = 1; i < nums.length; i++) {
            if (bigger && nums[i] < nums[i - 1]) swap(nums, i - 1, i);
            if (!bigger && nums[i] > nums[i - 1]) swap(nums, i - 1, i);

            bigger = !bigger;

        }
    }

    private void swap(int[] nums, int x, int y) {
        int tmp = nums[x];
        nums[x] = nums[y];
        nums[y] = tmp;
    }

    public static void main(String[] args) {
        new P280_WiggleSort().wiggleSort(new int[]{3,5,2,1,6,4,11});
    }

}
