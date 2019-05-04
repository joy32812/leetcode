package com.leetcode;

class MyLinkedList {

    class MyListNode {
        int val;
        MyListNode next;

        public MyListNode(int val) {
            this.val = val;
        }
    }

    MyListNode root;

    /** Initialize your data structure here. */
    public MyLinkedList() {
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        int ind = -1;
        MyListNode now = root;
        while (now != null) {
            ind ++;
            if (ind == index) return now.val;
            now = now.next;
        }

        return -1;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        MyListNode head = new MyListNode(val);
        head.next = root;

        root = head;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        MyListNode target = new MyListNode(val);
        if (root == null) {
            root = target;
            return;
        }


        MyListNode now = root;
        while (now.next != null) now = now.next;
        now.next = target;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index < 0) return;

        if (index == 0) {
            addAtHead(val);
            return;
        }

        MyListNode target = new MyListNode(val);

        int ind = -1;
        MyListNode now = root;
        MyListNode last = null;
        while (now != null) {
            ind ++;

            if (ind == index) break;
            last = now;
            now = now.next;
        }

        if (ind + 1 == index) {
            addAtTail(val);
            return;
        }

        if (ind + 1 < index) return;

        last.next = target;
        target.next = now;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        int ind = -1;
        MyListNode last = null;
        MyListNode now = root;

        while (now != null) {
            ind ++;
            if (ind == index) {

                if (last == null) {
                    root = now.next;
                    now.next = null;
                    return;
                }

                last.next = now.next;
                now.next = null;
                return;
            }
            last = now;
            now = now.next;
        }
    }
}
public class P707_DesignLinkedList {
}
