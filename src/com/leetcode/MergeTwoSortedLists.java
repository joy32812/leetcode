package com.leetcode;

/**
 * Created by xiaoyuan on 16/02/2017.
 */
public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode head = null;
        ListNode now = null;

        while (true) {
            if (l1 == null) {
                if (head == null) {
                    head = l2;
                } else {
                    now.next = l2;
                }
                return head;
            }

            if (l2 == null) {
                if (head == null) {
                    head = l1;
                } else {
                    now.next = l1;
                }
                return head;
            }

            if (l1.val < l2.val) {
                if (head == null) {
                    head = l1;
                    now = l1;
                } else {
                    now.next = l1;
                    now = now.next;
                }
                l1 = l1.next;
            } else {
                if (head == null) {
                    head = l2;
                    now = l2;
                } else {
                    now.next = l2;
                    now = now.next;
                }
                l2 = l2.next;
            }
        }
    }

    public static void main(String[] args) {

        ListNode aa1 = new ListNode(1);
        ListNode aa2 = new ListNode(3);
        ListNode aa3 = new ListNode(7);
        ListNode aa4 = new ListNode(9);
        aa1.next = aa2;
        aa2.next = aa3;
        aa3.next = aa4;

        ListNode bb1 = new ListNode(2);
        ListNode bb2 = new ListNode(4);
        ListNode bb3 = new ListNode(6);
        ListNode bb4 = new ListNode(8);
        bb1.next = bb2;
        bb2.next = bb3;
        bb3.next = bb4;


        ListNode result = new MergeTwoSortedLists().mergeTwoLists(aa1, null);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

}
