package com.leetcode;

import java.util.Arrays;

public class P820_ShortEncodingofWords {

    /**
     * sort and find endswith
     * @param words
     * @return
     */
    public int minimumLengthEncoding(String[] words) {


        Arrays.sort(words, (a, b) -> (b.length() - a.length()));

        boolean[] visit = new boolean[words.length];
        int ans = 0;

        for (int i = 0; i < words.length; i++) {
            if (visit[i]) continue;

            ans += words[i].length() + 1;
            for (int j = i + 1; j < words.length; j++) {
                if (words[i].endsWith(words[j])) visit[j] = true;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new P820_ShortEncodingofWords().minimumLengthEncoding(new String[]{"time", "me", "bell"}));
    }

}
