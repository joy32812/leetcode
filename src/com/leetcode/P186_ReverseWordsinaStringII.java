package com.leetcode;

/**
 * Created by xiaoyuan on 28/03/2017.
 */
public class P186_ReverseWordsinaStringII {

    public void reverseWords(char[] s) {
        if (s.length == 0) {return;}

        int begin = 0;
        for (int i = 1; i <= s.length; i++) {
            if (i == s.length || s[i] == ' ') {
                int l = begin, r = i - 1;
                while (l < r) {
                    char tmp = s[l];
                    s[l] = s[r];
                    s[r] = tmp;
                    l++;
                    r--;
                }
                begin = i + 1;
            }
        }

        int l = 0, r = s.length - 1;
        while (l < r) {
            char tmp = s[l];
            s[l] = s[r];
            s[r] = tmp;
            l++;
            r--;
        }
    }


    public static void main(String[] args) {
        new P186_ReverseWordsinaStringII().reverseWords("the sky is blue".toCharArray());
    }
}
