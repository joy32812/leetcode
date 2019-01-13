package com.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class P967_NumbersWithSameConsecutiveDifferences {


    public int[] numsSameConsecDiff(int N, int K) {


        Set<Integer> ansSet = new HashSet<>();
        ansSet.addAll(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));

        int cnt = 1;
        while (cnt < N) {
            Set<Integer> nowSet = new HashSet<>();

            for (int v : ansSet) {
                int z = v % 10;

                if (z >= K) {
                    nowSet.add(v * 10 + (z - K));
                }

                if (z + K <= 9) {
                    nowSet.add(v * 10 + (z + K));
                }
            }
            ansSet = nowSet;
            cnt++;
        }

        Set<Integer> integerSet = ansSet.stream().filter(k -> ("" + k).length() == N).collect(Collectors.toSet());

        int[] ansArr = new int[integerSet.size()];
        int id = 0;
        for (int v : integerSet) {
            ansArr[id++] = v;
        }

        return ansArr;
    }


    public static void main(String[] args) {

        System.out.println(new P967_NumbersWithSameConsecutiveDifferences().numsSameConsecDiff(3, 7));
    }

}
