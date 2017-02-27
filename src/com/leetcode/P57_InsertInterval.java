package com.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by xiaoyuan on 27/02/2017.
 */
public class P57_InsertInterval {

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList<Interval>();

        boolean ifAdd = false;

        for (Interval now : intervals) {

            if ((now.start >= newInterval.start && now.start <= newInterval.end) || (newInterval.start >= now.start && newInterval.start <= now.end)) {
                newInterval.start = Math.min(newInterval.start, now.start);
                newInterval.end = Math.max(newInterval.end, now.end);
            } else {
                if (!ifAdd && newInterval.end < now.start) {
                    ifAdd = true;
                    result.add(newInterval);
                    result.add(now);
                } else {
                    result.add(now);
                }
            }
        }
        if (!ifAdd) {
            result.add(newInterval);
        }

        return result;
    }

    public static void main(String[] args) {
        List<Interval> list = new ArrayList<Interval>();
        list.add(new Interval(1, 3));
        list.add(new Interval(6, 9));

        System.out.println(new P57_InsertInterval().insert(list, new Interval(2, 15)));

    }

}
