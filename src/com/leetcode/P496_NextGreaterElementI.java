package com.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by xiaoyuan on 20/06/2017.
 */
public class P496_NextGreaterElementI {

    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        Map<Integer, Integer> ansMap = new HashMap<>();

        Stack<Integer> stack = new Stack<>();

        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() < nums[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {ansMap.put(nums[i], -1);}
            else {
                ansMap.put(nums[i], stack.peek());
            }
            stack.push(nums[i]);
        }

        int[] ans = new int[findNums.length];
        for (int i = 0; i < findNums.length; i++) {
            ans[i] = ansMap.get(findNums[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
    }

}
