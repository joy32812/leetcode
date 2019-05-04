package com.leetcode;

public class P704_BinarySearch {

    public int search(int[] nums, int target) {
        if (nums == null && nums.length == 0) return -1;

        int l = 0;
        int r = nums.length - 1;

        if (nums[l] > target || nums[r] < target) return -1;

        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) return mid;

            if (nums[mid] > target) r = mid;
            else l = mid + 1;
        }

        return nums[l] == target ? l : -1;
    }

}
