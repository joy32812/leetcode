package com.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by xiaoyuan on 31/05/2017.
 */
public class P403_FrogJump {

    public boolean canCross(int[] stones) {

        int n = stones.length;

        Set<Integer> stoneSet = new HashSet<>();
        for (int d : stones) {stoneSet.add(d);}

        Queue<String> Q = new LinkedList<>();
        Set<String> inQ = new HashSet<>();

        Q.add("0_0");
        inQ.add("0_0");

        while (!Q.isEmpty()) {
            String tp = Q.poll();
            int now = Integer.parseInt(tp.split("_")[0]);
            int step = Integer.parseInt(tp.split("_")[1]);

            for (int i = -1; i <= 1; i++) {
                int newStep = step + i;
                if (newStep <= 0) {continue;}

                int to = now + newStep;
                if (!stoneSet.contains(to)) {continue;}

                if (to == stones[stones.length - 1]) {return true;}

                String key = to + "_" + newStep;
                if (!inQ.contains(key)) {
                    Q.add(key);
                    inQ.add(key);
                }
            }
        }

        return false;
    }

}
