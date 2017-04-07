package com.leetcode;

import java.util.Stack;

/**
 * Created by xiaoyuan on 07/04/2017.
 */
public class P224_BasicCalculator {

    int[] pos;

    public int calculate(String s) {
        s = s.replace(" ", "");

        int n = s.length();
        pos = new int[n];

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')') {
                pos[stack.pop()] = i;
            }
        }

        return dfs(s, 0, n - 1);
    }

    private int dfs(String s, int l, int r) {
        int ans = 0;

        int last = 0;
        boolean isAdd = true;
        for (int i = l; i <= r; i++) {
            if (s.charAt(i) == '(') {
                if (isAdd) {ans += last;}
                else {ans -= last;}
                last = 0;

                if (isAdd) {
                    ans += dfs(s, i + 1, pos[i]);
                } else {
                    ans -= dfs(s, i + 1, pos[i]);
                }
                i = pos[i];
            } else if (s.charAt(i) == '+') {
                if (isAdd) {ans += last;}
                else {ans -= last;}
                last = 0;

                isAdd = true;
            } else if (s.charAt(i) == '-') {
                if (isAdd) {ans += last;}
                else {ans -= last;}
                last = 0;

                isAdd = false;
            } else if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                last = last * 10 + (s.charAt(i) - '0');
            }
        }

        if (isAdd) {ans += last;}
        else {ans -= last;}

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new P224_BasicCalculator().calculate("(1-(5)"));
        System.out.println(new P224_BasicCalculator().calculate("(1+(4+5+2)-3)+(6+8)"));
    }
}
