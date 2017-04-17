package com.leetcode;

/**
 * Created by xiaoyuan on 17/04/2017.
 */
public class P276_PaintFence {

    public int numWays(int n, int k) {

        if (n == 0 || k == 0) {return 0;}


        int same = 0;
        int noSame = k;
        n--;
        while (n > 0) {
            int a = noSame;
            int b = (same + noSame) * (k - 1);

            same = a;
            noSame = b;
            n--;
        }

        return same + noSame;
    }

    public static void main(String[] args) {
        System.out.println(new P276_PaintFence().numWays(10, 2));
    }

}
