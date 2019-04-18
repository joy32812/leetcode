package com.leetcode;

import java.util.*;

public class P787_CheapestFlightsWithinKStops {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        if (src == dst) return 0;

        K ++;
        if (K >= n) K = n - 1;


        // dis
        int[][] dis = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dis[i], Integer.MAX_VALUE);
        }
        dis[src][0] = 0;

        // adjMap

        int[][] price = new int[n][n];
        Map<Integer, Set<Integer>> adj = new HashMap<>();
        for (int[] flight : flights) {
            int from = flight[0];
            int to = flight[1];
            int p = flight[2];

            price[from][to] = p;
            adj.computeIfAbsent(from, k -> new HashSet<>()).add(to);
        }


        Queue<Integer> Q = new LinkedList<>();
        Q.add(src * n + 0);
        Set<Integer> inQ = new HashSet<>();
        inQ.add(src * n + 0);


        while (!Q.isEmpty()) {
            int now = Q.poll();
            inQ.remove(now);

            int from = now / n;
            int step = now % n;

            if (step >= K) continue;

            Set<Integer> adjSet = adj.computeIfAbsent(from, k -> new HashSet<>());
            for (int to : adjSet) {
                int p = price[from][to];

                if (dis[to][step + 1] > dis[from][step] + p) {
                    dis[to][step + 1] = dis[from][step] + p;

                    int val = to * n + (step + 1);
                    if (!inQ.contains(val)) {
                        inQ.add(val);
                        Q.add(val);
                    }
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i <= K; i++) {
            ans = Math.min(ans, dis[dst][i]);
        }


        return ans != Integer.MAX_VALUE ? ans : -1;
    }

}
