package com.leetcode;

import java.util.*;

/**
 * Created by xiaoyuan on 16/04/2017.
 */
public class P269_AlienDictionary {


    public String alienOrder(String[] words) {

        Map<Character, Integer> inMap = new HashMap<>();

        Map<Character, List<Character>> toMap = new HashMap<>();

        for (int i = 0; i < words.length; i++){
            String w = words[i];
            for (Character ch : w.toCharArray()) {
                if (inMap.get(ch) == null) {
                    inMap.put(ch, 0);
                }
            }
            if (i == 0) {continue;}

            String b = words[i - 1];
            for (int j = 0; j < w.length() && j < b.length(); j++) {
                Character cb = b.charAt(j);
                Character cw = w.charAt(j);
                if (cb.equals(cw)) {continue;}

                if (inMap.get(cw) == null) {
                    inMap.put(cw, 1);
                } else {
                    inMap.put(cw, 1 + inMap.get(cw));
                }

                List<Character> list = toMap.get(cb);
                if (list == null) {list = new ArrayList<>();}
                list.add(cw);
                toMap.put(cb, list);

                break;
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!inMap.isEmpty()) {
            Character now = null;
            for (Character key : inMap.keySet()) {
                int num = inMap.get(key);
                if (num == 0) {
                    now = key;
                    break;
                }
            }
            if (now == null) {return "";}
            inMap.remove(now);
            sb.append(now);

            List<Character> list = toMap.get(now);
            if (list != null) {
                for (Character toChar : list) {
                    inMap.put(toChar, inMap.get(toChar) - 1);
                }
            }

        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new P269_AlienDictionary().alienOrder(new String[]{"a","b","ca","cc"}));
    }

}
