package com.leetcode;

import java.util.PriorityQueue;

/**
 * Created by xiaoyuan on 19/05/2017.
 */
public class P378_KthSmallestElementinaSortedMatrix {

    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[2] - b[2]));

        for (int j = 0; j < n; j++) {pq.add(new int[]{0, j, matrix[0][j]});}

        for (int i = 0; i < k - 1; i++) {
            int[] tp = pq.poll();

            if (tp[0] == m - 1) {continue;}

            pq.add(new int[]{tp[0] + 1, tp[1], matrix[tp[0] + 1][tp[1]]});
        }

        return pq.poll()[2];
    }

    public static void main(String[] args) {
        System.out.println(new P378_KthSmallestElementinaSortedMatrix().kthSmallest(new int[][]{
                {1, 5, 9},
                {10, 11, 13},
                {12, 13, 15}
        }, 3));
    }

}
