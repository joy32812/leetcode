package com.leetcode;

/**
 * Created by xiaoyuan on 17/09/2017.
 */
public class P678_ValidParenthesisString {

    public boolean checkValidString(String s) {
        if (s.length() == 0) {return true;}

        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for (int k = 1; k <= n; k++) {
            for (int i = 0; i < n; i++) {
                int j = i + k - 1;
                if (j >= n) {continue;}

                if (i == j) {
                    dp[i][j] = s.charAt(i) == '*';
                    continue;
                }

                for (int z = i; z < j; z++) {
                    if (dp[i][z] && dp[z + 1][j]) {
                        dp[i][j] = true;
                        break;
                    }

                    char lch = s.charAt(i);
                    char rch = s.charAt(j);
                    if (isLeft(lch) && isRight(rch) && (i + 1 > j - 1 || dp[i + 1][j - 1])) {
                        dp[i][j] = true;
                        break;
                    }
                }
            }
        }

        return dp[0][n - 1];
    }

    private boolean isRight(char rch) {
        return rch == '*' || rch == ')';
    }

    private boolean isLeft(char lch) {
        return lch == '*' || lch == '(';
    }

    public static void main(String[] args) {
        System.out.println(new P678_ValidParenthesisString().checkValidString("()"));
        System.out.println(new P678_ValidParenthesisString().checkValidString("(*)"));
        System.out.println(new P678_ValidParenthesisString().checkValidString("(*)))"));
    }

}
