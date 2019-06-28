package com.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class P1072_FlipColumnsForMaximumNumberofEqualRows {

    /**
     * find rows with same structure
     * @param matrix
     * @return
     */
    public int maxEqualRowsAfterFlips(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        Map<String, Set<Integer>> cntMap = new HashMap<>();

        for (int i = 0; i < m; i++) {
            StringBuilder sb1 = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    sb1.append(j + "_");
                } else {
                    sb2.append(j + "_");
                }
            }

            cntMap.computeIfAbsent(sb1.toString(), k -> new HashSet<>()).add(i);
            cntMap.computeIfAbsent(sb2.toString(), k -> new HashSet<>()).add(i);
        }

        int ans = 0;

        for (String k : cntMap.keySet()) {
            ans = Math.max(ans, cntMap.get(k).size());
        }

        return ans;
    }

}
