package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class P982_TripleswithBitwiseANDEqualToZero {

    /**
     * if A[i] & A[j] == 0 then all the A[k] is ok
     * count the number of (A[i] & A[j])
     * then find the valid A[j]
     * @param A
     * @return
     */
    public int countTriplets(int[] A) {

        int total = 0;
        Map<Integer, Integer> cntMap = new HashMap<>();

        for (int i = 0; i < A.length; i++) {

            for (int j = 0; j < A.length; j++) {

                int result = (A[i] & A[j]);

                if (result == 0) total += A.length;
                else {
                    cntMap.put(result, cntMap.getOrDefault(result, 0) + 1);
                }
            }
        }

        for (int key : cntMap.keySet()) {
            for (int i = 0; i < A.length; i++) {
                if ((key & A[i]) == 0) total += cntMap.get(key);
            }
        }

        return total;
    }



    public static void main(String[] args) {

    }

}
