package com.leetcode;

import java.util.Stack;

public class P1047_RemoveAllAdjacentDuplicatesInString {

    /**
     * easy
     * use stack
     * @param S
     * @return
     */
    public String removeDuplicates(String S) {

        Stack<Character> stack = new Stack<>();

        for (char ch : S.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == ch) stack.pop();
            else {
                stack.push(ch);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) sb.append(stack.pop());

        return sb.reverse().toString();
    }



    public static void main(String[] args) {

    }

}
