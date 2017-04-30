package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoyuan on 30/04/2017.
 */
public class P313_SuperUglyNumber {

    public int nthSuperUglyNumber(int n, int[] primes) {
        if (n == 1) {return 1;}

        List<Integer> uglyNums = new ArrayList<>();
        uglyNums.add(1);

        int k = primes.length;
        int[] indexs = new int[k];

        int cnt = 1;
        while (cnt < n) {
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < k; i++) {
                if (primes[i] == 1) {continue;}
                min = Math.min(min, uglyNums.get(indexs[i]) * primes[i]);
            }

            uglyNums.add(min);
            for (int i = 0; i < k; i++) {
                if (primes[i] == 1) {continue;}
                if (uglyNums.get(indexs[i]) * primes[i] == min) {
                    indexs[i]++;
                }
            }
            cnt++;
        }

        return uglyNums.get(uglyNums.size() - 1);
    }

    public static void main(String[] args) {
        System.out.println(new P313_SuperUglyNumber().nthSuperUglyNumber(10, new int[]{2, 7, 13, 19}));
    }

}
