package com.leetcode;

import java.util.TreeSet;

/**
 * Created by xiaoyuan on 26/11/2017.
 */
public class P729_MyCalendarI {

    private class SEG implements Comparable<SEG> {
        int l;
        int r;

        public SEG(int l, int r) {
            this.l = l;
            this.r = r;
        }

        @Override
        public int compareTo(SEG o) {
            return this.r - o.r;
        }
    }
    TreeSet<SEG> treeSet;

    public P729_MyCalendarI() {
        treeSet = new TreeSet<>();
    }

    public boolean book(int start, int end) {
        SEG s = treeSet.higher(new SEG(0, start));
        if (s == null || s.l >= end) {
            treeSet.add(new SEG(start, end));
            return true;
        }
        return false;
    }

}
