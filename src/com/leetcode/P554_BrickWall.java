package com.leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xiaoyuan on 29/06/2017.
 */
public class P554_BrickWall {

    public int leastBricks(List<List<Integer>> wall) {
        int size = wall.size();

        Map<Integer, Integer> cntMap = new HashMap<>();
        for (List<Integer> bricks : wall) {
            int total = 0;
            for (int d : bricks) {
                if (total != 0) {
                    cntMap.put(total, cntMap.getOrDefault(total, 0) + 1);
                }
                total += d;
            }
        }

        int ans = size;
        for (int d : cntMap.values()) {
            ans = Math.min(ans, size - d);
        }
        return ans;
    }

}
