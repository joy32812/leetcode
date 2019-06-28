package com.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class P1096_BraceExpansionII {


    /**
     * split and compute
     * order is very important
     * @param expression
     * @return
     */
    public List<String> braceExpansionII(String expression) {

        Set<String> ans = dfs(expression);
        List<String> aa = ans.stream().collect(Collectors.toList());
        Collections.sort(aa);

        return aa;
    }

    private Set<String> dfs(String expr) {
        expr = change(expr);
        if (expr.indexOf(',') == -1 && expr.indexOf('{') == -1) {
            Set<String> ans = new HashSet<>();
            ans.add(expr);
            return ans;
        }

        List<String> sp1 = doSplitByComma(expr);

        if (sp1.size() == 1) {
            List<String> sp2 = doSplitByMul(expr);

            Set<String> ans = new HashSet<>();
            for (String s : sp2) {
                if (ans.size() == 0) ans = dfs(s);
                else {

                    Set<String> total = new HashSet<>();
                    Set<String> now = dfs(s);
                    for (String x : ans) {
                        for (String y : now) total.add(x + y);
                    }

                    ans = total;
                }
            }

            return ans;
        } else {
            Set<String> ans = new HashSet<>();
            for (String s : sp1) ans.addAll(dfs(s));
            return ans;
        }

    }

    private String change(String expr) {
        if (expr.charAt(0) != '{') return expr;

        int cnt = 0;
        for (int i = 0; i < expr.length(); i++) {
            char ch = expr.charAt(i);
            if (ch == '{') cnt++;
            else if (ch == '}') cnt--;

            if (cnt == 0 && i != expr.length() - 1) return expr;
        }

        return expr.substring(1, expr.length() - 1);
    }

    private List<String> doSplitByMul(String expression) {
        int cnt = 0;
        int last = 0;

        List<String> ans = new ArrayList<>();
        for (int i = 0; i < expression.length(); i ++) {
            if (expression.charAt(i) == '{' && cnt == 0 && expression.charAt(last) != '{') {
                String now = expression.substring(last, i);
                if (now.length() > 0) ans.add(now);
                last = i;
            }


            if (expression.charAt(i) == '{') cnt ++;
            else if (expression.charAt(i) == '}') cnt --;

            if (expression.charAt(i) == '}' && cnt == 0) {
//                if (expression.charAt(last) == '{') last ++;
                String now = expression.substring(last, i + 1);
                if (now.length() > 0) ans.add(now);
                last = i + 1;
            }
        }

        if (last != expression.length()) ans.add(expression.substring(last));


        return ans;
    }

    private List<String> doSplitByComma(String expression) {
        int cnt = 0;
        int last = 0;

        List<String> ans = new ArrayList<>();
        for (int i = 0; i < expression.length(); i ++) {
            if (expression.charAt(i) == '{') cnt ++;
            else if (expression.charAt(i) == '}') cnt --;

            if (expression.charAt(i) == ',' && cnt == 0) {
                ans.add(expression.substring(last, i));
                last = i + 1;
            }
        }
        if (last != expression.length()) ans.add(expression.substring(last));

        return ans;
    }

}
