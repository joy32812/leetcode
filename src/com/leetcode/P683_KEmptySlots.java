package com.leetcode;

import java.util.TreeSet;

/**
 * Created by xiaoyuan on 25/09/2017.
 */
public class P683_KEmptySlots {

    public int kEmptySlots(int[] flowers, int k) {

        TreeSet<Integer> treeSet = new TreeSet<>();

        for (int i = 0; i < flowers.length; i++) {
            int p = flowers[i];

            Integer next = treeSet.higher(p);
            if (next != null && next - p == k + 1) return i + 1;


            Integer before = treeSet.lower(p);
            if (before != null && p - before == k + 1) return i + 1;

            treeSet.add(p);
        }

        return -1;

    }

    public static void main(String[] args) {
        System.out.println(new P683_KEmptySlots().kEmptySlots(new int[]{1, 3, 2}, 1));
    }

}
