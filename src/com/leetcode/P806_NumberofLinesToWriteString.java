package com.leetcode;

public class P806_NumberofLinesToWriteString {

    public int[] numberOfLines(int[] widths, String S) {

        int line = 1;
        int now = 0;
        int i = 0;
        while (i < S.length()) {
            char ch = S.charAt(i);
            if (now + widths[ch - 'a'] > 100) {
                line ++;
                now = 0;
            } else {
                now += widths[ch - 'a'];
                i ++;
            }
        }

        return new int[]{line, now};
    }

}
