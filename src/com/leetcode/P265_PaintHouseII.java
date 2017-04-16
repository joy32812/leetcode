package com.leetcode;

/**
 * Created by xiaoyuan on 16/04/2017.
 */
public class P265_PaintHouseII {

    private int[] leftMin;
    private int[] rightMin;

    public int minCostII(int[][] costs) {
        if (costs.length == 0) {return 0;}

        int m = costs.length;
        int n = costs[0].length;


        leftMin = new int[n];
        rightMin = new int[n];
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            initMinArray(dp, i - 1);
            for (int j = 0; j < n; j++) {
                dp[i][j] = costs[i][j] + getMin(j);
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {ans = Math.min(ans, dp[m - 1][i]);}
        return ans;
    }

    private int getMin(int x) {
        int left = Integer.MAX_VALUE;
        if (x > 0) {left = leftMin[x - 1];}

        int right = Integer.MAX_VALUE;
        if (x < rightMin.length - 1) {right = rightMin[x + 1];}

        return Math.min(left, right) == Integer.MAX_VALUE ? 0 : Math.min(left, right);
    }

    private void initMinArray(int[][] dp, int x) {
        if (x < 0) {return;}

        for (int i = 0; i < dp[x].length; i++) {
            leftMin[i] = Math.min(i == 0 ? Integer.MAX_VALUE : leftMin[i - 1], dp[x][i]);
        }

        for (int i = dp[x].length - 1; i >= 0; i--) {
            rightMin[i] = Math.min(i == dp[x].length - 1 ? Integer.MAX_VALUE : rightMin[i + 1], dp[x][i]);
        }
    }

    public static void main(String[] args) {
        System.out.println(new P265_PaintHouseII().minCostII(new int[][]{{8}}));
    }

}
