package com.leetcode;

import java.util.*;

/**
 * Created by xiaoyuan on 28/03/2017.
 */
public class P174_DungeonGame {

    public int calculateMinimumHP(int[][] dungeon) {

        int m = dungeon.length;
        int n = dungeon[0].length;

        int[][] dp = new int[m + 1][n + 1];
        dp[m][n - 1] = 1;
        dp[m - 1][n] = 1;

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int need = Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j];
                dp[i][j] = need <= 0 ? 1 : need;
            }
        }

        return dp[0][0];
    }

    public static void main(String[] args) {
        int[][] dungeon = {
                {1, -3, 3},
                {0, -2, 0},
                {-3, -3, -3}
        };

        System.out.println(new P174_DungeonGame().calculateMinimumHP(dungeon));
    }
}
