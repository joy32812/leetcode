package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoyuan on 07/04/2017.
 */
public class P227_BasicCalculatorII {

    public int calculate(String s) {
        s = s.replace(" ", "");

        int last = 0;
        List<Integer> vals = new ArrayList<>();

        int sign = 1;
        // 1 add
        // -1 sub
        // 2 multiply
        // 3 divide
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                last = last * 10 + (ch - '0');
            } else {
                if (sign == 2) {
                    int before = vals.get(vals.size() - 1);
                    vals.set(vals.size() - 1, before * last);
                } else if (sign == 3) {
                    int before = vals.get(vals.size() - 1);
                    vals.set(vals.size() - 1, before / last);
                } else {
                    vals.add(sign * last);
                }
                last = 0;

                if (ch == '+') {
                    sign = 1;
                } else if (ch == '-') {
                    sign = -1;
                } else if (ch == '*') {
                    sign = 2;
                } else if (ch == '/') {
                    sign = 3;
                }
            }
        }

        if (sign == 2) {
            int before = vals.get(vals.size() - 1);
            vals.set(vals.size() - 1, before * last);
        } else if (sign == 3) {
            int before = vals.get(vals.size() - 1);
            vals.set(vals.size() - 1, before / last);
        } else {
            vals.add(sign * last);
        }

        int ans = 0;
        for (int d : vals) {ans += d;}

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new P227_BasicCalculatorII().calculate("3 + 5 / 2"));
    }

}
