package com.leetcode;

import java.util.Stack;

/**
 * Created by xiaoyuan on 09/06/2017.
 */
public class P456_132Pattern {

    public boolean find132pattern(int[] nums) {

        if (nums == null || nums.length < 3) {return false;}

        int n = nums.length;

        int[] rightSmall = new int[n];
        for (int i = 0; i < n; i++) {rightSmall[i] = Integer.MIN_VALUE;}

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                rightSmall[stack.peek()] = Math.max(rightSmall[stack.peek()], nums[i]);
            }
            stack.add(i);
        }

        int min = nums[0];
        for (int i = 1; i < n; i++) {
            if (min < rightSmall[i]) {return true;}

            min = Math.min(min, nums[i]);
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(new P456_132Pattern().find132pattern(new int[]{-2,1,1,-2,1,1}));
    }
}
