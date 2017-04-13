package com.leetcode;


import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created by xiaoyuan on 13/04/2017.
 */
public class P253_MeetingRoomsII {

    public int minMeetingRooms(Interval[] intervals) {
        Arrays.sort(intervals, (Interval a, Interval b) -> {
            if (a.start == b.start) {
                return a.end - b.end;
            }
            return a.start - b.start;
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>((Integer a, Integer b) -> (a - b));

        int ans = 0;
        for (int i = 0; i < intervals.length; i++) {
            Interval b = intervals[i];
            while (!pq.isEmpty() && pq.peek() <= b.start) {
                pq.poll();
            }
            pq.add(b.end);

            ans = Math.max(ans, pq.size());
        }

        return ans;
    }

    public static void main(String[] args) {

        PriorityQueue<Integer> pq = new PriorityQueue<>((Integer a, Integer b) -> (a - b));
        pq.add(1);
        pq.add(3);
        pq.add(9);
        pq.add(3);

        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }

    }

}
