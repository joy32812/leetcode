package com.leetcode;

import java.util.PriorityQueue;

public class P703_KthLargestElementinaStream {

    class KthLargest {

        int K;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        public KthLargest(int k, int[] nums) {
            K = k;
            for (int d : nums) {
                pq.add(d);
                if (pq.size() > k) pq.poll();
            }
        }

        public int add(int val) {
            pq.add(val);
            if (pq.size() > K) pq.poll();

            return pq.peek();
        }
    }

}
