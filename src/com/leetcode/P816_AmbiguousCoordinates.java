package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class P816_AmbiguousCoordinates {

    /**
     * easy
     * @param S
     * @return
     */
    public List<String> ambiguousCoordinates(String S) {

        String ss = S.substring(1, S.length() - 1);

        List<String> ans = new ArrayList<>();
        for (int i = 0; i < ss.length(); i++) {
            List<String> left = getNumStr(ss.substring(0, i + 1));
            List<String> right = getNumStr(ss.substring(i + 1));

            for (String l : left) {
                for (String r : right) {
                    ans.add("(" + l + ", " + r + ")");
                }
            }
        }


        return ans;
    }

    private List<String> getNumStr(String s) {
        List<String> ans = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            String left = s.substring(0, i + 1);
            String right = s.substring(i + 1);
            if (okayLeft(left) && okayRight(right)) ans.add(left + (right.length() > 0 ? "." : "") + right);
        }

        return ans;
    }

    private boolean okayLeft(String left) {
        return left.length() == ("" + Integer.parseInt(left)).length();
    }

    private boolean okayRight(String right) {
        if (right.length() == 0) return true;
        return right.charAt(right.length() - 1) != '0';
    }

    public static void main(String[] args) {
        System.out.println(new P816_AmbiguousCoordinates().ambiguousCoordinates("(123)"));
    }

}
