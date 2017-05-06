package com.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by xiaoyuan on 06/05/2017.
 */
public class P345_ReverseVowelsofaString {

    public String reverseVowels(String s) {
        if (s == null || s.length() <= 1) {return s;}


        Set<Character> voewlSet = new HashSet<>();
        voewlSet.add('a');
        voewlSet.add('e');
        voewlSet.add('i');
        voewlSet.add('o');
        voewlSet.add('u');
        voewlSet.add('A');
        voewlSet.add('E');
        voewlSet.add('I');
        voewlSet.add('O');
        voewlSet.add('U');

        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (voewlSet.contains(ch)) {
                sb.append(ch);
            }
        }

        String vs = sb.reverse().toString();

        int cnt = 0;

        StringBuilder ans = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (voewlSet.contains(ch)) {
                ans.append(vs.charAt(cnt++));
            } else {
                ans.append(ch);
            }
        }

        return ans.toString();
    }

}
