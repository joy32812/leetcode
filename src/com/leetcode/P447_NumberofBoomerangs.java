package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xiaoyuan on 07/06/2017.
 */
public class P447_NumberofBoomerangs {

    public int numberOfBoomerangs(int[][] points) {
        int ans = 0;

        Map<Long, Integer> rcMap = new HashMap<>();
        int n = points.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {continue;}

                long dis = dis(points[i], points[j]);
                rcMap.put(dis, rcMap.getOrDefault(dis, 0) + 1);
            }

            for (int d : rcMap.values()) {
                ans += d * (d - 1);
            }

            rcMap.clear();
        }

        return ans;
    }


    private long dis(int[] a, int[] b) {
        return (0l + a[0] - b[0]) * (0l + a[0] - b[0]) + (0l + a[1] - b[1]) * (0l + a[1] - b[1]);
    }

    public static void main(String[] args) {
        System.out.println(new P447_NumberofBoomerangs().numberOfBoomerangs(new int[][]{
                {1, 1},
                {2, 2},
                {3, 3}
        }));
    }
}
