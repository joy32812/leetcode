package com.leetcode;

import java.util.*;

/**
 * Created by xiaoyuan on 20/06/2017.
 */
public class P500_KeyboardRow {

    public String[] findWords(String[] words) {

        char[] row1 = new char[]{'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'};
        char[] row2 = new char[]{'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l'};
        char[] row3 = new char[]{'z', 'x', 'c', 'v', 'b', 'n', 'm'};

        Map<Character, Integer> rowMap = new HashMap<>();
        for (char ch : row1) {rowMap.put(ch, 1);}
        for (char ch : row2) {rowMap.put(ch, 2);}
        for (char ch : row3) {rowMap.put(ch, 3);}

        List<String> stringList = new ArrayList<>();
        for (String w : words) {
            String oldW = w;
            if (w.length() == 0) {continue;}
            w = w.toLowerCase();

            boolean okay = true;
            int d = rowMap.get(w.charAt(0));
            for (char ch : w.toCharArray()) {
                if (rowMap.get(ch) != d) {
                    okay = false;
                    break;
                }
            }

            if (okay) {stringList.add(oldW);}
        }

        return stringList.toArray(new String[stringList.size()]);
    }

    public static void main(String[] args) {
        System.out.println(new P500_KeyboardRow().findWords(new String[]{"Hello", "Alaska", "Dad", "Peace"}));
    }

}
