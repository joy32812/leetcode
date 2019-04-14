package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class P1027_LongestArithmeticSequence {

    /**
     * use array as possible
     * hashmap may TLE!
     * @param A
     * @return
     */
    public int longestArithSeqLength(int[] A) {
        int n = A.length;

        Map<Integer, Map<Integer, Integer>> dpMap = new HashMap<>();
        int[][] dp = new int[2 * 10000 + 10][n];

        int ans = 2;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int diff = 10000 + A[j] - A[i];
//                Map<Integer, Integer> diffMap = dpMap.computeIfAbsent(diff, k -> new HashMap<>());
//                if (diffMap.getOrDefault(j, 1) < diffMap.getOrDefault(i, 1) + 1) {
//                    ans = Math.max(ans, diffMap.getOrDefault(i, 1) + 1);
//                    diffMap.put(j, diffMap.getOrDefault(i, 1) + 1);
//                }


                if (dp[diff][j] < dp[diff][i] + 1) {
                    dp[diff][j] = dp[diff][i] + 1;
                    ans = Math.max(ans, dp[diff][j] + 1);
                }
            }
        }

        return ans;

    }


    public static void main(String[] args) {
//        System.out.println(new AA3().longestArithSeqLength(new int[]{0,8,45,88,48,68,28,55,17,24}));
//        System.out.println(new AA3().longestArithSeqLength(new int[]{24,13,1,100,0,94,3,0,3}));
        System.out.println(new P1027_LongestArithmeticSequence().longestArithSeqLength(new int[]{20,1,15,3,10,5,8}));
//        System.out.println(new AA3().longestArithSeqLength(new int[]{3, 6, 9, 12}));
//        System.out.println(new AA3().longestArithSeqLength(new int[]{9, 4, 7, 2, 10}));
//        System.out.println(new AA3().longestArithSeqLength(new int[]{20,1,15,3,10,5,8}));
    }

}
