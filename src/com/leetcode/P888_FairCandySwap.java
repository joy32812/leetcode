package com.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class P888_FairCandySwap {

    public int[] fairCandySwap(int[] A, int[] B) {

        int sum1 = Arrays.stream(A).sum();
        int sum2 = Arrays.stream(B).sum();
        int sum = (sum1 + sum2) / 2;


        Set<Integer> bSet = Arrays.stream(B).boxed().collect(Collectors.toSet());

        for (int d : A) {
            int need = sum - (sum1 - d);
            if (bSet.contains(need)) return new int[]{d, need};
        }

        return new int[]{0, 0};
    }

}
