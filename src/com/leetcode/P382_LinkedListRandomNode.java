package com.leetcode;

import java.util.Random;

/**
 * Created by xiaoyuan on 22/05/2017.
 */
public class P382_LinkedListRandomNode {

    private class Solution {

        private ListNode h;
        private Random random;
        /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
        public Solution(ListNode head) {
            h = head;
            random = new Random();
        }

        /** Returns a random node's value. */
        public int getRandom() {

            ListNode head = h;
            int result = head.val;
            for (int i = 1; head != null; i++) {
                if (random.nextInt(i) == 0) {
                    result = head.val;
                }

                head = head.next;
            }

            return result;
        }
    }

}

