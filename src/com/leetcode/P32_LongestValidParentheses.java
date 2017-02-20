package com.leetcode;

import java.util.Arrays;
import java.util.Date;
import java.util.Stack;

/**
 * Created by xiaoyuan on 20/02/2017.
 * O(n)算法, 竟然只允许跑一遍  2*n都不行, 还是java允许效率低?
 */
public class P32_LongestValidParentheses {

    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<Integer>();

        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')' && !stack.empty() && s.charAt(stack.peek()) == '(') {
                stack.pop();
                if (!stack.empty()) {
                    result = Math.max(result, i - stack.peek());
                } else {
                    result = Math.max(result, i + 1);
                }
            } else {
                stack.push(i);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String s = "";
        System.out.println(new Date().getTime());
        System.out.println(new P32_LongestValidParentheses().longestValidParentheses(s));
        System.out.println(new Date().getTime());
    }
}

