package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P954_ArrayofDoubledPairs {


    /**
     * easy
     * sort and check by order
     * @param A
     * @return
     */
    public boolean canReorderDoubled(int[] A) {

        Map<Integer, Integer> cntMap = new HashMap<>();
        for (int a : A) {
            cntMap.put(a, cntMap.getOrDefault(a, 0) + 1);
        }

        Arrays.sort(A);

        for (int i  = 0; i < A.length; i++) {
            int now = A[i];
            if (cntMap.get(now) == 0) continue;
            cntMap.put(now, cntMap.get(now) - 1);

            int z = 0;
            if (now <= 0) {
                if (now % 2 != 0) return false;

                z = now / 2;
            } else {
                z = now * 2;
            }
            if (cntMap.getOrDefault(z, 0) == 0) return false;

            cntMap.put(z, cntMap.get(z) - 1);
        }

        return true;

    }
    

    public static void main(String[] args) {

        System.out.println((-7 % 2));
    }


}
