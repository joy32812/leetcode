package com.leetcode;

import java.util.*;

/**
 * Created by xiaoyuan on 02/08/2017.
 */
public class P433_MinimumGeneticMutation {

    public int minMutation(String start, String end, String[] bank) {
        if (start.equals(end)) {return 0;}

        Map<String, Integer> disMap = new HashMap<>();
        disMap.put(start, 0);

        int n = bank.length;

        Queue<String> Q = new LinkedList<>();
        Set<String> inQ = new HashSet<>();
        Q.add(start);
        inQ.add(start);


        while (!Q.isEmpty()) {
            String now = Q.poll();
            inQ.remove(now);

            int curr = disMap.get(now);
            for (int i = 0; i < n; i++) {
                if (!canMute(now, bank[i])) {continue;}

                if (!disMap.containsKey(bank[i]) || disMap.get(bank[i]) > curr + 1) {
                    disMap.put(bank[i], curr + 1);
                    if (!inQ.contains(bank[i])) {
                        Q.add(bank[i]);
                        inQ.add(bank[i]);
                    }
                }
            }
        }

        return disMap.containsKey(end) ? disMap.get(end) : -1;
    }

    private boolean canMute(String s, String t) {
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                num++;
            }
        }
        return num == 1;
    }

}
