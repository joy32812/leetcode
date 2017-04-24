package com.leetcode;

import java.util.*;

/**
 * Created by xiaoyuan on 21/04/2017.
 */
public class P295_FindMedianfromDataStream {


    private PriorityQueue<Integer> large;
    private PriorityQueue<Integer> small;

    public P295_FindMedianfromDataStream() {
        large = new PriorityQueue<>((a, b) -> (b - a));
        small = new PriorityQueue<>((a, b) -> (a - b));
    }

    public void addNum(int num) {
        small.add(num);
        large.add(small.poll());

        if (small.size() < large.size()) {
            small.add(large.poll());
        }
    }

    public double findMedian() {
        if (small.size() > large.size()) {
            return small.peek();
        } else {
            return (small.peek() + large.peek()) / 2.0;
        }
    }

    public static void main(String[] args) {
        TreeMap<String, String> treeMap = new TreeMap<>();
        treeMap.put("11", "22");
        treeMap.put("11", "22");



        System.out.println(treeMap.size());
    }

}
