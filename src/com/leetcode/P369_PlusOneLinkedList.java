package com.leetcode;

/**
 * Created by xiaoyuan on 17/05/2017.
 */
public class P369_PlusOneLinkedList {

    public ListNode plusOne(ListNode head) {
        return addOne(head, true);
    }

    private ListNode addOne(ListNode head, boolean begin) {
        if (head.next == null) {
            head.val++;
        } else {
            addOne(head.next, false);
            head.val += (head.next.val / 10);
            head.next.val %= 10;
        }

        if (begin && head.val >= 10) {
            ListNode now = new ListNode(1);
            head.val %= 10;
            now.next = head;
            return now;
        }

        return head;
    }


}
