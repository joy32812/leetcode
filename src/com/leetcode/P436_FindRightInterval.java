package com.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by xiaoyuan on 06/06/2017.
 */
public class P436_FindRightInterval {

    private class Node {
        Interval interval;
        int index;
        int ans;

        public Node(Interval interval, int index, int ans) {
            this.interval = interval;
            this.index = index;
            this.ans = ans;
        }
    }

    public int[] findRightInterval(Interval[] intervals) {
        if (intervals == null | intervals.length == 0) {return new int[]{};}

        List<Node> nodes = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            nodes.add(new Node(intervals[i], i, -1));
        }

        nodes.sort(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.interval.start - o2.interval.start;
            }
        });

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> (a.interval.end - b.interval.end));

        for (int i = 0; i < nodes.size(); i++) {
            Node now = nodes.get(i);
            while (!pq.isEmpty()) {
                if (pq.peek().interval.end <= now.interval.start) {
                    pq.peek().ans = now.index;;
                    pq.poll();
                } else {
                    break;
                }
            }
            pq.add(now);
        }

        int[] ans = new int[intervals.length];
        for (int i = 0; i < nodes.size(); i++) {
            Node now = nodes.get(i);
            ans[now.index] = now.ans;
        }

        return ans;
    }

}
