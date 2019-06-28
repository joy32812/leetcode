package com.leetcode;

import java.util.Arrays;

public class P1092_ShortestCommonSupersequence {

    /**
     * hard
     * reverse of LCS
     *
     * @param str1
     * @param str2
     * @return
     */
    public String shortestCommonSupersequence(String str1, String str2) {

        int m = str1.length();
        int n = str2.length();

        int c = n + 1;

        int[][] dp = new int[m + 1][n + 1];
        int[][] from = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) Arrays.fill(dp[i], Integer.MAX_VALUE);
        dp[0][0] = 0;
        from[0][0] = -1;
        for (int i = 1; i <= m; i++) {
            dp[i][0] = i;
            from[i][0] = (i - 1) * c + 0;
        }
        for (int j = 1; j <= n; j++) {
            dp[0][j] = j;
            from[0][j] = (0) * c + (j - 1);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (dp[i + 1][j + 1] > dp[i + 1][j] + 1) {
                    dp[i + 1][j + 1] = dp[i + 1][j] + 1;
                    from[i + 1][j + 1] = (i + 1) * c + j;
                }


                if (dp[i + 1][j + 1] > dp[i][j + 1] + 1) {
                    dp[i + 1][j + 1] = dp[i][j + 1] + 1;
                    from[i + 1][j + 1] = (i) * c + (j + 1);
                }

                if (str1.charAt(i) == str2.charAt(j)) {
                    if (dp[i + 1][j + 1] > dp[i][j] + 1) {
                        dp[i + 1][j + 1] = dp[i][j] + 1;
                        from[i + 1][j + 1] = (i) * c + (j);
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        int x = m;
        int y = n;
        while (x > 0 || y > 0) {
            int tp = from[x][y];
            int tx = tp / c;
            int ty = tp % c;

            if (x == tx + 1 && y == ty + 1) {
                sb.append(str1.charAt(x - 1));
            } else if (x == tx + 1) {
                sb.append(str1.charAt(x - 1));
            } else {
                sb.append(str2.charAt(y - 1));
            }

            x = tx;
            y = ty;

        }

        return sb.reverse().toString();
    }

}
