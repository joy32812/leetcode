package com.leetcode;

/**
 * Created by xiaoyuan on 27/07/2017.
 */
public class P540_SingleElementinaSortedArray {

    public int singleNonDuplicate(int[] nums) {

        int l = 0;
        int r = nums.length - 1;

        while (l < r) {
            int m = (l + r) / 2;

            if (nums[m] == nums[m + 1]) {
                if ((r - m) % 2 == 1) {
                    r = m - 1;
                } else {
                    l = m;
                }
            } else {
                if ((r - m) % 2 == 0) {
                    r = m;
                } else {
                    l = m + 1;
                }

            }
        }

        return nums[l];
    }

    public static void main(String[] args) {
        System.out.println(new P540_SingleElementinaSortedArray().singleNonDuplicate(new int[]{0, 1, 1}));
    }

}
