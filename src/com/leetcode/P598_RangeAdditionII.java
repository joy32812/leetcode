package com.leetcode;

/**
 * Created by xiaoyuan on 01/07/2017.
 */
public class P598_RangeAdditionII {

    public int maxCount(int m, int n, int[][] ops) {

        int a = m;
        int b = n;
        for (int[] op : ops) {
            a = Math.min(a, Math.min(m, op[0]));
            b = Math.min(b, Math.min(n, op[1]));
        }

        return a * b;
    }

}
