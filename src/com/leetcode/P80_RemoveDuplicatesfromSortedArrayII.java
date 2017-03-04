package com.leetcode;

/**
 * Created by xiaoyuan on 04/03/2017.
 * keep the state variable
 */
public class P80_RemoveDuplicatesfromSortedArrayII {


    private void swap(int[] nums, int x, int y) {
        int tmp = nums[x];
        nums[x] = nums[y];
        nums[y] = tmp;
    }

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int cnt = 0;
        long last = 1l + Integer.MAX_VALUE;

        int l = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == last) {
                if (cnt >= 2) {
                    continue;
                } else {
                    cnt++;
                    swap(nums, l, i);
                    l++;
                }
            } else {
                cnt = 1;
                last = nums[i];
                swap(nums, l, i);
                l++;
            }
        }

        return l;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,1,2,2,2,3};
        System.out.println(new P80_RemoveDuplicatesfromSortedArrayII().removeDuplicates(nums));
    }

}
