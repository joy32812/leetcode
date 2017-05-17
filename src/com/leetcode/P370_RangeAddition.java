package com.leetcode;

/**
 * Created by xiaoyuan on 17/05/2017.
 */
public class P370_RangeAddition {

    private int[] BIT;
    public int[] getModifiedArray(int length, int[][] updates) {
        BIT = new int[length + 1];
        for (int[] update : updates) {
            update(update[0], -update[2]);
            update(update[1] + 1, update[2]);
        }

        int[] ans = new int[length];
        for (int i = 0; i < length; i++) {
            ans[i] = getVal(i + 1);
        }

        return ans;
    }

    private int getVal(int x) {
        int result = 0;
        while (x < BIT.length) {
            result += BIT[x];
            x += x & (-x);
        }
        return result;
    }

    private void update(int x, int d) {
        while (x > 0) {
            BIT[x] += d;
            x -= x & (-x);
        }
    }


}
