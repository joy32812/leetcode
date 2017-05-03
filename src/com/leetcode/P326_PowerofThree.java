package com.leetcode;

/**
 * Created by xiaoyuan on 03/05/2017.
 */
public class P326_PowerofThree {

    public boolean isPowerOfThree(int n) {
        return (n > 0 && 1162261467 % n == 0);
    }

}
