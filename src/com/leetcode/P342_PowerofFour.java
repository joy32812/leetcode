package com.leetcode;

/**
 * Created by xiaoyuan on 05/05/2017.
 */
public class P342_PowerofFour {

    public boolean isPowerOfFour(int num) {

        return num > 0 && (num & (num - 1)) == 0&& (0x55555555 & num) != 0;

    }

    public static void main(String[] args) {
        System.out.println(new P342_PowerofFour().isPowerOfFour(16));
    }

}
