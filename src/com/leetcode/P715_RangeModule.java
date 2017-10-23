package com.leetcode;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by xiaoyuan on 22/10/2017.
 */
public class P715_RangeModule {

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


    public P715_RangeModule() {
        treeSet = new TreeSet<>();
    }

    public void addRange(int left, int right) {
        Iterator<SEG> it = treeSet.tailSet(new SEG(0, left)).iterator();
        while (it.hasNext()) {
            SEG now = it.next();
            if (now.l > right) break;
            left = Math.min(left, now.l);
            right = Math.max(right, now.r);
            it.remove();
        }

        treeSet.add(new SEG(left, right));
    }

    public boolean queryRange(int left, int right) {
        SEG s = treeSet.higher(new SEG(0, left));
        return s != null && s.l <= left && s.r >= right;
    }

    public void removeRange(int left, int right) {
        Iterator<SEG> it = treeSet.tailSet(new SEG(0, left)).iterator();

        ArrayList<SEG> todo = new ArrayList<>();
        while (it.hasNext()) {
            SEG now = it.next();
            if (now.l > right) break;
            if (now.l < left) todo.add(new SEG(now.l, left));
            if (now.r > right) todo.add(new SEG(right, now.r));
            it.remove();
        }
        for (SEG s : todo) treeSet.add(s);
    }

    public static void main(String[] args) {
        P715_RangeModule obj = new P715_RangeModule();
        obj.addRange(10, 20);
        obj.removeRange(14, 16);
        System.out.println(obj.queryRange(10, 14));
        System.out.println(obj.queryRange(13, 15));
        System.out.println(obj.queryRange(16, 17));
    }

}
