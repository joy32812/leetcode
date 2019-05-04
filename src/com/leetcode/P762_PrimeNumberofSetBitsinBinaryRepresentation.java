package com.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class P762_PrimeNumberofSetBitsinBinaryRepresentation {

    public int countPrimeSetBits(int L, int R) {

        Set<Integer> primeSet = new HashSet<>(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23));

        int ans = 0;
        for (int i = L; i <= R; i++) {
            String binStr = Integer.toBinaryString(i);
            int len = binStr.replaceAll("0", "").length();
            if (primeSet.contains(len)) ans ++;
        }

        return ans;
    }

}
