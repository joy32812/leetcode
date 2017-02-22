package com.leetcode;

import java.util.List;

/**
 * Created by xiaoyuan on 22/02/2017.
 */
public class P34_SearchForARange {

    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};

        int l = 0, r = nums.length;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        if (l >= nums.length || nums[l] != target) {
            return result;
        }
        result[0] = l;

        l = 0;
        r = nums.length;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] > target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        result[1] = l - 1;


        return result;
    }


    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int[] result = new P34_SearchForARange().searchRange(nums, 7);
        System.out.println(result[0] + " " + result[1]);
    }
}
