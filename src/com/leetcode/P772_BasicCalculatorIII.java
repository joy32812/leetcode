package com.leetcode;

import java.util.Stack;

public class P772_BasicCalculatorIII {

    public int calculate(String s) {
        if (s == null) return 0;
        s = s.replaceAll(" ", "");
        if (s.length() == 0) return 0;

        return (int) dfs(s);
    }

    private long dfs(String s) {
        if (s.length() == 0) return 0;
        if (s.indexOf('(') >= 0) {
            int[] pair = new int[s.length()];
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (ch == '(') {
                    stack.push(i);
                } else if (ch == ')') {
                    pair[stack.pop()] = i;
                }
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (ch == '(') {
                    long val = dfs(s.substring(i + 1, pair[i]));
                    if (val < 0) {
                        sb.append("@");
                    }
                    sb.append(Math.abs(val));
                    i = pair[i];
                } else {
                    sb.append(ch);
                }
            }

            return dfs(sb.toString());
        }
        char[] ops = {'+', '-'};
        for (char op : ops) {
            if (s.indexOf(op) >= 0) {
                String[] split = s.split("[" + op + "]");
                long ans = dfs(split[0]);
                for (int i = 1; i < split.length; i++) {
                    long val = dfs(split[i]);

                    if (op == '+') ans += val;
                    else if (op == '-') ans -= val;
                }

                return ans;
            }
        }

        if (s.indexOf('*') == -1 && s.indexOf('/') == -1) return Long.parseLong(s.replaceAll("@", "-"));

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '*') return dfs(s.substring(0, i)) * dfs(s.substring(i + 1));
            if (s.charAt(i) == '/') return dfs(s.substring(0, i)) / dfs(s.substring(i + 1));
        }

        return 0;
    }

//    (((8+3)*(4-10))-2)+((5+(10/2))+((9+5)+(2+2)))
    public static void main(String[] args) {
        System.out.println(new P772_BasicCalculatorIII().calculate("(((8+3)*(4-10))-2)"));
        System.out.println(new P772_BasicCalculatorIII().calculate("((5+(10/2))+((9+5)+(2+2)))"));
        System.out.println(new P772_BasicCalculatorIII().calculate("(((8+3)*(4-10))-2)+((5+(10/2))+((9+5)+(2+2)))"));
        System.out.println(new P772_BasicCalculatorIII().calculate("(((8+3)*(4-10))-2)+((5+(10/2))+((9+5)+(2+2)))"));
//        System.out.println(new P772_BasicCalculatorIII().calculate("4 + (5-(1-(2+4-(5+6))))"));
//        System.out.println(new P772_BasicCalculatorIII().calculate("5-(1-(2+4-(5+6)))"));
//        System.out.println(new P772_BasicCalculatorIII().calculate("(2+3-(4+(5-(1-(2+4-(5+6))))))"));
//        System.out.println(new P772_BasicCalculatorIII().calculate("1-(2+3-(4+(5-(1-(2+4-(5+6))))))"));
//        System.out.print(new P772_BasicCalculatorIII().calculate("-2-7"));
//        System.out.print(new P772_BasicCalculatorIII().calculate("(2+6* 3+5- (3*14/7+2)*5)+3"));
//        System.out.print(new P772_BasicCalculatorIII().calculate("2-(5-6)"));
//        System.out.print(new P772_BasicCalculatorIII().calculate("2*(5+5*2)/3+(6/2+8)"));
    }

}
