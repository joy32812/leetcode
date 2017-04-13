package com.leetcode;

import java.util.Arrays;

/**
 * Created by xiaoyuan on 13/04/2017.
 */
public class P252_MeetingRooms {

    public boolean canAttendMeetings(Interval[] intervals) {
        Arrays.sort(intervals, (Interval a, Interval b) -> {
            if (a.start == b.start) {
                return a.end - b.end;
            }
            return a.start - b.start;
        });

        for (int i = 1; i < intervals.length; i++) {
            Interval a = intervals[i - 1];
            Interval b = intervals[i];

            if (b.start < a.end) {
                return false;
            }
        }

        return true;
    }

}
