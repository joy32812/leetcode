package com.leetcode;

import java.util.Arrays;

/**
 * Created by xiaoyuan on 05/03/2017.
 *
 * memo search
 */
public class P87_ScrambleString {

    private int[][][][] visit;

    public boolean isScramble(String s1, String s2) {
//        visit = new boolean[0][s1.length()[0][s2.length()];
        int m = s1.length();
        visit = new int[m][m][m][m];

        return dfs(s1, s2, 0, s1.length() - 1, 0, s2.length() - 1);
    }
    public boolean dfs(String s1, String s2, int l1, int r1, int l2, int r2) {

        // 0
        if (l1 > r1) {
            return true;
        }

        if (visit[l1][r1][l2][r2] > 0) {
            return visit[l1][r1][l2][r2] == 1;
        }

        // 1
        if (l1 == r1) {
            boolean ifEqual = s1.charAt(l1) == s2.charAt(l2);
            if (ifEqual) {
                visit[l1][r1][l2][r2] = 1;
            } else {
                visit[l1][r1][l2][r2] = 2;
            }
            return ifEqual;
        }

        // 2
        if(l1 + 1 == r1) {
            boolean ifEqual = (s1.charAt(l1) == s2.charAt(l2) && s1.charAt(l1 + 1) == s2.charAt(l2 + 1)) || (s1.charAt(l1) == s2.charAt(l2 + 1) && s1.charAt(l1 + 1) == s2.charAt(l2));
            if (ifEqual) {
                visit[l1][r1][l2][r2] = 1;
            } else {
                visit[l1][r1][l2][r2] = 2;
            }
            return ifEqual;
        }


        char[] chars1 = s1.toCharArray();
        Arrays.sort(chars1);
        String sort1 = new String(chars1);

        char[] chars2 = s2.toCharArray();
        Arrays.sort(chars2);
        String sort2 = new String(chars2);
        if (!sort1.equals(sort2)) {
            return false;
        }

        for (int i = 1; i < r1 - l1 + 1; i++) {
            if (dfs(s1, s2, l1, l1 + i - 1, l2, l2 + i - 1) && dfs(s1, s2, l1 + i, r1, l2 + i, r2)) {
                visit[l1][r1][l2][r2] = 1;
                return true;
            }

            if (dfs(s1, s2, l1, l1 + i - 1, r2 - i + 1, r2) && dfs(s1, s2, l1 + i, r1, l2, r2 - i)) {
                visit[l1][r1][l2][r2] = 1;
                return true;
            }
        }

        visit[l1][r1][l2][r2] = 2;
        return false;
    }

    public static void main(String[] args) {
//        System.out.println(new P87_ScrambleString().isScramble("great", "rgtae"));
        System.out.println(new P87_ScrambleString().isScramble("abc", "bca"));
        System.out.println(new P87_ScrambleString().isScramble("abcdefghijklmnopq", "efghijklmnopqcadb"));
    }
}
