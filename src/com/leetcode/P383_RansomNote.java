package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiaoyuan on 22/05/2017.
 */
public class P383_RansomNote {

    public boolean canConstruct(String ransomNote, String magazine) {

        Map<Character, Integer> randMap = new HashMap<>();
        Map<Character, Integer> magMap = new HashMap<>();

        for (Character ch : ransomNote.toCharArray()) {
            if (randMap.containsKey(ch)) {
                randMap.put(ch, randMap.get(ch) + 1);
            } else {
                randMap.put(ch, 1);
            }
        }

        for (Character ch : magazine.toCharArray()) {
            if (magMap.containsKey(ch)) {
                magMap.put(ch, magMap.get(ch) + 1);
            } else {
                magMap.put(ch, 1);
            }
        }

        for (Character ch : randMap.keySet()) {
            if (randMap.get(ch) > magMap.computeIfAbsent(ch, k -> 0)) {
                return false;
            }
        }

        return true;
    }

}
