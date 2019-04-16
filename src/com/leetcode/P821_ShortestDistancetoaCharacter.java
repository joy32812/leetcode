package com.leetcode;

import java.util.Arrays;

public class P821_ShortestDistancetoaCharacter {

    public int[] shortestToChar(String S, char C) {

        int n = S.length();

        int[] ans = new int[n];
        Arrays.fill(ans, Integer.MAX_VALUE);

        int pos = -1;
        for (int i = 0; i < n; i++) {
            char ch = S.charAt(i);
            if (C == ch) {
                pos = i;
                ans[i] = 0;
                continue;
            }
            if (pos == -1) continue;
            ans[i] = Math.min(ans[i], i - pos);
        }


        pos = -1;
        for (int i = n - 1; i >= 0; i--) {
            char ch = S.charAt(i);
            if (C == ch) {
                pos = i;
                ans[i] = 0;
                continue;
            }

            if (pos == -1) continue;
            ans[i] = Math.min(ans[i], pos - i);
        }

        return ans;
    }

}
