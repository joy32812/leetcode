package com.leetcode;

/**
 * Created by xiaoyuan on 18/05/2017.
 */
public class P372_SuperPow {

    private int K = 1337;
    private int[] first11;
    public int superPow(int a, int[] b) {
        first11 = new int[11];
        for (int i = 0; i <= 10; i++) {
            first11[i] = getMod(a, i);
        }

        return work(a, b.length - 1, b);
    }

    private int work(int a, int r, int[] b) {
        if (r == 0) {
            return first11[b[0]];
        }

        return (getMod(work(a, r - 1, b) % K, 10) % K) * first11[b[r]] % K;
    }


    private int getMod(long a, int x) {
        long ans = 1;
        for (int i = 1; i <= x; i++) {
            ans = (ans * a) % K;
        }
        return (int)ans;
    }

    public static void main(String[] args) {
        System.out.println(new P372_SuperPow().superPow(2147483647, new int[]{2, 0, 0}));
    }


}
