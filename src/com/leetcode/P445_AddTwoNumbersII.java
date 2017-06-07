package com.leetcode;

import java.util.Stack;

/**
 * Created by xiaoyuan on 07/06/2017.
 */
public class P445_AddTwoNumbersII {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        Stack<Integer> stackOne = new Stack<>();
        Stack<Integer> stackTwo = new Stack<>();

        while (l1 != null) {
            stackOne.add(l1.val);
            l1 = l1.next;
        }

        while (l2 != null) {
            stackTwo.add(l2.val);
            l2 = l2.next;
        }

        ListNode ans = new ListNode(0);

        int adv = 0;
        while (true) {
            if (stackOne.isEmpty() && stackTwo.isEmpty() && adv == 0) {break;}

            int sum = adv + (stackOne.isEmpty() ? 0 : stackOne.pop()) + (stackTwo.isEmpty() ? 0 : stackTwo.pop());

            int val = sum % 10;
            adv = sum / 10;

            ListNode now = new ListNode(val);
            now.next = ans.next;
            ans.next = now;
        }

        return ans.next;

    }

}
