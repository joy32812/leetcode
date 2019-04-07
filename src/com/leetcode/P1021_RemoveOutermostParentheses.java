package com.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class P1021_RemoveOutermostParentheses {

    /**
     * medium
     * use stack to valid the parentheses
     * @param S
     * @return
     */
    public String removeOuterParentheses(String S) {
        if (S == null || S.length() == 0) return "";

        List<Integer> posList = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);

            if (ch == '(') stack.push(1);
            else {
                stack.pop();

                if (stack.isEmpty()) {
                    posList.add(i);
                }
            }
        }


        StringBuilder sb = new StringBuilder();
        int last = 0;
        for (int i = 0; i < posList.size(); i++) {
            int p = posList.get(i);
            sb.append(S.substring(last + 1, p));
            last = p + 1;
        }

        return sb.toString();
    }

    public static void main(String[] args) {

        System.out.println(new P1021_RemoveOutermostParentheses().removeOuterParentheses("(()())(())"));

    }
}
