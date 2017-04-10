package com.leetcode;

/**
 * Created by xiaoyuan on 10/04/2017.
 */
public class P243_ShortestWordDistance {

    public int shortestDistance(String[] words, String word1, String word2) {

        int ans = Integer.MAX_VALUE;

        String last = null;
        int pos = 0;
        for (int i = 0; i < words.length; i++) {
            String w = words[i];

            if (w.equals(word1) || w.equals(word2)) {
                if (last != null && !last.equals(w)) {
                    ans = Math.min(ans, i - pos);
                }

                last = w;
                pos = i;
            }
        }

        return ans;
    }

    public static void main(String[] args) {

    }

}
