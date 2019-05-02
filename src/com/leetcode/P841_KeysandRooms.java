package com.leetcode;

import java.util.*;

public class P841_KeysandRooms {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {


        Queue<Integer> Q = new LinkedList<>();
        Set<Integer> seen = new HashSet<>();
        Q.add(0);
        seen.add(0);

        while (!Q.isEmpty()) {
            int room = Q.poll();
            for (int key : rooms.get(room)) {
                if (!seen.contains(key)) {
                    seen.add(key);
                    Q.add(key);
                }
            }
        }

        return seen.size() == rooms.size();
    }

}
