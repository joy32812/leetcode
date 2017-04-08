package com.leetcode;

/**
 * Created by xiaoyuan on 08/04/2017.
 */
public class P237_DeleteNodeinaLinkedList {

    public void deleteNode(ListNode node) {

        while (node != null && node.next != null) {
            node.val = node.next.val;

            if (node.next.next == null) {
                node.next = null;
            }
            node = node.next;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(1);
        l1.next = l2;

        new P237_DeleteNodeinaLinkedList().deleteNode(l1);
    }

}
