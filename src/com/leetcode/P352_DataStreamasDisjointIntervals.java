package com.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by xiaoyuan on 12/05/2017.
 */
public class P352_DataStreamasDisjointIntervals {



}

class SummaryRanges {

    private LinkedList<Interval> ans;

    public SummaryRanges() {
        ans = new LinkedList<>();
    }

    public void addNum(int val) {
        if (ans.isEmpty()) {
            ans.add(new Interval(val, val));
            return;
        }

        int l = 0, r = ans.size() - 1;
        while (l < r) {
            if (l + 1 == r) {break;}
            int m = (l + r) / 2;
            Interval now = ans.get(m);
            if (now.start <= val && val <= now.end) {return;}

            if (val < now.start) {
                r = m;
            } else if (val > now.end) {
                l = m;
            }
        }

        if (l == r) {
            Interval now = ans.get(l);
            if (now.start <= val && val <= now.end) {return;}

            if (val == now.start - 1) {
                now.start = val;
            } else if (val < now.start) {
                ans.add(l, new Interval(val, val));
            } else if (val == now.end + 1) {
                now.end = val;
            } else if (val > now.end) {
                ans.add(l + 1, new Interval(val, val));
            }
            return;
        }

        Interval left = ans.get(l);
        Interval right = ans.get(r);

        if (val == left.start - 1) {
            left.start = val;
        } else if (val < left.start) {
            ans.add(l, new Interval(val, val));
        } else if (val >= left.start && val <= left.end) {
        } else {
            if (val == left.end + 1) {
                left.end = val;
            } else if (val == right.start - 1) {
                right.start = val;
            } else if (val > left.end && val < right.start) {
                ans.add(l + 1, new Interval(val, val));
            } else if (val >= right.start && val <= right.end) {
            } else if(val == right.end + 1) {
                right.end = val;
            } else {
                ans.add(r + 1, new Interval(val, val));
            }

            if (left.end + 1 == right.start) {
                right.start = left.start;
                ans.remove(l);
            }
        }

    }

    public List<Interval> getIntervals() {
        return ans;
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(1, 10);

        System.out.println(list);
    }
}