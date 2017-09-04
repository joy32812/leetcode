package com.leetcode;

import java.util.*;

/**
 * Created by xiaoyuan on 04/09/2017.
 */
public class P446_ArithmeticSlicesIISubsequence {


    public int numberOfArithmeticSlices(int[] A) {
        int ans = 0;
        Map<Integer, Integer>[] map = new Map[A.length];

        for (int i = 0; i < A.length; i++) {
            map[i] = new HashMap<>();

            for (int j = 0; j < i; j++) {
                long diff = (long)A[i] - A[j];
                if (diff < Integer.MIN_VALUE || diff > Integer.MAX_VALUE) continue;

                int d = (int)diff;
                int c1 = map[i].getOrDefault(d, 0);
                int c2 = map[j].getOrDefault(d, 0);

                ans += c2;

                map[i].put(d, c1 + c2 + 1);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new P446_ArithmeticSlicesIISubsequence().numberOfArithmeticSlices(new int[]{79,20,64,28,67,81,60,58,97,85,92,96,82,89,46,50,15,2,36,44,54,2,90,37,7,79,26,40,34,67,64,28,60,89,46,31,9,95,43,19,47,64,48,95,80,31,47,19,72,99,28,46,13,9,64,4,68,74,50,28,69,94,93,3,80,78,23,80,43,49,77,18,68,28,13,61,34,44,80,70,55,85,0,37,93,40,47,47,45,23,26,74,45,67,34,20,33,71,48,96}));
        System.out.println(new P446_ArithmeticSlicesIISubsequence().numberOfArithmeticSlices(new int[]{0,2000000000,-294967296}));
        System.out.println(new P446_ArithmeticSlicesIISubsequence().numberOfArithmeticSlices(new int[]{2, 2, 3, 3, 4, 5}));
        System.out.println(new P446_ArithmeticSlicesIISubsequence().numberOfArithmeticSlices(new int[]{1, 2, 3, 4, 5, 6}));
        System.out.println(new P446_ArithmeticSlicesIISubsequence().numberOfArithmeticSlices(new int[]{2, 4, 6, 8, 10}));
    }

}
