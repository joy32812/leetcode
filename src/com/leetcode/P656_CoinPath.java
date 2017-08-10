package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xiaoyuan on 10/08/2017.
 */
public class P656_CoinPath {

    public List<Integer> cheapestJump(int[] A, int B) {

        List<Integer> ans = new ArrayList<>();

        int n = A.length;
        int[] dp = new int[n];
        int[] next = new int[n];
        Arrays.fill(next, -1);

        for (int i = n - 2; i >= 0; i--) {
            if (A[i] == -1) {continue;}

            int cost = Integer.MAX_VALUE;
            for (int j = i + 1; j <= i + B && j < n; j++) {
                if (A[j] < 0) {continue;}


                if (cost > dp[j] + A[i]) {
                    cost = dp[j] + A[i];
                    next[i] = j;
                }
            }

            dp[i] = cost;
        }


        int x = 0;
        while (next[x] != -1) {
            ans.add(x + 1);
            x = next[x];
        }

        if (x != n - 1) {
            return new ArrayList<>();
        }

        ans.add(n);

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new P656_CoinPath().cheapestJump(new int[]{0, 0, 0, 0, 0, 0}, 3));
        System.out.println(new P656_CoinPath().cheapestJump(new int[]{0, -1, -1, -1, 0, 0}, 3));
        System.out.println(new P656_CoinPath().cheapestJump(new int[]{1, 2, 4, -1, 2}, 1));
    }

}
