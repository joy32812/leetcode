package com.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created by xiaoyuan on 21/09/2017.
 */
public class P502_IPO {

    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        int n = Capital.length;
        int[][] data = new int[n][2];

        for (int i = 0; i < n; i++) {
            data[i][0] = Capital[i];
            data[i][1] = Profits[i];
        }

        Arrays.sort(data, (a, b) -> {
            if (a[0] > b[0]) return 1;
            if (a[0] < b[0]) return -1;
            return 0;
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            if (a > b) return -1;
            if (a < b) return 1;
            return 0;
        });


        int cnt = 0;
        int d = 0;

        while (cnt < k) {
            while (d < n) {
                if (data[d][0] > W) break;
                pq.add(data[d][1]);
                d++;
            }

            if (pq.isEmpty()) return W;
            cnt++;
            W += pq.poll();
        }

        return W;
    }

    public static void main(String[] args) {
        System.out.println(new P502_IPO().findMaximizedCapital(2, 0, new int[]{1, 2, 3}, new int[]{0, 1, 1}));
    }

}
