package com.leetcode;

import java.util.*;

/**
 * Created by xiaoyuan on 09/04/2017.
 */
public class P239_SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) {
        // O(n)
        if (nums == null || k <= 0) {return new int[0];}

        List<Integer> ans = new ArrayList<>();

        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            while (!q.isEmpty() && q.peek() < i - k + 1) {
                q.pop();
            }

            while (!q.isEmpty() && nums[q.peekLast()] < nums[i]) {
                q.pollLast();
            }

            q.offer(i);
            if (i >= k - 1) {
                ans.add(nums[q.peek()]);
            }
        }

        int[] ansArr = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {ansArr[i] = ans.get(i);}

        return ansArr;
    }
    public int[] maxSlidingWindow2(int[] nums, int k) {
        // O(n*logn)

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));

        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            pq.add(nums[i]);
            if (i >= k) {
                pq.remove(nums[i - k]);
            }
            if (i >= k - 1) {
                ans.add(pq.peek());
            }
        }


        int[] ansArr = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {ansArr[i] = ans.get(i);}

        return ansArr;
    }

    public static void main(String[] args) {
        System.out.println(new P239_SlidingWindowMaximum().maxSlidingWindow(new int[]{1}, 1));
    }

}
