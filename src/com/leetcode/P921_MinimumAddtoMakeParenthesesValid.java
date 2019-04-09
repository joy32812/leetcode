package com.leetcode;

import java.util.Stack;

public class P921_MinimumAddtoMakeParenthesesValid {

    public int minAddToMakeValid(String S) {
        if (S == null || S.length() == 0) return 0;

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            if (ch == ')' && !stack.isEmpty() && stack.peek() == '(') stack.pop();
            else {
                stack.push(ch);
            }
        }

        return stack.size();
    }

}
