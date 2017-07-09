package com.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by xiaoyuan on 09/07/2017.
 */
public class P432_AllOoneDataStructure {

    private class SetNode {
        int val;
        Set<String> keySet;

        SetNode prev;
        SetNode next;

        public SetNode(int val) {
            this.val = val;
            this.keySet = new HashSet<>();
        }
    }

    SetNode head;
    SetNode tail;


    Map<String, Integer> valMap;
    Map<Integer, SetNode> val2NodeMap;


    /** Initialize your data structure here. */
    public P432_AllOoneDataStructure() {

        head = new SetNode(0);
        tail = new SetNode(0);

        head.next = tail;
        tail.prev = head;

        valMap = new HashMap<>();
        val2NodeMap = new HashMap<>();
    }

    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        if (valMap.containsKey(key)) {
            int val = valMap.get(key);
            SetNode node = val2NodeMap.get(val);

            // set valMap
            valMap.put(key, val + 1);

            // set linkedList
            SetNode now = node;
            if (node.keySet.size() == 1) {
                now = node.prev;
                removeNode(node);

                val2NodeMap.remove(val);
            } else {
                node.keySet.remove(key);
            }

            val2NodeMap.put(val + 1, insertNode(now, key, val + 1));
        } else {
            valMap.put(key, 1);
            val2NodeMap.put(1, insertNode(head, key, 1));
        }
    }

    private SetNode insertNode(SetNode now, String key, int val) {
        if (now != head && now.val == val) {
            now.keySet.add(key);
            return now;
        }
        if (now.next != tail && now.next.val == val) {
            now.next.keySet.add(key);
            return now.next;
        }

        SetNode next = now.next;

        SetNode curNode = new SetNode(val);
        curNode.keySet.add(key);

        now.next = curNode;

        curNode.prev = now;
        curNode.next = next;

        next.prev = curNode;

        return curNode;
    }

    private void removeNode(SetNode node) {
        SetNode prev = node.prev;
        SetNode next = node.next;

        prev.next = next;
        next.prev = prev;
    }

    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        if (!valMap.containsKey(key)) {
            return;
        }

        int val = valMap.get(key);
        SetNode node = val2NodeMap.get(val);

        if (val == 1) {valMap.remove(key);}
        else {
            valMap.put(key, val - 1);
        }

        SetNode now = node.prev;
        if (node.keySet.size() == 1) {
            removeNode(node);
            val2NodeMap.remove(val);
        } else {
            node.keySet.remove(key);
        }

        if (val - 1 > 0) {
            val2NodeMap.put(val -1, insertNode(now, key, val - 1));
        }
    }

    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        if (valMap.size() == 0) {return "";}
        return tail.prev.keySet.iterator().next();
    }

    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        if (valMap.size() == 0) {return "";}
        return head.next.keySet.iterator().next();
    }


    public static void main(String[] args) {

        P432_AllOoneDataStructure obj = new P432_AllOoneDataStructure();


        obj.inc("AAA");
        System.out.println(obj.getMaxKey());
        System.out.println(obj.getMinKey());


        obj.inc("AAA");
        System.out.println(obj.getMaxKey());
        System.out.println(obj.getMinKey());

        obj.inc("BBB");
        System.out.println(obj.getMaxKey());
        System.out.println(obj.getMinKey());

        obj.dec("BBB");
        System.out.println(obj.getMaxKey());
        System.out.println(obj.getMinKey());

        obj.dec("BBB");
        System.out.println(obj.getMaxKey());
        System.out.println(obj.getMinKey());

        obj.dec("AAA");
        System.out.println(obj.getMaxKey());
        System.out.println(obj.getMinKey());

        System.out.println("--");
        obj.dec("AAA");
        System.out.println(obj.getMaxKey());
        System.out.println(obj.getMinKey());
    }

}
