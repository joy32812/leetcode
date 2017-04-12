package com.leetcode;

/**
 * Created by xiaoyuan on 10/04/2017.
 */
public class P245_ShortestWordDistanceIII {

    public int shortestWordDistance(String[] words, String word1, String word2) {

        int ans = Integer.MAX_VALUE;

        String last = null;
        int pos = 0;
        for (int i = 0; i < words.length; i++) {
            String w = words[i];

            if (w.equals(word1) || w.equals(word2)) {
                if (last != null && (word1.equals(word2) || !last.equals(w))) {
                    ans = Math.min(ans, i - pos);
                }

                last = w;
                pos = i;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new P245_ShortestWordDistanceIII().shortestWordDistance(new String[]{"practice", "makes", "perfect", "coding", "makes"}, "makes", "coding"));
        System.out.println(new P245_ShortestWordDistanceIII().shortestWordDistance(new String[]{"practice", "makes", "perfect", "coding", "makes"}, "makes", "makes"));
    }

}
