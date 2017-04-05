package com.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by xiaoyuan on 05/04/2017.
 */
public class P225_ImplementStackusingQueues {

    private LinkedList<Integer> q;

    /** Initialize your data structure here. */
    public P225_ImplementStackusingQueues() {
        q = new LinkedList<Integer>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        q.add(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int val = q.getLast();
        q.removeLast();
        return val;
    }

    /** Get the top element. */
    public int top() {
        return q.getLast();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q.size() == 0;
    }

}
