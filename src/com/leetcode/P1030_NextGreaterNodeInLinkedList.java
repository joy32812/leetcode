package com.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class P1030_NextGreaterNodeInLinkedList {

    public int[] nextLargerNodes(ListNode head) {
        List<Integer> numList = new ArrayList<>();
        while (head != null) {
            numList.add(head.val);
            head = head.next;
        }

        int[] ans = new int[numList.size()];
        Stack<Integer> stack = new Stack<>();
        for (int i = numList.size() - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= numList.get(i)) stack.pop();
            if (!stack.isEmpty()) ans[i] = stack.peek();

            stack.push(numList.get(i));
        }

        return ans;
    }


    public static void main(String[] args) {

    }

}
