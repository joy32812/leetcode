package com.leetcode;

/**
 * Created by xiaoyuan on 19/02/2017.
 * make a fake head first.
 */
public class P24_SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;

        ListNode last = fakeHead;
        while (head != null) {
            ListNode next = head.next;
            if (next == null) {
                break;
            }

            last.next = next;
            head.next = next.next;
            next.next = head;

            last = head;
            head = head.next;
        }


        return fakeHead.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;

        ListNode result = new P24_SwapNodesInPairs().swapPairs(l1);

        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }

    }
}
