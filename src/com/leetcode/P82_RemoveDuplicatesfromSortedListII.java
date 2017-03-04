package com.leetcode;

/**
 * Created by xiaoyuan on 04/03/2017.
 */
public class P82_RemoveDuplicatesfromSortedListII {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode fakeHead = new ListNode(1);
        ListNode now = fakeHead;

        while (head != null) {
            int cnt = 0;
            while (head != null && head.next != null && head.val == head.next.val) {
                cnt++;
                head = head.next;
            }
            if (cnt == 0) {
                now.next = new ListNode(head.val);
                now = now.next;
            }
            head = head.next;
        }

        return fakeHead.next;
    }

    public static void main(String[] args) {

//        ListNode n1 = new ListNode(1);
//        ListNode n2 = new ListNode(2);
//        ListNode n3 = new ListNode(3);
//        ListNode n4 = new ListNode(3);
//        ListNode n5 = new ListNode(4);
//        ListNode n6 = new ListNode(4);
//        ListNode n7 = new ListNode(5);
//        n1.next = n2;
//        n2.next = n3;
//        n3.next = n4;
//        n4.next = n5;
//        n5.next = n6;
//        n6.next = n7;

        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(2);
        n1.next = n2;
        n2.next = n3;


        ListNode ans = new P82_RemoveDuplicatesfromSortedListII().deleteDuplicates(n1);
        while (ans != null) {
            System.out.println(ans.val);
            ans = ans.next;
        }

    }

}
