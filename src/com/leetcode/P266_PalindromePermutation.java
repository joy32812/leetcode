package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiaoyuan on 16/04/2017.
 */
public class P266_PalindromePermutation {

    public boolean canPermutePalindrome(String s) {
        Map<Character, Integer> numMap = new HashMap<>();

        for (char ch : s.toCharArray()) {
            if (numMap.get(ch) == null) {
                numMap.put(ch, 1);
            } else {
                numMap.put(ch, numMap.get(ch) + 1);
            }
        }
        int oddsNum = s.length() % 2;
        for (Character key : numMap.keySet()) {
            int num = numMap.get(key);
            if (num % 2 == 1) {
                oddsNum--;
            }
            if (oddsNum < 0) {return false;}
        }

        return true;
    }

}
