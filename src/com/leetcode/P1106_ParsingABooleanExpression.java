package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class P1106_ParsingABooleanExpression {


    /**
     * split and parse
     * @param expression
     * @return
     */
    public boolean parseBoolExpr(String expression) {
        char first = expression.charAt(0);
        if (first == 't') return true;
        if (first == 'f') return false;


        if (first == '!') return !parseBoolExpr(expression.substring(2, expression.length() - 1));

        List<String> splits = splitExpr(expression.substring(2, expression.length() - 1));

        boolean ans = parseBoolExpr(splits.get(0));
        if (first == '&') {
            for (int i = 1; i < splits.size(); i++) ans &= parseBoolExpr(splits.get(i));
        } else if (first == '|') {
            for (int i = 1; i < splits.size(); i++) ans |= parseBoolExpr(splits.get(i));
        }

        return ans;
    }

    private List<String> splitExpr(String s) {
        List<String> ans = new ArrayList<>();

        int cnt = 0;
        int last = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') cnt ++;
            else if (ch == ')') cnt --;
            else if (cnt == 0 && ch == ',') {
                ans.add(s.substring(last, i));
                last = i + 1;
            }
        }

        if (last < s.length()) ans.add(s.substring(last));

        return ans;
    }


    public static void main(String[] args) {
        System.out.println(new P1106_ParsingABooleanExpression().parseBoolExpr("!(f)"));
        System.out.println(new P1106_ParsingABooleanExpression().parseBoolExpr("|(f,t)"));
        System.out.println(new P1106_ParsingABooleanExpression().parseBoolExpr("&(t,f)"));
        System.out.println(new P1106_ParsingABooleanExpression().parseBoolExpr("|(&(t,f,t),!(t))"));
    }
}
