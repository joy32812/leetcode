package com.leetcode;

/**
 * Created by xiaoyuan on 08/05/2017.
 */
public class P343_IntegerBreak {

    private long[] ans;
    public int integerBreak(int n) {
        ans = new long[n + 1];
        ans[1] = 1;

        return (int)work(n);
    }

    private long work(int n) {
        if (ans[n] != 0) {return ans[n];}

        for (int i = 1; i <= n - 1 ;i++) {
            ans[n] = Math.max(ans[n], i * (n - i));
            ans[n] = Math.max(ans[n], work(i) * (n - i));
            ans[n] = Math.max(ans[n], i * work(n - i));
            ans[n] = Math.max(ans[n], work(i) * work(n - i));
        }

        return ans[n];
    }

    public static void main(String[] args) {
        System.out.println(new P343_IntegerBreak().integerBreak(10));
    }

}
