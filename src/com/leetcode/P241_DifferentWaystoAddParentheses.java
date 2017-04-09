package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoyuan on 09/04/2017.
 */
public class P241_DifferentWaystoAddParentheses {

    public List<Integer> diffWaysToCompute(String input) {
        List<String> inputList = new ArrayList<>();
        input = input.replace(" ", "");

        int last = 0;
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            if (ch == '+') {
                inputList.add("" + last);
                inputList.add("+");
                last = 0;
            } else if (ch == '-') {
                inputList.add("" + last);
                inputList.add("-");
                last = 0;
            } else if (ch == '*') {
                inputList.add("" + last);
                inputList.add("*");
                last = 0;
            } else {
                last = last * 10 + (ch - '0');
            }
        }
        inputList.add("" + last);

        return dfs(inputList, 0, inputList.size() - 1);
    }

    private List<Integer> dfs(List<String> inputList, int l, int r) {
        List<Integer> result = new ArrayList<>();
        if (l == r) {
            result.add(Integer.parseInt(inputList.get(l)));
            return result;
        }
        for (int i = l; i <= r; i++) {
            String str = inputList.get(i);

            if (str.equals("+")) {
                List<Integer> left = dfs(inputList, l, i - 1);
                List<Integer> right = dfs(inputList, i + 1, r);
                for (int ll : left) {
                    for (int rr : right) {
                        result.add(ll + rr);
                    }
                }

            } else if (str.equals("-")) {
                List<Integer> left = dfs(inputList, l, i - 1);
                List<Integer> right = dfs(inputList, i + 1, r);
                for (int ll : left) {
                    for (int rr : right) {
                        result.add(ll - rr);
                    }
                }
            } else if (str.equals("*")) {
                List<Integer> left = dfs(inputList, l, i - 1);
                List<Integer> right = dfs(inputList, i + 1, r);
                for (int ll : left) {
                    for (int rr : right) {
                        result.add(ll * rr);
                    }
                }
            } else {
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new P241_DifferentWaystoAddParentheses().diffWaysToCompute("2*3-4*5"));
    }

}
