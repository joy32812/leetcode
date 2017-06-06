package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoyuan on 06/06/2017.
 */
public class P438_FindAllAnagramsinaString {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        if (s == null || s.length() == 0) {return ans;}
        if (s.length() < p.length()) {return ans;}

        int n = s.length();

        int[][] cntGrid = new int[26][n];
        int[] cntOne = new int[26];
        for (int i = 0; i < s.length(); i++) {
            cntOne[s.charAt(i) - 'a']++;

            for (int j = 0; j < 26; j++) {
                cntGrid[j][i] = cntOne[j];
            }
        }

        int[] pArray = new int[26];
        for (int i = 0; i < p.length(); i++) {
            pArray[p.charAt(i) - 'a']++;
        }

        for (int i = 0; i + p.length() - 1 < n; i++) {
            int from = i;
            int to = i + p.length() - 1;

            boolean okay = true;
            for (int j = 0; j < 26; j++) {
                int num = cntGrid[j][to] - (from -1 >= 0 ? cntGrid[j][from -1] : 0);
                if (num != pArray[j]) {
                    okay = false;
                    break;
                }
            }
            if (okay) {ans.add(i);}
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new P438_FindAllAnagramsinaString().findAnagrams("cbaebabacd", "abc"));
    }

}
