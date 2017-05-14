package com.leetcode;

import java.util.*;

/**
 * Created by xiaoyuan on 14/05/2017.
 */
public class P354_RussianDollEnvelopes {

    public int maxEnvelopes(int[][] envelopes) {

        if (envelopes == null || envelopes.length == 0) {return 0;}

        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {return o2[1] - o1[1];}
                return o1[0] - o2[0];
            }
        });

        int dp[] = new int[envelopes.length];

        int len = 0;
        for (int[] en : envelopes) {
            int index = Arrays.binarySearch(dp, 0, len, en[1]);
            if (index < 0) {
                index = -(index + 1);
            }
            dp[index] = en[1];

            if (index == len) {len++;}
        }

        return len;
    }

}
