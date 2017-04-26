package com.leetcode;

import java.math.BigInteger;

/**
 * Created by xiaoyuan on 26/04/2017.
 */
public class P306_AdditiveNumber {

    public boolean isAdditiveNumber(String num) {

        for (int i = 0; i < num.length(); i++) {
            for (int j = i + 1; j < num.length(); j++) {
                if (okay(num, i, j)) {return true;}
            }
        }

        return false;
    }

    private boolean okay(String num, int i, int j) {
        if (num.charAt(0) == '0' && i != 0) {return false;}
        if (num.charAt(i + 1) == '0' && i + 1 != j) {return false;}

        BigInteger one = new BigInteger(num.substring(0, i + 1));
        BigInteger two = new BigInteger(num.substring(i + 1, j + 1));
        while (true) {
            BigInteger three = one.add(two);
            int length = three.toString().length();

            int k = j + length;
            if (k >= num.length()) {return false;}
            BigInteger real = new BigInteger(num.substring(j + 1, k + 1));
            if (!three.equals(real)) {return false;}

            one = two;
            two = three;

            j = k;

            if (j == num.length() - 1) {return true;}
        }
    }

    public static void main(String[] args) {
        System.out.println(new P306_AdditiveNumber().isAdditiveNumber("1023"));
//        System.out.println(new P306_AdditiveNumber().isAdditiveNumber("199100199"));
    }

}
