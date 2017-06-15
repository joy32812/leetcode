package com.leetcode;

/**
 * Created by xiaoyuan on 15/06/2017.
 */
public class P492_ConstructtheRectangle {

    public int[] constructRectangle(int area) {

        int sqrt = (int)Math.sqrt(1.0 + area);

        int W = 0;
        for (int i = 1; i <= sqrt; i++) {
            if (area % i != 0) {continue;}
            int L = area / i;
            if (i <= L) {
                W = i;
            }
        }

        return new int[]{area / W, W};
    }

}
