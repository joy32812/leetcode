package com.leetcode;

import java.util.HashSet;
import java.util.Set;

public class P939_MinimumAreaRectangle {


    /**
     * count all the rectangle by diagonal
     * find the minimal area
     * @param points
     * @return
     */
    public int minAreaRect(int[][] points) {
        if (points == null || points.length <= 3 || points[0].length == 0) return 0;

        Set<String> pointSet = new HashSet<>();

        for (int[] p : points) {
            pointSet.add("" + p[0] + "-" + p[1]);
        }

        int ans = Integer.MAX_VALUE;
        int size = points.length;
        for (int i = 0; i < size; i++) {

            for (int j = 0; j < size; j++) {

                int[] a = points[i];
                int[] b = points[j];
                if (a[0] == b[0] || a[1] == b[1]) continue;

                if (!pointSet.contains("" + a[0] + "-" + b[1])) continue;
                if (!pointSet.contains("" + b[0] + "-" + a[1])) continue;

                ans = Math.min(ans, Math.abs(a[0] - b[0]) * Math.abs(a[1] - b[1]));
            }

        }


        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    public static void main(String[] args) {

    }

}
