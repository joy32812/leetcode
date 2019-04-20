package com.leetcode;

public class P844_BackspaceStringCompare {

    public boolean backspaceCompare(String S, String T) {

        String ps = process(S);
        String pt = process(T);
        return ps.equals(pt);
    }

    private String process(String s) {
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (ch == '#') {
                if (sb.length() > 0) sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.append(ch);
            }
        }

        return sb.toString();
    }

}
