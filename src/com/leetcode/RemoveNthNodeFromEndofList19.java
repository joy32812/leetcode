package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoyuan on 16/02/2017.
 */

public class RemoveNthNodeFromEndofList19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        List<ListNode> arrayList = new ArrayList<ListNode>();
        while (head != null) {
            arrayList.add(head);
            head = head.next;
        }

        int pos = arrayList.size() - n;

        if (pos == 0) {
            if (arrayList.size() == 1) {
                return null;
            }
            return arrayList.get(1);
        } else {
            ListNode before = arrayList.get(pos - 1);
            ListNode now = arrayList.get(pos);

            before.next = now.next;

            return arrayList.get(0);
        }
    }

    public static void main(String[] args) {

        ListNode l1 = new ListNode(1);
//        ListNode l2 = new ListNode(2);
//        ListNode l3 = new ListNode(3);
//        ListNode l4 = new ListNode(4);
//        ListNode l5 = new ListNode(5);

//        l1.next = l2;
//        l2.next = l3;
//        l3.next = l4;
//        l4.next = l5;

        ListNode result = new RemoveNthNodeFromEndofList19().removeNthFromEnd(l1, 1);

        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }

    }
}
