package com.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class P855_ExamRoom {

    class ExamRoom {

        // start, end, len
        TreeSet<int[]> seatSet;
        Map<Integer, int[]> begMap;
        Map<Integer, int[]> endMap;
        int n;

        public ExamRoom(int N) {
            n = N;
            seatSet = new TreeSet<>((a, b) -> {
                if (a[2] == b[2]) return a[0] - b[0];
                return b[2] - a[2];
            });

            begMap = new HashMap<>();
            endMap = new HashMap<>();

            addSeg(-1, N);
        }

        public int seat() {
            int[] now = getNow();
            return doSeat(now[0], now[1]);
        }

        private int[] getNow() {
            int[] now = seatSet.pollFirst();
            begMap.remove(now[0]);
            endMap.remove(now[1]);
            return now;
        }

        public void leave(int p) {
            int[] beg = begMap.get(p);
            int[] end = endMap.get(p);
            begMap.remove(p);
            endMap.remove(p);
            seatSet.remove(beg);
            seatSet.remove(end);

            addSeg(end[0], beg[1]);
        }

        private int doSeat(int s, int t) {
            int ans = 0;
            if (s == -1) ans = 0;
            else if (t == n) ans = n - 1;
            else ans = (s + t) / 2;

            addSeg(s, ans);
            addSeg(ans, t);
            return ans;
        }

        private void addSeg(int s, int t) {
            int[] now = new int[]{s, t, (s + t) / 2  - s};
            if (s == -1) now[2] = t;
            else if (t == n) now[2] = n - 1 - s;

            seatSet.add(now);
            begMap.put(now[0], now);
            endMap.put(now[1], now);
        }
    }

    public static void main(String[] args) {

        new P855_ExamRoom().work();

    }
    private void work() {
        ExamRoom obj = new ExamRoom(10);
        System.out.println(obj.seat());
        System.out.println(obj.seat());
        System.out.println(obj.seat());
        obj.leave(0);
        obj.leave(4);
    }

}
