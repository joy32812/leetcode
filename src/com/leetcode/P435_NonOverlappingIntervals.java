package com.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by xiaoyuan on 06/06/2017.
 */
public class P435_NonOverlappingIntervals {

    public int eraseOverlapIntervals(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {return 0;}

        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.start == o2.start) {
                    return o1.end - o2.end;
                }
                return o1.start - o2.start;
            }
        });

        int ans = 0;
        Interval pre = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            Interval now = intervals[i];
            if (now.start < pre.end) {
                ans++;

                if (now.end < pre.end) {
                    pre = now;
                }
            } else {
                pre = now;
            }
        }


        return ans;
    }

}
