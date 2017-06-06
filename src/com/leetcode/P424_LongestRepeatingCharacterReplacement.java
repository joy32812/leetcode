package com.leetcode;

/**
 * Created by xiaoyuan on 06/06/2017.
 */
public class P424_LongestRepeatingCharacterReplacement {

    public int characterReplacement(String s, int k) {

        if (s == null || s.length() == 0) {return 0;}
        if (k >= s.length() - 1) {return s.length();}

        int n = s.length();
        int[][] cntGrid = new int[26][n];
        int[] nows = new int[26];
        for (int i = 0; i < n; i++) {
            nows[s.charAt(i) - 'A']++;
            for (int j = 0; j < 26; j++) {
                cntGrid[j][i] = nows[j];
            }
        }

        int l = 1;
        int r = s.length() + 1;
        while (l < r) {
            int m = (l + r) / 2;
            if (okay(m, k, s, cntGrid)) {
                l = m + 1;
            } else {
                r = m;
            }
        }


        return l - 1;
    }

    private boolean okay(int m, int k, String s, int[][] cntGrid) {

        for (int i = 0; i < s.length(); i++) {
            if (i > 0 && s.charAt(i) == s.charAt(i - 1)) {continue;}
            if (i + m - 1 >= s.length()) {break;}

            int begin = i, end = i + m - 1;
            for (int j = 0; j < 26; j++) {
                int cnt = cntGrid[j][end] - (begin - 1 >= 0 ? cntGrid[j][begin - 1] : 0);
                if (k >= m - cnt) {return true;}
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(new P424_LongestRepeatingCharacterReplacement().characterReplacement("ABBB", 2));
//        System.out.println(new P424_LongestRepeatingCharacterReplacement().characterReplacement("ABAB", 2));
//        System.out.println(new P424_LongestRepeatingCharacterReplacement().characterReplacement("AABABBA", 1));
    }

}
