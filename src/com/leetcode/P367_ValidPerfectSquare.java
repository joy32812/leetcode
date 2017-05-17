package com.leetcode;

/**
 * Created by xiaoyuan on 17/05/2017.
 */
public class P367_ValidPerfectSquare {

    public boolean isPerfectSquare(int num) {
        if (num == 1) {return true;}

        long l = 1, r = num;

        while (l < r) {
            long m = (l + r) / 2;
            if (m * m == num)  {
                return true;
            }
            if (m * m > num) {
                r = m;
            } else {
                l = m + 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(new P367_ValidPerfectSquare().isPerfectSquare(104976));
    }

}
