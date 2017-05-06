package com.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by xiaoyuan on 06/05/2017.
 */
public class P346_MovingAveragefromDataStream {

    private Queue<Integer> Q;
    private int SIZE;
    private double total;
    /** Initialize your data structure here. */
    public P346_MovingAveragefromDataStream(int size) {
        total = 0;
        SIZE = size;
        Q = new LinkedList<>();
    }

    public double next(int val) {
        total += val;
        Q.add(val);
        if (Q.size() > SIZE) {
            total -= Q.peek();
            Q.poll();
        }

        return total / Q.size();

    }

}
