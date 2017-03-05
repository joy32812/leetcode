package com.leetcode;

/**
 * Created by xiaoyuan on 05/03/2017.
 */
public class P86_PartitionList {

    public ListNode partition(ListNode head, int x) {
        ListNode dummyNode1 = new ListNode(0);
        ListNode dummyNode2 = new ListNode(0);

        ListNode now1 = dummyNode1;
        ListNode now2 = dummyNode2;

        while (head != null) {
            if (head.val < x) {
                now1.next = head;
                now1 = now1.next;
            } else {
                now2.next = head;
                now2 = now2.next;
            }
            head = head.next;
        }

        now2.next = null;
        now1.next = dummyNode2.next;

        return dummyNode1.next;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(4);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(2);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(2);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;

        ListNode result = new P86_PartitionList().partition(n1, 3);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }

    }

}
