package com.leetcode;

/**
 * Created by xiaoyuan on 22/08/2017.
 */
public class P546_RemoveBoxes {

    int[][][] dp;
    int[] B;
    public int removeBoxes(int[] boxes) {
        if (boxes == null || boxes.length == 0) {return 0;}

        B = boxes;
        int n = boxes.length;

        dp = new int[n + 1][n + 1][n + 1];

        return dfs(0, n - 1, 0);
    }

    private int dfs(int l, int r, int k) {
        if (l > r) {return 0;}
        if (dp[l][r][k] > 0) {return dp[l][r][k];}
        if (l == r) {return dp[l][r][k] = (k + 1) * (k + 1);}

        int nk = k + 1;
        int m = r + 1;
        for (int i = l + 1; i <= r; i++) {
            if (B[i] == B[l]) {nk++;}
            else {
                m = i;
                break;
            }
        }

        dp[l][r][k] = nk * nk + dfs(m, r, 0);


        for (int i = m; i <= r; i++) {
            if (B[i] != B[l]) {continue;}

            dp[l][r][k] = Math.max(dp[l][r][k], dfs(m, i - 1, 0) + dfs(i, r, nk));
        }

        return dp[l][r][k];
    }

    public static void main(String[] args) {
        System.out.println(new P546_RemoveBoxes().removeBoxes(new int[]{1, 3, 2, 2, 2, 3, 4, 3, 1}));
    }

}
