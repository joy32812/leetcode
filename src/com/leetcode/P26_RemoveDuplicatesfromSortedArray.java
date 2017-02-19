package com.leetcode;

/**
 * Created by xiaoyuan on 19/02/2017.
 * 从后向前交换即可
 */
public class P26_RemoveDuplicatesfromSortedArray {

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int result = 0;
        int last = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == last) {
                continue;
            }

            last = nums[i];

            result++;
            int tmp = nums[i];
            nums[i] = nums[result];
            nums[result] = tmp;
        }

        return result + 1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 2, 2, 3, 3, 4};
        System.out.println(new P26_RemoveDuplicatesfromSortedArray().removeDuplicates(nums));
    }
}
