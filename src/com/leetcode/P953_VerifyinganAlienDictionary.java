package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P953_VerifyinganAlienDictionary {


    /**
     * easy
     * mapping to normal words and check if sorted
     * @param words
     * @param order
     * @return
     */
    public boolean isAlienSorted(String[] words, String order) {

        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            char ch = order.charAt(i);
            map.put(ch, (char)('a' + i));
        }

        String[] ww = new String[words.length];
        String[] nn = new String[words.length];
        for (int i = 0; i < ww.length; i++) {
            ww[i] = convert(words[i], map);
            nn[i] = convert(words[i], map);
        }

        Arrays.sort(nn);

        for (int i = 0; i < ww.length; i++) {
            if (!ww[i].equals(nn[i])) return false;
        }

        return true;
    }

    private String convert(String word, Map<Character, Character> map) {

        StringBuilder sb = new StringBuilder();
        for (char ch : word.toCharArray()) {
            sb.append(map.get(ch));
        }
        return sb.toString();
    }


    public static void main(String[] args) {

    }


}
