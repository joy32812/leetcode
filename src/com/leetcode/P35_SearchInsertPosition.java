package com.leetcode;

/**
 * Created by xiaoyuan on 21/02/2017.
 * classic binary search
 */
public class P35_SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
        int l = 0, r = nums.length;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return l;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        System.out.println(new P35_SearchInsertPosition().searchInsert(nums, 5));
        System.out.println(new P35_SearchInsertPosition().searchInsert(nums, 2));
        System.out.println(new P35_SearchInsertPosition().searchInsert(nums, 7));
        System.out.println(new P35_SearchInsertPosition().searchInsert(nums, 0));
    }

}
