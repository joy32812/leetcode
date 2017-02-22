package com.leetcode;

import java.util.Arrays;

/**
 * Created by xiaoyuan on 22/02/2017.
 * next_permutation
 * 找到最后一个相邻n[i] < n[i+1]
 * 再找到n[i+1]..n[len-1]中指n[i]大的数中的最小的一个n[k]
 * 交互n[i]与n[k]
 * sort(n, i+1, len)
 */
public class P31_NextPermutation {

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    public void nextPermutation(int[] nums) {
        if (nums.length == 1) {
            return;
        }

        int pos = -1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                pos = i;
            }
        }

        if (pos == -1) {
            Arrays.sort(nums);
            return;
        }

        int target = pos + 1;
        int diff = nums[target] - nums[pos];
        for (int i = pos + 2; i < nums.length; i++) {
            if (nums[i] - nums[pos] > 0 && nums[i] - nums[pos] < diff) {
                diff = nums[i] - nums[pos];
                target = i;
            }
        }

        swap(nums, pos, target);

        Arrays.sort(nums, pos + 1, nums.length);

    }

    public static void main(String[] args) {
        int[] nums = {1};
        new P31_NextPermutation().nextPermutation(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

}
