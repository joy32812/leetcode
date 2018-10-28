package com.leetcode;

import java.util.Arrays;
import java.util.stream.IntStream;

public class P932_BeautifulArray {


    /**
     * divide and conquer
     * dp
     *
     * @param N
     * @return
     */
    public int[] beautifulArray(int N) {

        if (N == 1) return new int[]{1};
        if (N == 2) return new int[]{1, 2};


        int[] left = beautifulArray(N / 2);
        int[] right = beautifulArray(N - N / 2);

        int[] ll = Arrays.stream(left).map(k -> k * 2).toArray();
        int[] rr = Arrays.stream(right).map(k -> k * 2 - 1).toArray();

        return IntStream.concat(Arrays.stream(ll), Arrays.stream(rr)).toArray();
    }

    public static void main(String[] args) {

        int[] ints = new P932_BeautifulArray().beautifulArray(1000);

        System.out.println(ints);

    }

}
