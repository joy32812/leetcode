package com.leetcode;

/**
 * Created by xiaoyuan on 29/03/2017.
 */
public class P191_Numberof1Bits {

    public int hammingWeight(int n) {
        int ones = 0;
        while(n!=0) {
            ones = ones + (n & 1);
            n = n>>>1;
        }
        return ones;
    }

    public static void main(String[] args) {
        System.out.println(new P191_Numberof1Bits().hammingWeight(11));
    }

}
