package com.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class P853_CarFleet {

    public int carFleet(int target, int[] position, int[] speed) {

        // sort by position
        List<int[]> cars = new ArrayList<>();
        for (int i = 0; i < position.length; i++) {
            cars.add(new int[]{position[i], speed[i]});
        }
        cars.sort((Comparator.comparingInt(a -> a[0])));


        // get finish time
        List<Double> times = new ArrayList<>();
        for (int[] car : cars) {
            times.add((target - car[0] + 0.0) / car[1]);
        }



        int ans = 0;
        double last = -1.0;
        for (int i = times.size() - 1; i >= 0; i--) {
            if (last < times.get(i)) {
                if (last > 0) ans ++;
                last = times.get(i);
            }
        }

        if (last > 0) ans ++;
        return ans;
    }

}
