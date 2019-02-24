package com.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class P1001_GridIllumination {


    int[] tx = {-1, -1, -1, 0, 0, 1, 1, 1};
    int[] ty = {-1, 0, 1, -1, 1, -1, 0, 1};

    /**
     * easy, just use Map to record the number of every row, col, dia and update
     * @param N
     * @param lamps
     * @param queries
     * @return
     */
    public int[] gridIllumination(int N, int[][] lamps, int[][] queries) {

        Map<Integer, Integer> rowMap = new HashMap<>();
        Map<Integer, Integer> colMap = new HashMap<>();
        Map<Integer, Integer> leftUpMap = new HashMap<>();
        Map<Integer, Integer> rightUpMap = new HashMap<>();


        Set<String> lampSet = new HashSet<>();
        for (int[] lp : lamps) {
            int x = lp[0];
            int y = lp[1];

            lampSet.add(x + "_" + y);

            rowMap.put(x, rowMap.getOrDefault(x, 0) + 1);
            colMap.put(y, colMap.getOrDefault(y, 0) + 1);

            leftUpMap.put(x - y, leftUpMap.getOrDefault(x - y, 0) + 1);
            rightUpMap.put(x + y, rightUpMap.getOrDefault(x + y, 0) + 1);
        }



        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] q = queries[i];

            int x = q[0];
            int y = q[1];

            if (rowMap.getOrDefault(x, 0) > 0 || colMap.getOrDefault(y, 0) > 0
                    || leftUpMap.getOrDefault(x - y, 0) > 0
                    || rightUpMap.getOrDefault(x + y, 0) > 0
            ) {
                ans[i] = 1;
            }

            for (int k = 0; k < tx.length; k++) {
                int nx = x + tx[k];
                int ny = y + ty[k];

                if (lampSet.contains(nx + "_" + ny)) {
                    rowMap.put(nx, rowMap.getOrDefault(nx, 0) - 1);
                    colMap.put(ny, colMap.getOrDefault(ny, 0) - 1);

                    leftUpMap.put(nx - ny, leftUpMap.getOrDefault(nx - ny, 0) - 1);
                    rightUpMap.put(nx + ny, rightUpMap.getOrDefault(nx + ny, 0) - 1);

                    lampSet.remove(nx + "_" + ny);
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {

    }

}
