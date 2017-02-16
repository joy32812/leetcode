package com.leetcode;

import java.util.Stack;

/**
 * Created by xiaoyuan on 16/02/2017.
 */
public class ValidParentheses20 {

    public boolean isValid(String s) {

        Stack<Integer> stack = new Stack<Integer>();

        try {
            int len = s.length();
            for (int i = 0; i < len; i++) {
                char ch = s.charAt(i);
                if (ch == '(') {
                    stack.push(1);
                } else if (ch == '{') {
                    stack.push(2);
                } else if (ch == '[') {
                    stack.push(3);
                } else if (ch == ')') {
                    int top = stack.pop();
                    if (top != 1) {
                        return false;
                    }
                } else if (ch == '}') {
                    int top = stack.pop();
                    if (top != 2) {
                        return false;
                    }
                } else {
                    int top = stack.pop();
                    if (top != 3) {
                        return false;
                    }
                }
            }
        } catch (Exception e) {
            return false;
        }

        return stack.size() == 0;
    }

    public static void main(String[] args) {
        System.out.println(new ValidParentheses20().isValid("()"));
        System.out.println(new ValidParentheses20().isValid("()[]{}"));
        System.out.println(new ValidParentheses20().isValid("(((()"));
        System.out.println(new ValidParentheses20().isValid("(]"));
        System.out.println(new ValidParentheses20().isValid("([)]"));
    }
}
