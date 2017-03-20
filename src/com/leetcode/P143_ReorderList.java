package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoyuan on 19/03/2017.
 */
public class P143_ReorderList {


    public void reorderList(ListNode head) {
        if (head == null) {return;}

        List<ListNode> listNodeList = new ArrayList<ListNode>();
        while (head != null) {
            listNodeList.add(head);
            head = head.next;
        }

        int l = 0;
        int r = listNodeList.size() - 1;

        List<ListNode> orderList = new ArrayList<ListNode>();
        while (l <= r) {
            orderList.add(listNodeList.get(l));
            if (l != r) {
                orderList.add(listNodeList.get(r));
            }
            l ++;
            r --;
        }

        for (int i = 0; i < orderList.size(); i++) {
            orderList.get(i).next = (i + 1 == orderList.size()) ? null : orderList.get(i + 1);
        }
    }

    public static void main(String[] args) {

        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);

        l1.next = l2;
        l2.next = l3;


        new P143_ReorderList().reorderList(l1);
        System.out.println("aaaa");
    }

}
