package com.leetcode;

/**
 * Created by xiaoyuan on 29/05/2017.
 */
public class P405_ConvertaNumbertoHexadecimal {

    public String toHex(int num) {
        if (num == 0) {return "0";}

        StringBuilder sb = new StringBuilder();
        for (int i = 7; i >= 0; i--) {
            int a = ((num & (15 << (4 * i))) >>> (4 * i));
            sb.append(getChar(a));
        }
        int j = 0;
        while (j < sb.length()) {
            if (sb.charAt(j) != '0') {break;}
            j++;
        }

        return sb.toString().substring(j);
    }

    private char getChar(int a) {
        if (a <= 9) {return (char)('0' + a);}
        return (char)('a' + (a - 10));
    }

    public static void main(String[] args) {
        System.out.println(new P405_ConvertaNumbertoHexadecimal().toHex(-1));
    }

}
