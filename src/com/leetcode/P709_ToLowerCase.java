package com.leetcode;

public class P709_ToLowerCase {

    public String toLowerCase(String str) {
        if (str == null) return null;
        StringBuilder sb = new StringBuilder();

        for (char ch : str.toCharArray()) {
            sb.append(Character.toLowerCase(ch));
        }

        return sb.toString();
    }

}
