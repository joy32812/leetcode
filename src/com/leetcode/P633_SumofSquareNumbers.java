package com.leetcode;

/**
 * Created by xiaoyuan on 02/07/2017.
 */
public class P633_SumofSquareNumbers {

    public boolean judgeSquareSum(int c) {

        for (long i = 0; i * i <= c; i++) {
            if (isSq(c - i * i)) {return true;}
        }

        return false;
    }

    private boolean isSq(long x) {
        long a = (long)Math.sqrt(x);
        return a * a == x;
    }

}
