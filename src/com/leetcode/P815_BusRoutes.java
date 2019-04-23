package com.leetcode;

import java.util.*;

public class P815_BusRoutes {

    /**
     * BFS
     * check route instead of stop
     * @param routes
     * @param S
     * @param T
     * @return
     */
    public int numBusesToDestination(int[][] routes, int S, int T) {
        if (routes == null || routes.length == 0) return -1;
        if (S == T) return 0;

        Map<Integer, List<Integer>> stop2RouteMap = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            for (int stop : routes[i]) {
                stop2RouteMap.computeIfAbsent(stop, k -> new ArrayList<>()).add(i);
            }
        }


        Queue<Integer> Q = new LinkedList<>();
        Set<Integer> visit = new HashSet<>();

        int ans = 0;
        Q.add(S);

        while (!Q.isEmpty()) {
            int len = Q.size();
            ans ++;

            for (int i = 0; i < len; i++) {
                int stop = Q.poll();

                for (int route : stop2RouteMap.getOrDefault(stop, new ArrayList<>())) {
                    if (visit.contains(route)) continue;

                    visit.add(route);

                    for (int next : routes[route]) {
                        if (next == T) return ans;
                        Q.add(next);
                    }
                }
            }
        }


        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new P815_BusRoutes().numBusesToDestination(new int[][]{
                {1, 2, 7},
                {3, 6, 7}
        }, 1, 6));
    }

}
