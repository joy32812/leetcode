package com.leetcode;

/**
 * Created by xiaoyuan on 08/04/2017.
 */
public class P234_PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {

        ListNode tp = head;
        int len = 0;
        while (tp != null) {
            len++;
            tp = tp.next;
        }

        int one = (len / 2) - 1;
        int two = (len + 1) / 2;

        ListNode nodeOne = null;
        ListNode nodeTwo = null;

        tp = head;
        int cnt = -1;
        ListNode last = null;
        while (tp != null) {
            cnt ++;
            if (cnt == one) {nodeOne = tp;}
            if (cnt == two) {nodeTwo = tp;break;}

            ListNode next = tp.next;
            tp.next = last;
            last = tp;
            tp = next;

        }

        while (nodeOne != null) {
            if (nodeOne.val != nodeTwo.val) {
                return false;
            }
            nodeOne = nodeOne.next;
            nodeTwo = nodeTwo.next;
        }

        return true;
    }

    public static void main(String[] args) {
        ListNode t1 = new ListNode(1);
        ListNode t2 = new ListNode(2);
        ListNode t3 = new ListNode(3);
        ListNode t4 = new ListNode(2);
        ListNode t5 = new ListNode(1);

        t1.next = t2;
        t2.next = t3;
        t3.next = t4;
        t4.next = t5;

        System.out.println(new P234_PalindromeLinkedList().isPalindrome(t1));
    }

}
