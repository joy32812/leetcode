package com.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by xiaoyuan on 12/05/2017.
 */
public class P340_LongestSubstringwithAtMostKDistinctCharacters {

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || k == 0) {return 0;}
        if (s.length() <= k) {return s.length();}


        int ans = 0;
        Set<Character> winSet = new HashSet<>();
        Map<Character, Integer> posMap = new HashMap<>();
        int l = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!winSet.contains(s.charAt(i)) && winSet.size() >= k) {
                for (int j = l; ; j++) {
                    if (posMap.get(s.charAt(j)) == j) {
                        winSet.remove(s.charAt(j));
                        l = j + 1;
                        break;
                    }
                }
            }
            winSet.add(s.charAt(i));

            ans = Math.max(ans, i - l + 1);
            posMap.put(s.charAt(i), i);
        }


        return ans;
    }

}
