package com.leetcode;

import java.util.SortedSet;
import java.util.Stack;
import java.util.TreeSet;

class StockSpanner {

    public StockSpanner() {
    }

    Stack<int[]> stack = new Stack<>();
    public int next(int price) {
        int res = 1;
        while (!stack.isEmpty() && stack.peek()[0] <= price)
            res += stack.pop()[1];
        stack.push(new int[]{price, res});
        return res;
    }
}

public class P901_OnlineStockSpan {


    public static void main(String[] args) {

        StockSpanner ss = new StockSpanner();


        int[] datas = new int[]{100, 80, 60, 70, 60, 75, 85};
        for (int d : datas) {
            System.out.println(ss.next(d));
        }

//        System.out.println(ss.next(1));
//        System.out.println(ss.next(2));
//        System.out.println(ss.next(1));

    }

}
