package com.leetcode;

import java.util.Arrays;

public class P976_LargestPerimeterTriangle {


    /**
     * greedy algorithm
     * @param A
     * @return
     */
    public int largestPerimeter(int[] A) {

        Arrays.sort(A);


        for (int i = A.length - 1; i >= 2; i --) {
            int c = A[i];
            int b = A[i - 1];
            int a = c - b;

            if (A[i - 2] > a) return A[i] + A[i - 1] + A[i - 2];
            else continue;
        }

        return 0;

    }


    public static void main(String[] args) {

        System.out.println(new P976_LargestPerimeterTriangle().largestPerimeter(new int[]{2, 1, 2}));

    }

}
