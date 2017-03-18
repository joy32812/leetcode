package com.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by xiaoyuan on 18/03/2017.
 */


class RandomListNode {
    int label;
    RandomListNode next, random;
    RandomListNode(int x) { this.label = x; }
};



public class P138_CopyListwithRandomPointer {

    private Map<Integer, RandomListNode> allNodes;


    public RandomListNode copyRandomList(RandomListNode head) {
        allNodes = new HashMap<Integer, RandomListNode>();
        return work(head);
    }
    public RandomListNode work(RandomListNode head) {
        if (head == null) {return null;}
        if (allNodes.containsKey(head.label)) {
            return allNodes.get(head.label);
        }


        RandomListNode newNode = new RandomListNode(head.label);
        allNodes.put(head.label, newNode);

        RandomListNode nextNode = work(head.next);
        RandomListNode radNode = work(head.random);

        newNode.next = nextNode;
        newNode.random = radNode;
        return newNode;
    }

}
