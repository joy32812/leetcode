package com.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created by xiaoyuan on 01/07/2017.
 */
public class P630_CourseScheduleIII {

    public int scheduleCourse(int[][] courses) {

        Arrays.sort(courses, (a, b) -> (a[1] - b[1]));

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));

        int time = 0;
        for (int[] course : courses) {
            time += course[0];
            pq.add(course[0]);

            if (time > course[1]) {
                time -= pq.poll();
            }
        }

        return pq.size();
    }

}
