package com.leetcode;

public class P856_ScoreofParentheses {

    public int scoreOfParentheses(String S) {

        if (S == null || S.length() == 0) return 0;

        int ans = 0;

        int from = 0;
        int flag = 0;
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            if (ch == '(') flag ++;
            else flag --;

            if (flag == 0) {
                if (from + 1 == i) {
                    ans += 1;
                } else {
                    ans += 2 * scoreOfParentheses(S.substring(from + 1, i));
                }

                from = i + 1;
            }
        }

        return ans;
    }

}
