package com.leetcode;

/**
 * Created by xiaoyuan on 01/03/2017.
 */
public class P69_SqrtX {

    public int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }

        long l = 1;
        long r = x;
        while (l < r) {
            long mid = (l + r) /2;
            if (mid * mid > x) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return (int)(l - 1);
    }


    public static void main(String[] args) {
        for (int i = 1;i <= 50; i++) {
            System.out.println(i + ": "  + new P69_SqrtX().mySqrt(i));
        }
    }
}
