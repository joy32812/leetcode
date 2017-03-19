package com.leetcode;

/**
 * Created by xiaoyuan on 19/03/2017.
 */
public class P141_LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        if (head == null) {return false;}

        ListNode oneStep = head, twoStep = head;
        while (true) {
            if (oneStep == null && twoStep == null) {
                return false;
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
                return true;
            }
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = l1;

        System.out.println(new P141_LinkedListCycle().hasCycle(l1));
    }
}
