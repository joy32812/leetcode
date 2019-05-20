package com.leetcode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.TreeSet;

public class P1046_LastStoneWeight {


    /**
     * easy
     *
     * @param stones
     * @return
     */
    public int lastStoneWeight(int[] stones) {

        LinkedList<Integer> list = new LinkedList<>();
        for (int d : stones) list.add(d);

        while (list.size() >= 2) {
            Collections.sort(list);

            int first = list.removeLast();
            int last = list.removeLast();

            if (first != last) {
                list.add(Math.abs(first - last));
            }
        }

        if (list.size() == 1) return list.getFirst();
        return 0;
    }

    public static void main(String[] args) {

        System.out.println(new P1046_LastStoneWeight().lastStoneWeight(new int[]{2, 7, 4, 1, 8, 1}));
        System.out.println(new P1046_LastStoneWeight().lastStoneWeight(new int[]{2, 2}));

        System.out.println();

    }

}
