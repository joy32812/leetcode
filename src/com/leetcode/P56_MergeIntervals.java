package com.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by xiaoyuan on 27/02/2017.
 */

class Interval {
     int start;
     int end;
     Interval() { start = 0; end = 0; }
     Interval(int s, int e) { start = s; end = e; }

    @Override
    public String toString() {
        return "(" + start + " -> " + end + ")";
    }
}

public class P56_MergeIntervals {

    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<Interval>();
        if (intervals.size() == 0) {
            return result;
        }

        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });

        Interval last = new Interval(intervals.get(0).start, intervals.get(0).end);


        for (Interval now : intervals) {
            if (now.start >= last.start && now.start <= last.end) {
                last.end = Math.max(last.end, now.end);
            } else {
                result.add(last);
                last = now;
            }
        }
        result.add(last);

        return result;
    }

    public static void main(String[] args) {
        List<Interval> list = new ArrayList<Interval>();
        list.add(new Interval(-1, 9));
        list.add(new Interval(-1, 10));
//        list.add(new Interval(1, 3));
//        list.add(new Interval(8, 10));

        System.out.println(new P56_MergeIntervals().merge(list));
    }

}
