package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiaoyuan on 17/04/2017.
 */
public class P273_IntegertoEnglishWords {

    /*
    Billion
    Million
    Thousand
    Hundred
     */

    private Map<Integer, String> numMap;
    public String numberToWords(int num) {
        if (num == 0) {return "Zero";}

        initMap();
        if (numMap.get(num) != null && num != 100 && num != 1000 && num != 1000000 && num != 1000000000) {return numMap.get(num);}

        String ans = "";

        int base = 1;
        while (num > 0) {
            int lowNum = num % 1000;

            int a = lowNum / 100;
            int aLeft = num % 100;

            int b = (lowNum / 10) % 10;
            int c = lowNum % 10;

            String nowStr = "";
            if (a > 0) {
                nowStr += numMap.get(a) + " " + numMap.get(100) + " ";
            }

            if (numMap.get(aLeft) != null) {
                nowStr += numMap.get(aLeft) + " ";
            } else {
                if (b > 0) {
                    nowStr += numMap.get(b * 10) + " ";
                }
                if (c > 0) {
                    nowStr += numMap.get(c) + " ";
                }
            }

            if (base > 1 && nowStr.length() > 0) {
                nowStr += numMap.get(base) + " ";
            }

            ans = nowStr + ans;

            base *= 1000;
            num = num / 1000;
        }

        return ans.trim();
    }

    private void initMap() {
        numMap = new HashMap<>();

        numMap.put(1, "One");
        numMap.put(2, "Two");
        numMap.put(3, "Three");
        numMap.put(4, "Four");
        numMap.put(5, "Five");
        numMap.put(6, "Six");
        numMap.put(7, "Seven");
        numMap.put(8, "Eight");
        numMap.put(9, "Nine");
        numMap.put(10, "Ten");
        numMap.put(11, "Eleven");
        numMap.put(12, "Twelve");
        numMap.put(13, "Thirteen");
        numMap.put(14, "Fourteen");
        numMap.put(15, "Fifteen");
        numMap.put(16, "Sixteen");
        numMap.put(17, "Seventeen");
        numMap.put(18, "Eighteen");
        numMap.put(19, "Nineteen");
        numMap.put(20, "Twenty");
        numMap.put(30, "Thirty");
        numMap.put(40, "Forty");
        numMap.put(50, "Fifty");
        numMap.put(60, "Sixty");
        numMap.put(70, "Seventy");
        numMap.put(80, "Eighty");
        numMap.put(90, "Ninety");

        numMap.put(100, "Hundred");
        numMap.put(1000, "Thousand");
        numMap.put(1000000, "Million");
        numMap.put(1000000000, "Billion");
    }

    public static void main(String[] args) {
        System.out.println(new P273_IntegertoEnglishWords().numberToWords(1000000000));
    }

}
