package com.leetcode;

/**
 * Created by xiaoyuan on 16/02/2017.
 */
public class P23_MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {return null;}

        int step = 2;
        while (step / 2 <= lists.length) {
            for (int i = 0; i < lists.length; i += step) {
                if (i + step / 2 < lists.length) {
                    lists[i] = mergeTwo(lists[i], lists[i + step/2]);
                }
            }
            step <<= 1;
        }

        return lists[0];
    }

    private ListNode mergeTwo(ListNode one, ListNode two) {
        if (one == null) {
            return two;
        }

        if (two == null) {
            return one;
        }

        if (one.val <= two.val) {
            one.next = mergeTwo(one.next, two);
            return one;
        } else {
            two.next = mergeTwo(one, two.next);
            return two;
        }
    }

    public static void main(String[] args) {
        ListNode t1 = new ListNode(2);
        ListNode t2 = new ListNode(-1);

        new P23_MergeKSortedLists().mergeKLists(new ListNode[]{t1, null, t2});
    }

}
