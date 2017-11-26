package com.leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by xiaoyuan on 26/11/2017.
 */
public class P731_MyCalendarII {

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
    List<SEG> treeSet;

    public P731_MyCalendarII() {
        treeSet = new ArrayList<>();
    }

    public boolean book(int start, int end) {
//        Iterator<SEG> it = treeSet.tailSet(new SEG(0, start)).iterator();
        Iterator<SEG> it = treeSet.iterator();

        List<SEG> res = new ArrayList<>();
        while (it.hasNext()) {
            SEG now = it.next();
            if (now.r <= start || now.l >= end) continue;
            res.add(new SEG(Math.max(start, now.l), Math.min(end, now.r)));
        }

        for (int i = 0; i < res.size(); i++) {
            for (int j = i + 1; j < res.size(); j++) {

                SEG x = res.get(i);
                SEG y = res.get(j);

                if (x.l >= y.r || x.r <= y.l) continue;
                return false;
            }
        }

        treeSet.add(new SEG(start, end));
        return true;
    }

}
