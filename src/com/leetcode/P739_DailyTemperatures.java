package com.leetcode;

import java.util.Stack;

/**
 * Created by xiaoyuan on 06/12/2017.
 */
public class P739_DailyTemperatures {

    public int[] dailyTemperatures(int[] t) {
        int n = t.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i --) {

            while (!stack.isEmpty() && t[stack.peek()] <= t[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) ans[i] = 0;
            else {
                ans[i] = stack.peek() - i;
            }

            stack.push(i);
        }

//        for (int i = 0; i < n; i++) System.out.println(ans[i]);
        return ans;
    }

}
