package com.leetcode;

import java.util.Stack;

public class P907_SumofSubarrayMinimums {

    public int sumSubarrayMins(int[] A) {

        int n = A.length;

        int[] left = new int[n];
        int[] right = new int[n];

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && A[stack.peek()] > A[i]) stack.pop();

            if (stack.isEmpty()) left[i] = 0;
            else {
                left[i] = stack.peek() + 1;
            }

            stack.push(i);
        }


        stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && A[stack.peek()] >= A[i]) stack.pop();

            if (stack.isEmpty()) right[i] = n - 1;
            else {
                right[i] = stack.peek() - 1;
            }

            stack.push(i);
        }

        long MOD = 1000000000 + 7;
        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans = (ans + 1l * (i - left[i] + 1) * (right[i] - i + 1) * A[i]) % MOD;
        }

        return (int) ans;
    }

    public static void main(String[] args) {
        System.out.println(new P907_SumofSubarrayMinimums().sumSubarrayMins(new int[]{3, 1, 2, 4}));
    }

}
