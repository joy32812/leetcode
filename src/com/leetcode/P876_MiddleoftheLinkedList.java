package com.leetcode;

import java.util.LinkedList;
import java.util.List;

public class P876_MiddleoftheLinkedList {

    public ListNode middleNode(ListNode head) {

        List<ListNode> data = new LinkedList<>();
        while (head != null) {
            data.add(head);
            head = head.next;
        }

        return data.get(data.size() / 2);
    }

}
