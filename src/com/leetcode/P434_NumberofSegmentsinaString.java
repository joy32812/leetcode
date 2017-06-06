package com.leetcode;

/**
 * Created by xiaoyuan on 06/06/2017.
 */
public class P434_NumberofSegmentsinaString {

    public int countSegments(String s) {

        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (!Character.isSpaceChar(ch)) {
                if (i == 0 || Character.isSpaceChar(s.charAt(i  -1))) {
                    ans++;
                }
            }
        }

        return ans;
    }

}
