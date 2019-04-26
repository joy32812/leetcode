package com.leetcode;


import java.util.Map;
import java.util.TreeMap;

class TopVotedCandidate {

    TreeMap<Integer, Integer> voteMap;
    public TopVotedCandidate(int[] persons, int[] times) {
        voteMap = new TreeMap<>();
        int[] voteNums = new int[50010];

        int current = 0;
        for (int i = 0; i < persons.length; i++) {
            int p = persons[i];
            int t = times[i];

            voteNums[p]++;

            if (voteNums[p] >= voteNums[current]) {
                current = p;
                voteMap.put(t, p);
            }
        }
    }

    public int q(int t) {
        Integer integer = voteMap.floorKey(t);
        return voteMap.get(integer);
    }
}

public class P911_OnlineElection {


}
