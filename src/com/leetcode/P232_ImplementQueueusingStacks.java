package com.leetcode;

import java.util.Stack;

/**
 * Created by xiaoyuan on 08/04/2017.
 */
public class P232_ImplementQueueusingStacks {

    private Stack<Integer> stack;

    /** Initialize your data structure here. */
    public P232_ImplementQueueusingStacks() {
        stack = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        int now = stack.pop();
        if (stack.isEmpty()) {
            return now;
        }

        int ans = pop();
        stack.push(now);
        return ans;
    }

    /** Get the front element. */
    public int peek() {
        int now = stack.pop();
        if (stack.isEmpty()) {
            stack.push(now);
            return now;
        }

        int ans = peek();
        stack.push(now);
        return ans;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.isEmpty();
    }


    public static void main(String[] args) {
        P232_ImplementQueueusingStacks obj = new P232_ImplementQueueusingStacks();

        obj.push(1);
        obj.push(2);
        obj.push(3);

        System.out.println(obj.empty());

        System.out.println(obj.peek());
        System.out.println(obj.peek());
        System.out.println(obj.peek());

        System.out.println(obj.pop());
        System.out.println(obj.pop());
        System.out.println(obj.pop());

        System.out.println(obj.empty());
    }

}
