package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class P1002_FindCommonCharacters {


    /**
     * easy count and find min
     * @param A
     * @return
     */
    public List<String> commonChars(String[] A) {

        List<String> ansList = new ArrayList<>();
        if (A == null || A.length == 0) return ansList;
        for (char ch = 'a'; ch <= 'z'; ch++) {
            int cnt = Integer.MAX_VALUE;
            for (String s : A) {
                int num = numberInS(ch, s);
                cnt = Math.min(cnt, num);
            }

            for (int i = 0; i < cnt; i++) ansList.add("" + ch);
        }

        return ansList;
    }

    private int numberInS(char ch, String s) {
        int cnt = 0;
        for (char c : s.toCharArray()) {
            if (c == ch) cnt++;
        }
        return cnt;
    }


    public static void main(String[] args) {

    }

}
