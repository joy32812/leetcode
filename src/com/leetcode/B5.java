package com.leetcode;

import javax.xml.stream.events.Characters;
import java.util.*;

public class B5 {

    int[] next;
    Map<String, Integer> valueMap;
    String exp;
    public List<String> basicCalculatorIV(String expression, String[] evalvars, int[] evalints) {

        exp = expression;

        valueMap = new HashMap<>();
        for (int i = 0; i < evalvars.length; i++) {
            valueMap.put(evalvars[i], evalints[i]);
        }

        int n = expression.length();
        next = new int[n];

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (expression.charAt(i) == '(') {
                stack.push(i);
            } else if (expression.charAt(i) == ')') {
                next[stack.pop()] = i;
            }
        }



        return dfs(0, n - 1);
    }

    private List<String> dfs(int l, int r) {

        List<List<String>> expList = new ArrayList<>();
        List<String> opList = new ArrayList<>();

        StringBuilder sb = new StringBuilder();
        for (int i = l; i <= r; i++) {
            char ch = exp.charAt(i);

            if (ch == '(') {
                expList.add(dfs(i + 1, next[i] - 1));
                i = next[i];
            } else if (ch == ' ') {
                if (sb.length() > 0) {
                    List<String> tmp = new ArrayList<>();
                    if (valueMap.containsKey(sb.toString())) {
                        tmp.add("" + valueMap.get(sb.toString()));
                    } else {
                        tmp.add(sb.toString());
                    }

                    expList.add(tmp);
                }

                sb = new StringBuilder();
            } else if (ch == '*') {
                opList.add("*");
            } else if (ch == '+') {
                opList.add("+");
            } else if (ch == '-') {
                opList.add("-");
            } else if (Character.isLowerCase(ch)) {
                sb.append(ch);
            } else if (Character.isDigit(ch)) {
                sb.append(ch);
            }
        }




        return null;
    }


    public static void main(String[] args) {

    }

}
