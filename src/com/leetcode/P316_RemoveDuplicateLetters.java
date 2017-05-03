package com.leetcode;

import java.util.*;

/**
 * Created by xiaoyuan on 03/05/2017.
 */
public class P316_RemoveDuplicateLetters {

    private int n;
    private StringBuilder sb;
    private Set<Character> addSet;
    public String removeDuplicateLetters(String s) {
        if (s == null || s.length() <= 1) {return s;}

        Set<Character> set = new HashSet<>();
        for (char ch : s.toCharArray()) {
            set.add(ch);
        }
        n = set.size();

        addSet = new HashSet<>();
        sb = new StringBuilder();
        int l = 0, r = s.length() - 1;
        while (n > 0) {
            l = getTheChar(s, l , r, n);
            n--;
            addSet.add(s.charAt(l));
            sb.append(s.charAt(l));
        }

        return sb.toString();
    }

    private int getTheChar(String s, int l, int r, int n) {
        Set<Character> set = new HashSet<>();

        int pos = r;
        for (int i = r; i >= l; i--) {
            if (addSet.contains(s.charAt(i))) {continue;}
            set.add(s.charAt(i));

            if (set.size() == n) {
                pos = i;
                break;
            }
        }

        char ch = s.charAt(pos);
        int res = pos;
        for (int i = pos; i >= l; i--) {
            if (addSet.contains(s.charAt(i))) {continue;}
            if (ch >= s.charAt(i)) {
                ch = s.charAt(i);
                res = i;
            }
        }

        return res;
    }


    public static void main(String[] args) {
        System.out.println(new P316_RemoveDuplicateLetters().removeDuplicateLetters("bczabc"));

        System.out.println(new P316_RemoveDuplicateLetters().removeDuplicateLetters("cbacdcbc"));

    }
}
