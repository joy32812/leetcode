package com.leetcode;

import java.util.HashSet;
import java.util.Set;

public class P1037_ValidBoomerang {


    /**
     * compare slope
     * @param points
     * @return
     */
    public boolean isBoomerang(int[][] points) {

        Set<String> uniqSet = new HashSet<>();
        for (int[] p : points) uniqSet.add(p[0] + "_" + p[1]);
        if (uniqSet.size() != 3) return false;

        int x1 = points[1][0] - points[0][0];
        int y1 = points[1][1] - points[0][1];

        int x2 = points[2][0] - points[0][0];
        int y2 = points[2][1] - points[0][1];

        return x1 * y2 != x2 * y1;

    }


    public static void main(String[] args) {

    }

}
