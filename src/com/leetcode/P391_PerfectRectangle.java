package com.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by xiaoyuan on 31/05/2017.
 */
public class P391_PerfectRectangle {

    public boolean isRectangleCover(int[][] rectangles) {

        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;

        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;

        Set<String> set = new HashSet<>();

        int area = 0;
        for (int[] rect : rectangles) {
            minX = Math.min(minX, rect[0]);
            minY = Math.min(minY, rect[1]);
            maxX = Math.max(maxX, rect[2]);
            maxY = Math.max(maxY, rect[3]);

            area += (rect[2] - rect[0]) * (rect[3] - rect[1]);

            String s1 = rect[0] + "_" + rect[1];
            String s2 = rect[0] + "_" + rect[3];
            String s3 = rect[2] + "_" + rect[3];
            String s4 = rect[2] + "_" + rect[1];

            if (!set.add(s1)) set.remove(s1);
            if (!set.add(s2)) set.remove(s2);
            if (!set.add(s3)) set.remove(s3);
            if (!set.add(s4)) set.remove(s4);
        }

        if (set.size() != 4) {return false;}
        if (!set.contains(minX + "_" + minY)) {return false;}
        if (!set.contains(minX + "_" + maxY)) {return false;}
        if (!set.contains(maxX + "_" + minY)) {return false;}
        if (!set.contains(maxX + "_" + maxY)) {return false;}

        return area == (maxX - minX) * (maxY - minY);
    }

}
