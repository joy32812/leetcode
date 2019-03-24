package com.leetcode;

import java.util.PriorityQueue;

public class P1021_BestSightseeingPair {


    /**
     * find the max(A[j] - j)
     *
     * @param A
     * @return
     */
    public int maxScoreSightseeingPair(int[] A) {

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        for (int i = 0; i < A.length; i++) {
            pq.add(A[i] - i);
        }

        int ans = 0;

        for (int i = 0; i < A.length; i++) {
            pq.remove(A[i] - i);
            if (!pq.isEmpty()) {
                ans = Math.max(ans, A[i] +i + pq.peek());
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        
    }

}
