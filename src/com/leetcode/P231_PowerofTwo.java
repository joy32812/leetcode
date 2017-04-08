package com.leetcode;

/**
 * Created by xiaoyuan on 08/04/2017.
 */
public class P231_PowerofTwo {

    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {return false;}

        if ((n & 1) > 0) {
            return (n >> 1) == 0;
        } else {
            return isPowerOfTwo(n >> 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new P231_PowerofTwo().isPowerOfTwo(7));
    }

}
