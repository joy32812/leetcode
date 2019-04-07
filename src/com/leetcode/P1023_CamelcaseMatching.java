package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class P1023_CamelcaseMatching {

    /**
     * dp
     * like edit distance
     * @param queries
     * @param pattern
     * @return
     */
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> ans = new ArrayList<>();

        for (String q : queries) {
            ans.add(check(q, pattern));
        }

        return ans;
    }

    private Boolean check(String q, String pattern) {
        int m = q.length();
        int n = pattern.length();

        boolean[][] dp = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char cs = q.charAt(i);
                char ct = pattern.charAt(j);

                if (cs == ct) {
                    if (okay(dp, i - 1, j - 1, q)) dp[i][j] = true;
                    if (Character.isLowerCase(cs) && okay(dp, i - 1, j, q)) dp[i][j] = true;
                } else {
                    if (Character.isLowerCase(cs) && okay(dp, i - 1, j, q)) dp[i][j] = true;
                }
            }
        }

        return dp[m - 1][n - 1];
    }

    private boolean okay(boolean[][] dp, int x, int y, String q) {
        if (x < 0 && y < 0) return true;
        if (x < 0) return false;
        if (y < 0) {
            String now = q.substring(0, x + 1);
            return now.equals(now.toLowerCase());
        }

        return dp[x][y];
    }


    public static void main(String[] args) {

        System.out.println(new P1023_CamelcaseMatching().camelMatch(new String[]{"FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"}, "FB"));
        System.out.println(new P1023_CamelcaseMatching().camelMatch(new String[]{"FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"}, "FoBa"));
        System.out.println(new P1023_CamelcaseMatching().camelMatch(new String[]{"FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"}, "FoBaT"));
    }
}
