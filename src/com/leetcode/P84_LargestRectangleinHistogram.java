package com.leetcode;

import java.util.Stack;

/**
 * Created by xiaoyuan on 05/03/2017.
 * WTF?
 * same O(n) same stack?
 * one AC, one TLE
 */
public class P84_LargestRectangleinHistogram {

    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<Integer>();

        int ans = 0;
        for (int i = 0; i <= heights.length; i++) {
            int h = (i == heights.length) ? 0: heights[i];
            if (stack.isEmpty() || heights[stack.peek()] <= h) {
                stack.push(i);
            } else {
                int topInd = stack.pop();
                ans = Math.max(ans, heights[topInd] * (stack.isEmpty() ? i : i - stack.peek() - 1));
                i--;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
//        int[] heights = {1, 1};
        int[] heights = {2, 1, 5, 6, 2, 3};
        System.out.println(new P84_LargestRectangleinHistogram().largestRectangleArea(heights));
    }

}
