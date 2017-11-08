package com.leetcode;

import java.util.*;

/**
 * Created by xiaoyuan on 08/11/2017.
 */
public class P716_MaxStack {

    private PriorityQueue<int[]> pq;
    private Stack<int[]> stack;
    private int cnt;
    private Set<Integer> rmSets;

    /** initialize your data structure here. */
    public P716_MaxStack() {
        rmSets = new HashSet<>();
        pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) return o2[1] - o1[1];
                return o2[0] - o1[0];
            }
        });
        stack = new Stack<>();

        cnt = 0;
    }

    public void push(int x) {
        ++cnt;
        pq.add(new int[]{x, cnt});
        stack.push(new int[]{x, cnt});
    }

    public int pop() {
        while (rmSets.contains(stack.peek()[1])) {
            stack.pop();
        }

        int[] top = stack.pop();
        rmSets.add(top[1]);

        return top[0];
    }

    public int top() {
        while (rmSets.contains(stack.peek()[1])) {
            stack.pop();
        }

        return stack.peek()[0];
    }

    public int peekMax() {
        while (rmSets.contains(pq.peek()[1])) {
            pq.poll();
        }

        return pq.peek()[0];
    }

    public int popMax() {
        while (rmSets.contains(pq.peek()[1])) {
            pq.poll();
        }

        int[] top = pq.poll();
        rmSets.add(top[1]);

        return top[0];
    }

    public static void main(String[] args) {
        P716_MaxStack obj = new P716_MaxStack();

        obj.push(5);
        obj.push(1);
        obj.push(5);

        System.out.println(obj.top());
        System.out.println(obj.popMax());
        System.out.println(obj.top());
        System.out.println(obj.peekMax());
        System.out.println(obj.pop());
        System.out.println(obj.top());
    }

}
