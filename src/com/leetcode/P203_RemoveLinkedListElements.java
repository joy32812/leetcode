package com.leetcode;

/**
 * Created by xiaoyuan on 30/03/2017.
 */
public class P203_RemoveLinkedListElements {

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {return null;}
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }
    public ListNode removeElements2(ListNode head, int val) {

        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;

        ListNode last = fakeHead;
        while (head != null) {
            if (head.val == val) {
                ListNode next = head.next;
                last.next = next;

                head = next;
            } else {
                last = head;
                head = head.next;
            }
        }

        return fakeHead.next;
    }


}
