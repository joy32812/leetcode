package com.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class P933_RecentCounter {

    private Queue<Integer> Q;

    public P933_RecentCounter() {
        Q = new LinkedList<>();
    }

    public int ping(int t) {
        Q.add(t);
        while (Q.peek() + 3000 < t) {
            Q.poll();
        }

        return Q.size();
    }


    public static void main(String[] args) {

    }

}
