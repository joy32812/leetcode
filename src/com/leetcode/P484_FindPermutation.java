package com.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by xiaoyuan on 03/08/2017.
 */
public class P484_FindPermutation {

    /**
     * use stack
     * @param s
     * @return
     */
    public int[] findPermutation(String s) {
        if (s == null || s.length() == 0) return new int[]{1};

        int[] ans = new int[s.length() + 1];
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        int now = 1;

        int ind = 0;
        for (char ch : s.toCharArray()) {
            if (ch == 'I') {
                while (!stack.isEmpty()) ans[ind ++] = stack.pop();
                stack.push(++ now);
            } else {
                stack.push(++ now);
            }
        }

        while (!stack.isEmpty()) ans[ind ++] = stack.pop();

        return ans;
    }

    public static void main(String[] args) {
//        int[] ans = new P484_FindPermutation().findPermutation("D");
        int[] ans = new P484_FindPermutation().findPermutation("DDDDIDIDIDIDIIIDIDI");
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.println();
    }
}
