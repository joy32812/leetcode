package com.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class P893_GroupsofSpecialEquivalentStrings {

    public int numSpecialEquivGroups(String[] A) {

        Set<String> ansSet = new HashSet<>();

        for (String s : A) {
            ansSet.add(normalize(s));
        }

        return ansSet.size();
    }

    private String normalize(String s) {

        StringBuilder sbOdd = new StringBuilder();
        StringBuilder sbEven = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (i % 2 == 0) sbEven.append(s.charAt(i));
            else sbOdd.append(s.charAt(i));
        }

        return sort(sbOdd.toString()) + "-" + sort(sbEven.toString());
    }

    private String sort(String s) {
        if (s.length() == 0) return "";
        char[] chars = s.toCharArray();
        Arrays.sort(chars);

        return new String(chars);
    }

}
