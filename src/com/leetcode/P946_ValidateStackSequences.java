package com.leetcode;

import java.util.Stack;

public class P946_ValidateStackSequences {


    /**
     * use a stack to find if it is okay
     * @param pushed
     * @param popped
     * @return
     */
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed.length != popped.length) return false;

        Stack<Integer> stack = new Stack<>();

        int now = 0;

        for (int i = 0; i < pushed.length; i++) {
            stack.push(pushed[i]);

            while (!stack.isEmpty() && now < popped.length && stack.peek() == popped[now]) {
                stack.pop();
                now++;
            }
        }

        return now == popped.length;

    }




    public static void main(String[] args) {


        System.out.println(new P946_ValidateStackSequences().validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 3, 5, 1, 2}));

    }

}
