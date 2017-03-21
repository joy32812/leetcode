package com.leetcode;

import java.util.*;

/**
 * Created by xiaoyuan on 20/03/2017.
 */
public class P148_SortList {

    public ListNode sortList(ListNode head) {
        if (head == null) {return null;}

        List<ListNode> list = new ArrayList<ListNode>();

        while (head != null) {
            list.add(head);
            head = head.next;
        }

        Collections.sort(list, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        for(int i = 0; i < list.size();i++) {
            list.get(i).next = (i + 1 < list.size()) ? list.get(i + 1) : null;
        }

        return list.get(0);
    }

    public static void main(String[] args) {

    }
}
