package com.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class P857_MinimumCosttoHireKWorkers {

    /**
     * sort by wage/quality
     * iterate the list, find the min (K - 1) quality, plus ith quality
     * @param quality
     * @param wage
     * @param K
     * @return
     */
    public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        if (quality == null || quality.length == 0) return 0.0;

        List<int[]> workers = new ArrayList<>();
        for (int i = 0; i < quality.length; i++) {
            workers.add(new int[]{quality[i], wage[i]});
        }

        workers.sort((a, b) -> (int) (1.0 * a[1] / a[0] - 1.0 * b[1] / b[0]));

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));

        double ans = Double.MAX_VALUE;
        int total = 0;
        for (int i = 0; i < workers.size(); i++) {
            int[] wk = workers.get(i);
            pq.add(wk[0]);
            total += wk[0];

            if (pq.size() > K) {
                total -= pq.poll();
            }

            if (pq.size() == K) {
                ans = Math.min(ans, 1.0 * total * wk[1] / wk[0]);
            }
        }

        return ans;
    }

}
