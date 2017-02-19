package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoyuan on 19/02/2017.
 * 使用一个List暂时存储一下整个链表结构
 */
public class P25_ReverseNodesInKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }

        List<ListNode> copy = new ArrayList<ListNode>();
        while (head != null) {
            copy.add(head);
            head = head.next;
        }


        int length = copy.size();

        if (k > length) {
            return copy.get(0);
        }

        int pos = (length / k) * k - 1;

        for (int i = pos; i >= 0; i -= k) {
            if (i - k >= 0) {
                copy.get(i - k).next = copy.get(i);
            }
            ListNode nextGroupHead = copy.get(i).next;
            for (int j = i; j > i - k + 1; j--) {
                ListNode beforeNode = copy.get(j);
                ListNode afterNode = copy.get(j - 1);
                beforeNode.next = afterNode;
            }
            copy.get(i - k + 1).next = nextGroupHead;
        }

        return copy.get(k - 1);
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        ListNode result = new P25_ReverseNodesInKGroup().reverseKGroup(l1, 3);

        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
