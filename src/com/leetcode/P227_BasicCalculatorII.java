package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoyuan on 07/04/2017.
 */
public class P227_BasicCalculatorII {

    public int calculate(String s) {
        if (s == null || s.length() == 0) return 0;
        return dfs(s.replaceAll(" ", ""));
    }

    private int dfs(String s) {
        char[] ops = {'+', '-'};
        for (char op : ops) {
            if (s.indexOf(op) > 0) {
                String[] split = s.split("[" + op + "]");
                int ans = dfs(split[0]);
                for (int i = 1; i < split.length; i++) {
                    int val = dfs(split[i]);

                    if (op == '+') ans += val;
                    else if (op == '-') ans -= val;
                }

                return ans;
            }
        }

        if (s.indexOf('*') == -1 && s.indexOf('/') == -1) return Integer.parseInt(s);

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '*') return dfs(s.substring(0, i)) * dfs(s.substring(i + 1));
            if (s.charAt(i) == '/') return dfs(s.substring(0, i)) / dfs(s.substring(i + 1));
        }

        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new P227_BasicCalculatorII().calculate("2*5/3"));
//        System.out.println(new P227_BasicCalculatorII().calculate("3 + 5 / 2"));
//        System.out.println(new P227_BasicCalculatorII().calculate("1+2*5/3+6/4*2"));
    }

}
