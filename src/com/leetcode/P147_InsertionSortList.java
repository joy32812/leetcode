package com.leetcode;

/**
 * Created by xiaoyuan on 20/03/2017.
 */
public class P147_InsertionSortList {

    public ListNode insertionSortList(ListNode head) {
        ListNode mockHead = new ListNode(0);

        ListNode now = head;
        while (now != null) {
            ListNode nowNext = now.next;

            ListNode last = mockHead;
            ListNode tp = mockHead.next;
            while (tp != null && tp.val < now.val) {
                last = tp;
                tp = tp.next;
            }

            ListNode lastNext = last.next;
            last.next = now;
            now.next = lastNext;

            now = nowNext;
        }

        return mockHead.next;
    }

}
