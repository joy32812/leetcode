package com.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by xiaoyuan on 23/05/2017.
 */
public class P387_FirstUniqueCharacterinaString {

    public int firstUniqChar(String s) {

        Map<Character, Integer> numMap = new HashMap<>();

        for (Character ch : s.toCharArray()) {
            if (numMap.containsKey(ch)) {
                numMap.put(ch, numMap.get(ch) + 1);
            } else {
                numMap.put(ch, 1);
            }
        }

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (numMap.get(ch) == 1) {return i;}
        }

        return -1;
    }

}
