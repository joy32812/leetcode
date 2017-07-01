package com.leetcode;

/**
 * Created by xiaoyuan on 01/07/2017.
 */
public class P573_SquirrelSimulation {

    public int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {

        int minDis = Integer.MAX_VALUE;
        int pos = -1;
        for (int i = 0; i < nuts.length; i++) {
            int[] p = nuts[i];

            int len = Math.abs(p[0] - squirrel[0]) + Math.abs(p[1] - squirrel[1]);
            len -= Math.abs(p[0] - tree[0]) + Math.abs(p[1] - tree[1]);
            if (minDis > len) {
                pos = i;
                minDis = len;
            }
        }

        int ans = minDis;

        for (int i = 0; i < nuts.length; i++) {
            int[] p = nuts[i];

            int len = Math.abs(p[0] - tree[0]) + Math.abs(p[1] - tree[1]);
            ans += 2 * len;
        }

        return ans;
    }

}
