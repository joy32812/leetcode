package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by xiaoyuan on 16/03/2017.
 *
 * 简单dp
 * 不过卡常数, 有点没意思
 */
public class P132_PalindromePartitioningII {

    private int n;

    public int minCut(String s) {
        if (s.length() == 0) {return 0;}

        char[] c = s.toCharArray();
        n = s.length();

        boolean[][] isPal = new boolean[n][n];
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            int cut = Integer.MAX_VALUE;
            for (int j = 0; j <= i; j++) {
                if (c[i] == c[j] && (j + 1 > i - 1 || isPal[j + 1][i - 1])) {
                    isPal[j][i] = true;
                    cut = Math.min(cut, 1 + (j - 1 < 0 ? 0 : dp[j - 1]));
                }
            }
            dp[i] = cut;
        }

        return dp[n - 1] - 1;
    }

    public static void main(String[] args) {
        System.out.println(new P132_PalindromePartitioningII().minCut("aabbaaa"));
    }

}
