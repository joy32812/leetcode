package com.leetcode;

/**
 * Created by xiaoyuan on 30/03/2017.
 */
public class P206_ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        if (head == null) {return null;}
        if (head.next == null) {return head;}

        ListNode realNext = head.next;
        ListNode nextNode = reverseList(head.next);

        head.next = null;
        realNext.next = head;

        return nextNode;
    }


}
