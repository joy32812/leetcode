package com.leetcode;

import java.util.Stack;

/**
 * Created by xiaoyuan on 06/06/2017.
 */
public class P439_TernaryExpressionParser {

    private int[] pair;
    public String parseTernary(String expression) {
        int n = expression.length();
        pair = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            if (expression.charAt(i) == '?') {
                stack.add(i);
            } else if (expression.charAt(i) == ':') {
                pair[stack.pop()] = i;
            }
        }

        return dfs(expression, 0, n - 1);
    }

    private String dfs(String s, int l, int r) {
        if (l == r) {return "" + s.charAt(l);}

        String now = "";
        for (int i = l; i <= r; i++) {
            if (s.charAt(i) == '?') {
                if (now.equals("T")) {
                    return dfs(s, i + 1, pair[i] - 1);
                } else {
                    return dfs(s, pair[i] + 1, r);
                }
            }
            now += s.charAt(i);
        }

        return "";
    }

    public static void main(String[] args) {
        System.out.println(new P439_TernaryExpressionParser().parseTernary("T?2:3"));
        System.out.println(new P439_TernaryExpressionParser().parseTernary("T?T?F:5:3"));
        System.out.println(new P439_TernaryExpressionParser().parseTernary("F?1:T?4:5"));
    }
}
