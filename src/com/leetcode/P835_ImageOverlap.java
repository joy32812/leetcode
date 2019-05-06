package com.leetcode;

import java.util.*;

public class P835_ImageOverlap {


    public int largestOverlap(int[][] A, int[][] B) {

        List<int[]> aList = getList(A);
        List<int[]> bList = getList(B);

        Map<String, Integer> cntMap = new HashMap<>();

        for (int[] x : aList) {
            for (int[] y : bList) {
                String key = (y[0] - x[0]) + "_" + (y[1] - x[1]);
                cntMap.put(key, cntMap.getOrDefault(key, 0) + 1);
            }
        }

        int ans = 0;
        for (int d : cntMap.values()) ans = Math.max(ans, d);

        return ans;
    }

    private List<int[]> getList(int[][] a) {
        List<int[]> list = new ArrayList<>();

        int m = a.length;
        int n = a[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] == 1) list.add(new int[]{i, j});
            }
        }

        return list;
    }

    public static void main(String[] args) {
        System.out.println(new P835_ImageOverlap().largestOverlap(new int[][]{
                {1, 1, 0},
                {0, 1, 0},
                {0, 1, 0}
        }, new int[][]{
                {0, 0, 0},
                {0, 1, 1},
                {0, 0, 1}
        }));
    }


}
