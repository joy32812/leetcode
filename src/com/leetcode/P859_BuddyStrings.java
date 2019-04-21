package com.leetcode;

import java.util.HashSet;
import java.util.Set;

public class P859_BuddyStrings {

    /**
     * careful when A == B
     * @param A
     * @param B
     * @return
     */
    public boolean buddyStrings(String A, String B) {
        if (A.length() != B.length()) return false;
        if (A.length() < 2) return false;

        if (A.equals(B) && okay(A)) return true;

        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) != B.charAt(i)) {
                sb1.append(A.charAt(i));
                sb2.append(B.charAt(i));
            }
        }

        return sb1.length() == 2 && sb1.toString().equals(sb2.reverse().toString());
    }

    private boolean okay(String s) {
        Set<Character> set = new HashSet<>();
        for (char ch : s.toCharArray()) {
            if (set.contains(ch)) return true;
            set.add(ch);
        }

        return false;
    }


    public static void main(String[] args) {
        System.out.println(new P859_BuddyStrings().buddyStrings("ab", "ba"));
    }

}
