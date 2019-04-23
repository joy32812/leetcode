package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class P849_MaximizeDistancetoClosestPerson {

    public int maxDistToClosest(int[] seats) {

        // get people position
        List<Integer> people = new ArrayList<>();
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 1) people.add(i);
        }

        // iterate to find max
        int ans = Math.max(people.get(0), seats.length - 1 - people.get(people.size() - 1));
        for (int i = 1; i < people.size(); i++) {
            int s = people.get(i - 1);
            int t = people.get(i);
            ans = Math.max(ans, (t - s) / 2);
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new P849_MaximizeDistancetoClosestPerson().maxDistToClosest(new int[]{1, 0, 0, 0, 1, 0, 1}));
    }

}
