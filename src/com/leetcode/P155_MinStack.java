package com.leetcode;

import java.util.Stack;

/**
 * Created by xiaoyuan on 22/03/2017.
 */
public class P155_MinStack {

    private Stack<Integer> valueStack;
    private Stack<Integer> minStack;
    public P155_MinStack() {
        valueStack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }

    public void push(int x) {
        if (valueStack.isEmpty()) {
            valueStack.push(x);
            minStack.push(x);
        } else {
            valueStack.push(x);
            minStack.push(Math.min(x, minStack.peek()));
        }
    }

    public void pop() {
        valueStack.pop();
        minStack.pop();
    }

    public int top() {
        return valueStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

}
