package com.leetcode;

public class P708_InsertintoaCyclicSortedList {

    class Node {
        public int val;
        public Node next;

        public Node() {}

        public Node(int _val,Node _next) {
            val = _val;
            next = _next;
        }
    };

    /**
     * 1. find the last node
     * 2. first node
     * 3. compare value and insert
     * @param head
     * @param insertVal
     * @return
     */
    public Node insert(Node head, int insertVal) {

        Node now = new Node(insertVal, null);
        if (head == null) {
            now.next = now;
            return now;
        }


        Node last = findLast(head);
        Node first = last.next;

        if (insertVal <= first.val || insertVal >= last.val) {
            last.next = now;
            now.next = first;
            return head;
        }


        Node current = first;
        while (true) {
            if (current.next.val >= insertVal) {
                now.next = current.next;
                current.next = now;
                break;
            }

            current = current.next;
        }

        return head;
    }

    private Node findLast(Node head) {

        Node current = head;
        while (true) {
            if (current.next.val < current.val) {
                return current;
            }

            current = current.next;

            if (current == head) break;;
        }

        return head;
    }

}
