package com.leetcode;

/**
 * Created by xiaoyuan on 14/05/2017.
 */
public class P357_CountNumberswithUniqueDigits {

    public int countNumbersWithUniqueDigits(int n) {

        if (n == 0) {return 1;}
        if (n == 1) {return 10;}

        int total = 10;
        for (int i = 2; i <= n; i++) {
            if (n > 10) {break;}

            total += getVal(i);
        }

        return total;
    }

    private int getVal(int x) {
        int now = 9;
        int res = 9;
        for (int i = 2; i<= x; i++) {
            res *= (now--);
        }
        return res;
    }


}
