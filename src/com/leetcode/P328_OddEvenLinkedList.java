package com.leetcode;

/**
 * Created by xiaoyuan on 07/05/2017.
 */
public class P328_OddEvenLinkedList {

    public ListNode oddEvenList(ListNode head) {
        if (head == null) {return null;}

        int cnt = 0;
        ListNode odd = new ListNode(1);
        ListNode rOdd = odd;
        ListNode even = new ListNode(1);
        ListNode rEven = even;

        while (head != null) {

            ListNode nextNode = head.next;
            head.next = null;

            cnt++;
            if (cnt % 2 == 1) {
                odd.next = head;
                odd = odd.next;
            } else {
                even.next = head;
                even = even.next;
            }

            head = nextNode;
        }

        odd.next = rEven.next;
        return rOdd.next;
    }

}
