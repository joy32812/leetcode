package com.leetcode;

/**
 * Created by xiaoyuan on 28/02/2017.
 * /(ㄒoㄒ)/~~
 * 为啥数据都是有越界的呢, 不合法呢.
 */
public class P61_RotateList {

    public ListNode rotateRight(ListNode head, int k) {

        if (head == null) {
            return head;
        }


        int total = 0;
        ListNode tt = head;
        while (tt != null) {
            total++;
            tt = tt.next;
        }

        k = total - k % total - 1;



        ListNode now = head;

        ListNode tail = null;
        ListNode kNode = null;
        int cnt = 0;
        while (now != null && cnt != k) {
            tail = now;
            now = now.next;
            cnt ++;
        }

        if (now == null) {
            return head;
        }

        kNode = now;

        while (now != null) {
            tail = now;
            now = now.next;
        }

        if (kNode.next == null) {
            return head;
        }

        ListNode result = kNode.next;

        tail.next = head;
        kNode.next = null;


        return result;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);

        n1.next = n2;

        ListNode ans = new P61_RotateList().rotateRight(n1, 3);

        while (ans != null) {
            System.out.println(ans.val);
            ans = ans.next;
        }

    }

}
