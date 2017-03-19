package com.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by xiaoyuan on 19/03/2017.
 */
public class P142_LinkedListCycleII {

    public ListNode detectCycle(ListNode head) {
        if (head == null) {return null;}
        ListNode saveHead = head;

        ListNode oneStep = head, twoStep = head;
        while (true) {
            if (oneStep == null && twoStep == null) {
                return null;
            }

            if (oneStep != null) {
                oneStep = oneStep.next;
            }
            if (twoStep != null) {
                twoStep = twoStep.next;
                if (twoStep != null) {
                    twoStep = twoStep.next;
                }
            }

            if (oneStep != null && twoStep != null && oneStep == twoStep) {
                Set<ListNode> nodeSet = new HashSet<ListNode>();

                ListNode now = oneStep;
                nodeSet.add(now);
                while ((now = now.next) != oneStep) {
                    nodeSet.add(now);
                }

                while (!nodeSet.contains(saveHead)) {
                    saveHead = saveHead.next;
                }

                return saveHead;
            }
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = l1;

        System.out.println(new P142_LinkedListCycleII().detectCycle(l1));
    }
}
