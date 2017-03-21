package com.leetcode;

/**
 * Created by xiaoyuan on 21/03/2017.
 */
public class P153_FindMinimuminRotatedSortedArray {

    public int findMin(int[] nums) {
        if (nums.length == 1) {return nums[0];}

        int l = 0, r = nums.length - 1;
        while (l < r) {
            if (l + 1 == r) {break;}

            int mid = (l + r) / 2;
            if (nums[mid] <= nums[r]) {
                r = mid;
            } else {
                l = mid;
            }
        }

        int ans = nums[l];
        if (l + 1 < nums.length) {
            ans = Math.min(ans, nums[l + 1]);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new P153_FindMinimuminRotatedSortedArray().findMin(new int[]{4, 5, 6, 0, 1, 2}));
        System.out.println(new P153_FindMinimuminRotatedSortedArray().findMin(new int[]{0}));
        System.out.println(new P153_FindMinimuminRotatedSortedArray().findMin(new int[]{4, 6}));
        System.out.println(new P153_FindMinimuminRotatedSortedArray().findMin(new int[]{4, 5, 6, 7, 8, 9}));
    }

}


