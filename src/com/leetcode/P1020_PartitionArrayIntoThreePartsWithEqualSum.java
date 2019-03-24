package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class P1020_PartitionArrayIntoThreePartsWithEqualSum {


    /**
     * check if 2 * S and 3 * S exist
     * @param A
     * @return
     */
    public boolean canThreePartsEqualSum(int[] A) {

        int n = A.length;
        int[] sum = new int[n];

        for (int i = 0; i < n; i++) sum[i] = A[i] + (i - 1 >= 0 ? sum[i - 1] : 0);

        Map<Integer, Integer> cntMap = new HashMap<>();
        for (int i = 0; i < n - 1; i++) {
            cntMap.put(sum[i], cntMap.getOrDefault(sum[i],0) + 1);
        }

        for (int i = 0; i < n; i++) {
            cntMap.put(sum[i], cntMap.getOrDefault(sum[i], 0) - 1);
            if (sum[n - 1] != sum[i] * 3) continue;

            if (cntMap.getOrDefault(2 * sum[i], 0) > 0) return true;
        }


        return false;
    }


    public static void main(String[] args) {

    }

}
