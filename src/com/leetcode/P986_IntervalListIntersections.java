package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class P986_IntervalListIntersections {

    public Interval[] intervalIntersection(Interval[] A, Interval[] B) {
        if (A == null || B == null || A.length == 0 || B.length == 0) return new Interval[0];

        int i = 0;
        int j = 0;

        List<Interval> ansList = new ArrayList<>();
        while (i < A.length && j < B.length) {
            Interval a = A[i];
            Interval b = B[j];

            if (a.end < b.start) {
                i ++;
            } else if (b.end < a.start) {
                j ++;
            } else {
                Interval now = new Interval();
                now.start = Math.max(a.start, b.start);
                now.end = Math.min(a.end, b.end);
                ansList.add(now);

                if (a.end < b.end) {
                    i ++;
                } else {
                    j ++;
                }
            }
        }

        return ansList.toArray(new Interval[0]);
    }

    public static void main(String[] args) {
        System.out.println(new P986_IntervalListIntersections().intervalIntersection(
                new Interval[]{
                        new Interval(0, 2),
                        new Interval(5, 10),
                        new Interval(13, 23),
                        new Interval(24, 25)
                },
                new Interval[]{
                        new Interval(1, 5),
                        new Interval(8, 12),
                        new Interval(15, 24),
                        new Interval(25, 26)
                }
        ));
    }

}
