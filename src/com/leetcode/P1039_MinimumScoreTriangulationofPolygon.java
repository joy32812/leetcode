package com.leetcode;

import java.util.*;

public class P1039_MinimumScoreTriangulationofPolygon {

    Map<String, Integer> ansMap;
    public int minScoreTriangulation(int[] A) {
        ansMap = new HashMap<>();
        return dp(A, A[0], A[1], 2, A.length - 1);
    }

    private int dp(int[] A, int x, int y, int l, int r) {
        if (l > r) return 0;
        if (l == r) return x * y * A[l];

        String key = l + "_" + r;
        if (ansMap.containsKey(key)) return ansMap.get(key);

        int result = Integer.MAX_VALUE;
        for (int i = l; i <= r; i++) {
            result = Math.min(result, dp(A, A[i], y, l, i - 1) + x * y * A[i] + dp(A, x, A[i], i + 1, r));
        }

        ansMap.put(key, result);
        return result;
    }


    public static void main(String[] args) {

        System.out.println(new P1039_MinimumScoreTriangulationofPolygon().minScoreTriangulation(new int[]{5, 5, 1, 4, 2}));

//        System.out.println(new AA3().minScoreTriangulation(new int[]{1,3,1,4,1,5}));
//        System.out.println(new AA3().minScoreTriangulation(new int[]{3, 7, 4, 5}));
//        System.out.println(new AA3().minScoreTriangulation(new int[]{74,40,57,4,85,40,19,29,42,8,34,97,14,47,12,53,32,45,9,36}));

    }

}
