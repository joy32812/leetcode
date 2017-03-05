package com.leetcode;

/**
 * Created by xiaoyuan on 05/03/2017.
 */
public class P83_RemoveDuplicatesfromSortedList {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode fakeHead = new ListNode(1);

        ListNode now = fakeHead;
        while (head != null) {
            while (head != null && head.next != null && head.val == head.next.val) {
                head = head.next;
            }
            now.next = new ListNode(head.val);
            now = now.next;
            head = head.next;
        }

        return fakeHead.next;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(2);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;


        ListNode ans = new P83_RemoveDuplicatesfromSortedList().deleteDuplicates(null);
        while (ans != null) {
            System.out.println(ans.val);
            ans = ans.next;
        }
    }

}
