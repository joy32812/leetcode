package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class P1094_CarPooling {

    /**
     * medium
     * sort and compute the people for every point in the trip
     * @param trips
     * @param capacity
     * @return
     */
    public boolean carPooling(int[][] trips, int capacity) {

        List<int[]> list = new ArrayList<>();
        for (int[] t : trips) {
            list.add(new int[]{t[1], t[0]});
            list.add(new int[]{t[2], -t[0]});
        }

        list.sort((a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });

        int now = 0;
        for (int[] z : list) {
            now += z[1];
            if (now > capacity) return false;
        }
        return true;
    }

}
