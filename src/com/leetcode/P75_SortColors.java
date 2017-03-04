package com.leetcode;

/**
 * Created by xiaoyuan on 02/03/2017.
 */
public class P75_SortColors {

    public void sortOne(int[] nums, int val) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            while (l < nums.length && nums[l] <= val) {l++;}
            if (l >= r || l == nums.length) {break;}
            if (nums[r] <= val) {
                int tmp = nums[l];
                nums[l] = nums[r];
                nums[r] = tmp;
                l++;
            }
            r--;
        }
    }

    public void sortColors(int[] nums) {
        sortOne(nums, 0);
        sortOne(nums, 1);
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2,0,1,1,1,2};
        new P75_SortColors().sortColors(nums);

        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

}
