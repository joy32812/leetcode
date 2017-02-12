package com.leetcode;

/**
 * Created by xiaoyuan on 12/02/2017.
 */
public class IntegerToRoman12 {

    public String intToRoman(int num) {
        String[] romanChar = {"I", "V", "X", "L", "C", "D", "M", "-"};
        String result = "";

        String intStr = "" + num;
        for (int i = 0; i < intStr.length(); i++) {
            int pos = (intStr.length() - i) * 2 - 1;
            int val = Integer.parseInt("" + intStr.charAt(i));
            if (val == 0) {
                continue;
            } else if (val >= 1 && val <= 3) {
                for (int j = 0; j < val; j++) {
                    result += romanChar[pos - 1];
                }
            } else if (val >= 4 && val <= 8) {
                for (int j = 0; j < 5 - val; j++) {
                    result += romanChar[pos - 1];
                }
                result += romanChar[pos];
                for (int j = 0; j < val - 5; j++) {
                    result += romanChar[pos - 1];
                }
            } else if (val == 9) {
                result += romanChar[pos - 1] + romanChar[pos + 1];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new IntegerToRoman12().intToRoman(6));
        System.out.println(new IntegerToRoman12().intToRoman(1954));
        System.out.println(new IntegerToRoman12().intToRoman(1990));
        System.out.println(new IntegerToRoman12().intToRoman(2014));
    }
}
