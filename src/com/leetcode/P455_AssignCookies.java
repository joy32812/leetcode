package com.leetcode;

import java.util.Arrays;

/**
 * Created by xiaoyuan on 08/06/2017.
 */
public class P455_AssignCookies {

    public int findContentChildren(int[] g, int[] s) {

        Arrays.sort(g);
        Arrays.sort(s);

        int ans = 0;

        int a = 0;
        int b = 0;

        while (a < g.length && b < s.length) {
            if (s[b] >= g[a]) {
                ans++;
                a++;
                b++;
            } else {
                b++;
            }
        }

        return ans;
    }

}
