package com.leetcode;

public class P836_RectangleOverlap {

    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {

        if (noOverLap(rec1[0], rec1[2], rec2[0], rec2[2])) return false;
        if (noOverLap(rec1[1], rec1[3], rec2[1], rec2[3])) return false;

        return true;
    }

    private boolean noOverLap(int x1, int x2, int x3, int x4) {
        if (x2 <= x3) return true;
        if (x4 <= x1) return true;
        return false;
    }


}
