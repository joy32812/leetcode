package com.leetcode;

import java.util.*;

/**
 * Created by xiaoyuan on 09/05/2017.
 */
public class P332_ReconstructItinerary {

    private Map<String, PriorityQueue<String>> tkMap;
    private List<String> route;

    public List<String> findItinerary(String[][] tickets) {

        tkMap = new HashMap<>();
        route = new LinkedList<>();

        for (String[] ticket : tickets) {
            tkMap.computeIfAbsent(ticket[0], k -> new PriorityQueue<String>()).add(ticket[1]);
        }

        visit("JFK");
        return route;
    }

    private void visit(String airport) {
        while (tkMap.containsKey(airport) && !tkMap.get(airport).isEmpty()) {
            visit(tkMap.get(airport).poll());
        }
        route.add(0, airport);
    }


}
