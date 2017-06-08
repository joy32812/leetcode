package com.leetcode;

/**
 * Created by xiaoyuan on 08/06/2017.
 */
public class P453_MinimumMovestoEqualArrayElements {

    public int minMoves(int[] nums) {
        int ans = 0;
        int min = Integer.MAX_VALUE;
        for (int d : nums) {min = Math.min(min, d);}

        for (int d : nums) {ans += (d - min);}

        return ans;
    }

}
