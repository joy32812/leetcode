package com.leetcode;

/**
 * Created by xiaoyuan on 22/02/2017.
 *
 * 1. 二分查出截断的位置
 * 2. 在两次二分查找即可
 */
public class P33_SearchinRotatedSortedArray {

    public int bs(int[] nums, int l, int r, int target) {
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        if (l >= nums.length) {
            return -1;
        }

        if (nums[l] != target) {
            return -1;
        }
        return l;
    }

    public int search(int[] nums, int target) {

        int l = 0, r = nums.length - 1;
        while (l < r) {
            if (l + 1 == r) {
                break;
            }
            int mid = (l + r) / 2;
            if (nums[mid] > nums[r]) {
                l = mid;
            } else {
                r = mid;
            }
        }

        int r1 = bs(nums, 0, l, target);
        int r2 = bs(nums, l + 1, nums.length - 1, target);

        if (r1 != -1) return r1;
        if (r2 != -1) return r2;

        return -1;
    }

    public static void main(String[] args) {

//        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int[] nums = {};
//        int[] nums = {0, 1, 2};

        System.out.println(new P33_SearchinRotatedSortedArray().search(nums, 1));

    }

}
