package com.leetcode;

/**
 * Created by xiaoyuan on 06/03/2017.
 */
public class P92_ReverseLinkedListII {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(1);
        dummy.next = head;

        ListNode last = dummy;
        ListNode before = dummy;
        ListNode current = dummy;

        ListNode mNode = null, nNode = null;
        ListNode end = null;

        int cnt = 0;
        while (current != null) {
            if (cnt == m - 1) {
                last = current;
            }
            if (cnt == m) {
                mNode = current;
            }
            if (cnt == n) {
                nNode = current;
                end = current.next;
            }
            ListNode nowNode = current;
            ListNode nextOne = current.next;
            if (cnt > m && cnt <= n) {
                nowNode.next = before;
            }

            before = current;
            current = nextOne;

            cnt++;
        }

        last.next = nNode;
        mNode.next = end;

        return dummy.next;
    }

    public static void main(String[] args) {

        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        ListNode ans = new P92_ReverseLinkedListII().reverseBetween(n1, 1, 1);
        while (ans != null) {
            System.out.println(ans.val);
            ans = ans.next;
        }

    }

}
