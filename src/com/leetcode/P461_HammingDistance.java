package com.leetcode;

/**
 * Created by xiaoyuan on 09/06/2017.
 */
public class P461_HammingDistance {

    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }

    public static void main(String[] args) {
        int a = 3;
        int b = 1;
        System.out.println(a ^ b);
    }

}
