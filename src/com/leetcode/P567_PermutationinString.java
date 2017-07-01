package com.leetcode;

/**
 * Created by xiaoyuan on 01/07/2017.
 */
public class P567_PermutationinString {

    public boolean checkInclusion(String s1, String s2) {

        int m = s1.length();
        int n = s2.length();
        if (m > n) {return false;}

        int[] cntArr = new int[26];
        for (char ch : s1.toCharArray()) {cntArr[ch - 'a']++;}


        int[][] gridArr = new int[n][26];
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < 26; j++) {
                gridArr[i][j] = i - 1 >= 0 ? gridArr[i -  1][j] : 0;
            }
            char ch = s2.charAt(i);
            gridArr[i][ch - 'a']++;
        }

        for (int i = 0; i + m <= n; i++) {
            if (okay(cntArr, gridArr, i, i + m - 1)) {
                return true;
            }
        }

        return false;
    }

    private boolean okay(int[] cntArr, int[][] gridArr, int l, int r) {

        for (int i = 0; i < 26; i++) {
            if (cntArr[i] != (gridArr[r][i] - (l - 1 >= 0 ? gridArr[l - 1][i] : 0))) {return false;}
        }

        return true;
    }

}
