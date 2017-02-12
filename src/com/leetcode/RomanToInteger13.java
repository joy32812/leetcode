package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiaoyuan on 12/02/2017.
 */
public class RomanToInteger13 {

    public int romanToInt(String s) {
        Map<String, Integer> romanMap = new HashMap<String, Integer>();
        romanMap.put("M", 1000);
        romanMap.put("D", 500);
        romanMap.put("C", 100);
        romanMap.put("L", 50);
        romanMap.put("X", 10);
        romanMap.put("V", 5);
        romanMap.put("I", 1);
        romanMap.put("IV", 4);
        romanMap.put("IX", 9);
        romanMap.put("XL", 40);
        romanMap.put("XC", 90);
        romanMap.put("CD", 400);
        romanMap.put("CM", 900);

        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            if (i + 1 < s.length() && romanMap.get("" + s.charAt(i) + s.charAt(i + 1)) != null) {
                result += romanMap.get("" + s.charAt(i) + s.charAt(i + 1));
                i++;
            } else {
                result += romanMap.get("" + s.charAt(i));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new RomanToInteger13().romanToInt("MCMLIV"));
        System.out.println(new RomanToInteger13().romanToInt("MMXIV"));
        System.out.println(new RomanToInteger13().romanToInt("MCMXC"));
    }

}
