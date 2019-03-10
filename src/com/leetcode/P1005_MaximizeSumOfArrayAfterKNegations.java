package com.leetcode;

import java.util.PriorityQueue;

public class P1005_MaximizeSumOfArrayAfterKNegations {


    /**
     * easy, flip the smallest one every time
     * @param A
     * @param K
     * @return
     */
    public int largestSumAfterKNegations(int[] A, int K) {


        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int d : A) {
            pq.add(d);
        }

        for (int i = 0; i < K; i++) {
            int top = pq.poll();
            pq.add(-1 * top);
        }

        int ans = 0;
        while (!pq.isEmpty()) {
            ans += pq.poll();
        }

        return ans;

    }



    public static void main(String[] args) {

        System.out.println(new P1005_MaximizeSumOfArrayAfterKNegations().largestSumAfterKNegations(new int[]{-4, 2, 3}, 2));

    }

}
