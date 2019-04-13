package com.leetcode;

import java.util.Stack;

class StockSpanner {

    int index;
    Stack<int[]> stack;
    public StockSpanner() {
        index = 0;
        stack = new Stack<>();
    }

    public int next(int price) {
        int ans = 0;

        while (!stack.isEmpty() && stack.peek()[1] <= price) stack.pop();
        if (!stack.isEmpty()) ans += index - stack.peek()[0];
        else ans = index + 1;

        stack.add(new int[]{index, price});

        index ++;

        return ans;
    }
}

public class P901_OnlineStockSpan {


    public static void main(String[] args) {

        StockSpanner ss = new StockSpanner();

        System.out.println(ss.next(100));
        System.out.println(ss.next(80));
        System.out.println(ss.next(60));
        System.out.println(ss.next(70));
        System.out.println(ss.next(60));
        System.out.println(ss.next(75));
        System.out.println(ss.next(85));

    }

}
