package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiaoyuan on 20/03/2017.
 */
public class P146_LRUCache {

    private class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;

        public DLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Map<Integer, DLinkedNode> nodeMap;
    private DLinkedNode mockHead;
    private DLinkedNode mockTail;

    private int capacity;

    public P146_LRUCache(int capacity) {
        nodeMap = new HashMap<Integer, DLinkedNode>();
        mockHead = new DLinkedNode(0, 0);
        mockTail = new DLinkedNode(0, 0);

        mockHead.next = mockTail;
        mockTail.prev = mockHead;

        this.capacity = capacity;
    }

    public int get(int key) {
        DLinkedNode node = nodeMap.get(key);
        if (node == null) {return -1;}

        DLinkedNode prev = node.prev;
        DLinkedNode next = node.next;

        prev.next = next;
        next.prev = prev;

        // before tail
        DLinkedNode beforeTail = mockTail.prev;

        beforeTail.next = node;
        node.prev = beforeTail;
        node.next = mockTail;
        mockTail.prev = node;

        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = nodeMap.get(key);
        if (node == null) {
            if (nodeMap.size() == capacity) {
                DLinkedNode delNode = mockHead.next;
                DLinkedNode prev = delNode.prev;
                DLinkedNode next = delNode.next;

                prev.next = next;
                next.prev = prev;

                nodeMap.remove(delNode.key);
            }
            // add
            node = new DLinkedNode(key, value);
            nodeMap.put(key, node);

            // before tail
            DLinkedNode beforeTail = mockTail.prev;

            beforeTail.next = node;
            node.prev = beforeTail;
            node.next = mockTail;
            mockTail.prev = node;
        } else {
            // mod
            node.value = value;

            DLinkedNode prev = node.prev;
            DLinkedNode next = node.next;

            prev.next = next;
            next.prev = prev;

            // before tail
            DLinkedNode beforeTail = mockTail.prev;

            beforeTail.next = node;
            node.prev = beforeTail;
            node.next = mockTail;
            mockTail.prev = node;
        }
    }

}
