package com.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by xiaoyuan on 25/04/2017.
 */
public class P301_RemoveInvalidParentheses {

    private Set<String> ansSet;
    private boolean[] rmPos;

    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        if (s.length() == 0) {
            result.add("");
            return result;
        }

        int leftNum = 0;
        int delRightNum = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                leftNum++;
            } else if (s.charAt(i) == ')') {
                if (leftNum == 0) {
                    delRightNum++;
                } else {
                    leftNum--;
                }
            }
        }

        if (leftNum == 0 && delRightNum == 0) {
            result.add(s);
            return result;
        }

        ansSet = new HashSet<>();
        rmPos = new boolean[s.length()];
        dfs(s, 0, leftNum, delRightNum, 0);

        for (String ss : ansSet) {
            result.add(ss);
        }

        return result;
    }

    private void dfs(String s, int b, int leftNum, int rightNum, int nowLeft) {
        if (leftNum == 0 && rightNum == 0 && b == s.length()) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < b; i++) {
                if (rmPos[i]) {continue;}
                sb.append(s.charAt(i));
            }
            sb.append(s.substring(b));
            ansSet.add(sb.toString());
            return;
        }
        if (b >= s.length()) {return;}

        char ch = s.charAt(b);
        if (ch == '(') {
            // rm
            if (leftNum > 0) {
                rmPos[b] = true;
                dfs(s, b + 1, leftNum - 1, rightNum, nowLeft);
                rmPos[b] = false;
            }
            // no rm
            dfs(s, b + 1, leftNum, rightNum, nowLeft + 1);
        } else if (ch == ')') {
            // rm
            if (rightNum > 0 || nowLeft == 0) {
                rmPos[b] = true;
                dfs(s, b + 1, leftNum, rightNum - 1, nowLeft);
                rmPos[b] = false;
            }

            if (nowLeft > 0) {
                dfs(s, b + 1, leftNum, rightNum, nowLeft - 1);
            }
        } else {
            dfs(s, b + 1, leftNum, rightNum, nowLeft);
        }

    }


    public static void main(String[] args) {
//        System.out.println(new P301_RemoveInvalidParentheses().removeInvalidParentheses("n"));
//        System.out.println(new P301_RemoveInvalidParentheses().removeInvalidParentheses("()())()"));
//        System.out.println(new P301_RemoveInvalidParentheses().removeInvalidParentheses("(a)())()"));
        System.out.println(new P301_RemoveInvalidParentheses().removeInvalidParentheses(")()("));
//        System.out.println(new P301_RemoveInvalidParentheses().removeInvalidParentheses(")("));
//        System.out.println(new P301_RemoveInvalidParentheses().removeInvalidParentheses(")(b"));
    }

}
