package com.leetcode;

/**
 * Created by xiaoyuan on 01/03/2017.
 */
public class P70_ClimbingStairs {

    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }

        int lastTwo = 1;
        int lastOne = 1;
        for (int i = 2;i <= n;i++) {
            int tmp = lastOne + lastTwo;
            lastTwo = lastOne;
            lastOne = tmp;
        }

        return lastOne;
    }

    public static void main(String[] args) {
        System.out.println(new P70_ClimbingStairs().climbStairs(2));
    }

}
