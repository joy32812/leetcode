package com.leetcode;

import java.util.Arrays;

public class P880_DecodedStringatIndex {

    long dp[];
    public String decodeAtIndex(String S, int K) {
        dp = new long[S.length()];
        Arrays.fill(dp, -1);

        getLength(S);
        return dfs(S, K);
    }

    private String dfs(String s, long k) {
        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if (Character.isLetter(ch)) {
                if (dp[i] == k) return "" + ch;
            } else {
                return dfs(s. substring(0, i), (k - 1) % dp[i - 1] + 1);
            }
        }

        return null;
    }

    private long getLength(String s) {
        if (s.length() == 0) return 0;
        if (dp[s.length() - 1] > 0) return dp[s.length() - 1];

        char ch = s.charAt(s.length() - 1);
        if (Character.isLetter(ch)) return dp[s.length() - 1] = getLength(s.substring(0, s.length() - 1)) + 1;
        return dp[s.length() - 1] = getLength(s.substring(0, s.length() - 1)) * Integer.parseInt("" + ch);
    }

    public static void main(String[] args) {
        System.out.println(new P880_DecodedStringatIndex().decodeAtIndex("leet2code3", 10));
    }

}
