package com.leetcode;

/**
 * Created by xiaoyuan on 19/02/2017.
 *
 * 通过移位表示*2计算, 不断做减法
 * 注意: 全程应该使用long计算, 最后在转为int
 */
public class P29_DivideTwoIntegers {

    public long dfs(long a, long b) {
        if (a < b) {
            return 0;
        }

        long z = b;
        long result = 1;
        while ((z <<= 1) < a) {
            result <<= 1;
        }

        return result + dfs(a - (z >> 1), b);
    }

    public int divide(int dividend, int divisor) {
        if (divisor == 0) {
            return Integer.MAX_VALUE;
        }

        boolean positive = true;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
            positive = false;
        }

        long val = dfs(Math.abs(0L + dividend), Math.abs(0L + divisor));
        long result = positive ? val : 0 - val;

        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            result = Integer.MAX_VALUE;
        }

        return (int)result;
    }

    public static void main(String[] args) {
        System.out.println(3<<1);
        System.out.println(new P29_DivideTwoIntegers().divide(-2147483648, -1));
    }

}
