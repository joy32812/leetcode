package com.leetcode;

import java.util.Arrays;

/**
 * Created by xiaoyuan on 27/07/2017.
 */
public class P646_MaximumLengthofPairChain {

    public int findLongestChain(int[][] pairs) {

        Arrays.sort(pairs, (a, b) -> (a[1] - b[1]));

        int ans = 1;
        int[] last = pairs[0];

        for (int i = 1; i < pairs.length; i++) {
            if (pairs[i][0] > last[1]) {
                ans++;
                last = pairs[i];
            }
        }

        return ans;
    }

}
