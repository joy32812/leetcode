package com.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class P817_LinkedListComponents {

    /**
     * should be easy
     * @param head
     * @param G
     * @return
     */
    public int numComponents(ListNode head, int[] G) {

        Set<Integer> gset = Arrays.stream(G).boxed().collect(Collectors.toSet());

        boolean last = false;
        int ans = 0;

        while (head != null) {
            int val = head.val;
            if (gset.contains(val)) {
                if (!last) {
                    last = true;
                    ans ++;
                }
            } else {
                last = false;
            }

            head = head.next;
        }

        return ans;
    }

}
