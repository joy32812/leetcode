package com.leetcode;

import java.util.*;

public class P1000_MinimumCosttoMergeStones {


    boolean[][][] visit;
    int[][][] dp;
    int[] sums;
    int SK;

    public int mergeStones(int[] stones, int K) {
        int N = stones.length;
        if (N == 1) return 0;
        if ((N - 1) % (K-1) != 0) return -1;

        SK = K;
        dp = new int[N][N][N + 1];
        visit = new boolean[N][N][N + 1];
        sums = new int[N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) Arrays.fill(dp[i][j], Integer.MAX_VALUE);
        }
        for (int i = 0; i < N; i++) sums[i] = (i - 1 >=0 ? sums[i - 1] : 0) + stones[i];

        return dfs(0, N - 1, 1);
    }

    private int dfs(int l, int r, int k) {
        if (visit[l][r][k]) return dp[l][r][k];
        visit[l][r][k] = true;

        int n = r - l + 1;

        int nowSum = sums[r] - (l - 1 >= 0 ? sums[l - 1] : 0);
        if (l == r && k == 1) return dp[l][r][k] = 0;

        if (k == 1) {
            if ((n - 1) % (SK - 1) != 0) return Integer.MAX_VALUE;

            int v = dfs(l, r, SK);
            if (v == Integer.MAX_VALUE) return dp[l][r][k];

            return dp[l][r][k] = Math.min(dp[l][r][k], v + nowSum);
        }


        if (dp[l][r][k] != Integer.MAX_VALUE) return dp[l][r][k];


        for (int z = l; z < r; z ++) {
            int left = dfs(l, z, 1);
            int right = dfs(z + 1, r,  k - 1);
            if (left == Integer.MAX_VALUE || right == Integer.MAX_VALUE) continue;

            dp[l][r][k] = Math.min(dp[l][r][k], left + right);
        }

        return dp[l][r][k];
    }


    public static void main(String[] args) {

        System.out.println(new P1000_MinimumCosttoMergeStones().mergeStones(new int[]{25,68,35,62,52,57,35,83,40,51,30,20,51}, 7));

//        System.out.println(new P1000_MinimumCosttoMergeStones().mergeStones(new int[]{1,2}, 2));
//        System.out.println(new P1000_MinimumCosttoMergeStones().mergeStones(new int[]{3,5,1,2,6}, 3));
//        System.out.println(new P1000_MinimumCosttoMergeStones().mergeStones(new int[]{3,2,4,1}, 2));
//        System.out.println(new P1000_MinimumCosttoMergeStones().mergeStones(new int[]{69,39,79,78,16,6,36,97,79,27,14,31,4}, 2));

    }

}
