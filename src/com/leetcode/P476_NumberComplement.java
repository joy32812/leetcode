package com.leetcode;

/**
 * Created by xiaoyuan on 11/06/2017.
 */
public class P476_NumberComplement {

    public int findComplement(int num) {
        String numStr = Integer.toBinaryString(num);

        int res = 0;
        for (int i = 0; i < numStr.length(); i++) {
            res = res * 2 + (1 - Integer.parseInt("" + numStr.charAt(i)));
        }

        return res;

    }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(5));
    }

}
