package com.leetcode;

/**
 * Created by xiaoyuan on 07/06/2017.
 */
public class P441_ArrangingCoins {

    public int arrangeCoins(int n) {
        if (n <= 1) {return n;}

        long l = 1;
        long r = n;

        while (l < r) {
            long m = (l + r) / 2;

            if (m * (m + 1) / 2 <= n) {
                l = m + 1;
            } else {
                r = m;
            }
        }

        return (int)(l - 1);
    }

    public static void main(String[] args) {
        System.out.println(new P441_ArrangingCoins().arrangeCoins(3));
        System.out.println(new P441_ArrangingCoins().arrangeCoins(4));
        System.out.println(new P441_ArrangingCoins().arrangeCoins(5));
        System.out.println(new P441_ArrangingCoins().arrangeCoins(6));
        System.out.println(new P441_ArrangingCoins().arrangeCoins(7));
        System.out.println(new P441_ArrangingCoins().arrangeCoins(8));
    }

}
