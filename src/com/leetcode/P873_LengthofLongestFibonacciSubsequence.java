package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P873_LengthofLongestFibonacciSubsequence {


    public int lenLongestFibSubseq(int[] A) {

        int n = A.length;
        Map<Integer, Integer> posMap = new HashMap<>();
        for (int i = 0; i < n; i++) posMap.put(A[i], i);

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

                int small = A[j] - A[i];
                if (small < A[i] && posMap.containsKey(small)) continue;

                int cnt = 2;
                int x = A[i];
                int y = A[j];
                while (posMap.containsKey(x + y)) {
                    cnt ++;
                    int z = x + y;
                    x = y;
                    y = z;
                }

                if (cnt > 2) ans = Math.max(ans, cnt);
            }

        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new P873_LengthofLongestFibonacciSubsequence().lenLongestFibSubseq(new int[]{1, 2, 3, 4, 5, 6, 7, 8}));
    }

}
