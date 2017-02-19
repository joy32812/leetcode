package com.leetcode;

/**
 * Created by xiaoyuan on 19/02/2017.
 * 遍历一遍, 维护pos为当前无val的数组最大位置
 * 简单交换即可
 */
public class P27_RemoveElement {

    public int removeElement(int[] nums, int val) {

        int pos = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                continue;
            }

            pos++;

            int tmp = nums[i];
            nums[i] =  nums[pos];
            nums[pos] = tmp;
        }

        return pos + 1;
    }

    public static void main(String[] args) {
        int[] nums = {};
        System.out.println(new P27_RemoveElement().removeElement(nums, 3));
    }

}
