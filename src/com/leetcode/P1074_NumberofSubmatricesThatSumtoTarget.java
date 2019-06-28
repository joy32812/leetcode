package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class P1074_NumberofSubmatricesThatSumtoTarget {

    /**
     * O(N^3)
     * @param matrix
     * @param target
     * @return
     */
    public int numSubmatrixSumTarget(int[][] matrix, int target) {

        int m = matrix.length;
        int n = matrix[0].length;

        int ans = 0;
        for (int i = 0; i < m; i++) {

            int[] sum = new int[n];
            for (int j = i; j < m; j++) {
                for (int k = 0; k < n; k++) sum[k] += matrix[j][k];

                Map<Integer, Integer> cntMap = new HashMap<>();
                cntMap.put(0, 1);

                int now = 0;
                for (int k = 0; k < n; k++) {
                    now += sum[k];

                    ans += cntMap.getOrDefault(now - target, 0);
                    cntMap.put(now, cntMap.getOrDefault(now, 0) + 1);
                }
            }
        }

        return ans;
    }

}
