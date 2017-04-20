package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoyuan on 20/04/2017.
 */
public class P282_ExpressionAddOperators {

    private List<String> ans;
    public List<String> addOperators(String num, int target) {
        if (num == null || num.length() == 0) {return new ArrayList<>();}

        ans = new ArrayList<>();
        dfs(num, target, "", 0, 0, 0);

        return ans;
    }

    private void dfs(String num, int target, String path, int pos, long now, long mult) {

        if (pos == num.length()) {
            if (now == target) {
                ans.add(path);
            }
            return;
        }

        for (int i = pos; i < num.length(); i++) {
            if (i != pos && num.charAt(pos) == '0') {break;}

            long cur = Long.parseLong(num.substring(pos, i + 1));
            if (pos == 0) {
                dfs(num, target, path + cur, i + 1, cur, cur);
            } else {
                dfs(num, target, path + "+" + cur, i + 1, now + cur, cur);
                dfs(num, target, path + "-" + cur, i + 1, now - cur, -cur);
                dfs(num, target, path + "*" + cur, i + 1, now - mult + mult * cur, mult * cur);
            }
        }

    }


    public static void main(String[] args) {
//        System.out.println(new P282_ExpressionAddOperators().addOperators("123", 6));
//        System.out.println(new P282_ExpressionAddOperators().addOperators("232", 8));
        System.out.println(new P282_ExpressionAddOperators().addOperators("105", 5));
//        System.out.println(new P282_ExpressionAddOperators().addOperators("00", 0));
    }
}
