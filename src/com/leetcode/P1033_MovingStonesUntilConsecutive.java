package com.leetcode;

import java.util.Arrays;

public class P1033_MovingStonesUntilConsecutive {

    /**
     * easy
     * careful: when there is a gap
     * @param a
     * @param b
     * @param c
     * @return
     */
    public int[] numMovesStones(int a, int b, int c) {

        int[] arr = new int[]{a, b, c};
        Arrays.sort(arr);

        a = arr[0];
        b = arr[1];
        c = arr[2];

        int min = Math.min(1, b - a - 1) + Math.min(1, c - b - 1);
        if (b - a - 1 == 1 || c - b - 1 == 1) min = 1;

        return new int[]{min, c - a - 2};
    }


    public static void main(String[] args) {
        System.out.println(new P1033_MovingStonesUntilConsecutive().numMovesStones(3, 7, 1));
    }

}
