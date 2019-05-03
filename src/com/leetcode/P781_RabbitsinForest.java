package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class P781_RabbitsinForest {

    public int numRabbits(int[] answers) {

        Map<Integer, Integer> cntMap = new HashMap<>();
        for (int d : answers) cntMap.put(d, cntMap.getOrDefault(d, 0) + 1);

        int ans = 0;
        for (int d : cntMap.keySet()) {
            int num = cntMap.get(d);
            int group = d + 1;

            ans += (num / group + (num % group != 0 ? 1 : 0)) * group;

        }

        return ans;
    }

}
