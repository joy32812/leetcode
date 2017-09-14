package com.leetcode;

/**
 * Created by xiaoyuan on 14/09/2017.
 */
public class P471_EncodeStringwithShortestLength {

    public String encode(String s) {
        if (s == null || s.length() <= 4) {return s;}

        int n = s.length();

        String[][] dp = new String[n][n];

        for (int l = 1; l <= n; l++) {
            for (int i = 0; i < n; i++) {

                int j = i + l - 1;
                if (j >= n) {continue;}

                String now = s.substring(i, j + 1);
                dp[i][j] = now;

                if (l <= 4) {
                    continue;
                }

                for (int k = i; k < j; k++) {
                    if (dp[i][j].length() > dp[i][k].length() + dp[k + 1][j].length()) {
                        dp[i][j] = dp[i][k] + dp[k + 1][j];
                    }
                }

                for (int k = i; k < j; k++) {
                    int len = k - i + 1;
                    if (l % len != 0) continue;

                    String tmp = s.substring(i, k + 1);
                    if (!now.replaceAll(tmp, "").equals("")) continue;

                    String z = l / len + "[" + dp[i][k] +  "]";
                    if (dp[i][j].length() > z.length()) {
                        dp[i][j] = z;
                    }
                }

            }
        }

        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        System.out.println(new P471_EncodeStringwithShortestLength().encode("aaaaaaaaaa"));
        System.out.println(new P471_EncodeStringwithShortestLength().encode("abbbabbbcabbbabbbc"));
    }

}
