package com.leetcode;


import java.util.Map;
import java.util.TreeMap;

class TopVotedCandidate {

    TreeMap<Integer, Integer> voteMap;

    /**
     * binary search
     * or
     * using TreeMap
     * floor <=
     * ceiling >=
     * @param persons
     * @param times
     */
    public TopVotedCandidate(int[] persons, int[] times) {
        voteMap = new TreeMap<>();

        int n = persons.length;
        int[] num = new int[n];

        int current = -1;

        for (int i = 0; i < n; i++) {
            int p = persons[i];
            int t = times[i];

            num[p] ++;

            if (current == -1 || num[p] >= num[current]) current = p;
            voteMap.put(t, current);
        }
    }

    public int q(int t) {
        Map.Entry<Integer, Integer> entry = voteMap.floorEntry(t);
        return entry.getValue();
    }


}

public class P911_OnlineElection {


}
