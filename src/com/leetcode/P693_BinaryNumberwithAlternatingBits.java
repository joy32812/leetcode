package com.leetcode;

/**
 * Created by xiaoyuan on 08/10/2017.
 */
public class P693_BinaryNumberwithAlternatingBits {

    public boolean hasAlternatingBits(int n) {
        String bitStr = Integer.toBinaryString(n);

        int now = 0;
        for (int i = 1; i < bitStr.length(); i++) {
            if (Integer.parseInt("" + bitStr.charAt(i)) != now) return false;
            now = 1 - now;
        }

        return true;
    }


    public static void main(String[] args) {
        System.out.println(new P693_BinaryNumberwithAlternatingBits().hasAlternatingBits(1));
        System.out.println(new P693_BinaryNumberwithAlternatingBits().hasAlternatingBits(2));
        System.out.println(new P693_BinaryNumberwithAlternatingBits().hasAlternatingBits(5));
        System.out.println(new P693_BinaryNumberwithAlternatingBits().hasAlternatingBits(7));
        System.out.println(new P693_BinaryNumberwithAlternatingBits().hasAlternatingBits(10));
    }
}
