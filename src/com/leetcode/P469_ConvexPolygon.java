package com.leetcode;

import java.util.List;

/**
 * Created by xiaoyuan on 11/09/2017.
 */
public class P469_ConvexPolygon {

    public boolean isConvex(List<List<Integer>> points) {

        boolean isNeg = false;
        boolean isPos = false;

        int size = points.size();

        for (int i = 0; i < size; i++) {
            int j = (i + 1) % size;
            int k = (i + 2) % size;

            int v = crossProductLength(
                    points.get(i).get(0), points.get(i).get(1),
                    points.get(j).get(0), points.get(j).get(1),
                    points.get(k).get(0), points.get(k).get(1)
            );

            if (v < 0) {isNeg = true;}
            if (v > 0) {isPos = true;}

            if (isNeg && isPos) {return false;}
        }

        return true;
    }



    private int crossProductLength (int ax, int ay, int bx, int by, int cx, int cy) {

        int mx = ax - bx;
        int my = ay - by;

        int nx = cx - bx;
        int ny = cy - by;

        return mx * ny - my * nx;
    }

}
