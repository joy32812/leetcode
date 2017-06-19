package com.leetcode;

/**
 * Created by xiaoyuan on 19/06/2017.
 */
public class P495_TeemoAttacking {

    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (duration == 0) {return 0;}

        int ans = 0;
        int to = Integer.MIN_VALUE;
        for (int d : timeSeries) {
            if (to <= d) {
                ans += duration;
            } else {
                ans += duration - (to - d);
            }
            to = d + duration;
        }

        return ans;
    }


}
