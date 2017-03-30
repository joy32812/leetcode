package com.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by xiaoyuan on 30/03/2017.
 */
public class P205_IsomorphicStrings {


    public boolean isIsomorphic(String s, String t) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        Set<Integer> usedSet = new HashSet<Integer>();

        for (int i = 0; i < s.length(); i++) {
            int keyS = (int)s.charAt(i);
            int keyT = (int)t.charAt(i);

            if (map.get(keyS) == null) {
                if (usedSet.contains(keyT)) {
                    return false;
                }
                map.put(keyS, keyT);
                usedSet.add(keyT);
            } else if (map.get(keyS) == keyT) {
                continue;
            } else {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new P205_IsomorphicStrings().isIsomorphic("egg", "add"));
        System.out.println(new P205_IsomorphicStrings().isIsomorphic("ab", "aa"));
        System.out.println(new P205_IsomorphicStrings().isIsomorphic("ab", "ca"));
    }

}
