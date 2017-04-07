package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xiaoyuan on 07/04/2017.
 *
 * find all the inner point and intersect point
 */
public class P223_RectangleArea {

    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        long[][] rectA = new long[4][];
        rectA[0] = new long[]{A, B};
        rectA[1] = new long[]{A, D};
        rectA[2] = new long[]{C, D};
        rectA[3] = new long[]{C, B};

        long[][] rectB = new long[4][];
        rectB[0] = new long[]{E, F};
        rectB[1] = new long[]{E, H};
        rectB[2] = new long[]{G, H};
        rectB[3] = new long[]{G, F};

        List<long[]> points = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            if (inRect(rectA[i], rectB)) {
                points.add(rectA[i]);
            }
        }

        for (int i = 0; i < 4; i++) {
            if (inRect(rectB[i], rectA)) {
                points.add(rectB[i]);
            }
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                checkIntersect(points, rectA[i], rectA[(i + 1) % 4], rectB[j], rectB[(j + 1) % 4]);
            }
        }

        long total = (rectA[2][0] - rectA[0][0]) * (rectA[2][1] - rectA[0][1]) + (rectB[2][0] - rectB[0][0]) * (rectB[2][1] - rectB[0][1]);
        if (points.size() == 0) {
            return (int)total;
        } else {
            return (int)(total - getSmallRectArea(points));
        }
    }

    private void checkIntersect(List<long[]> points, long[] pa, long[] pb, long[] pc, long[] pd) {
        // parallel
        if (pa[0] == pb[0] && pc[0] == pd[0]) {return;}
        if (pa[1] == pb[1] && pc[1] == pd[1]) {return;}

        if (pa[0] == pb[0]) {
            if ((pa[0] - pc[0]) * (pa[0] - pd[0]) < 0 && (pc[1] - pa[1]) * (pc[1] - pb[1]) < 0) {
                points.add(new long[]{pa[0], pc[1]});
            }
        } else {
            if ((pc[0] - pa[0]) * (pc[0] - pb[0]) < 0 && (pa[1] - pc[1]) * (pa[1] - pd[1]) < 0) {
                points.add(new long[]{pc[0], pa[1]});
            }
        }

    }


    private long getSmallRectArea(List<long[]> points) {
        long a = 0;
        long b = 0;
        long[] p0 = points.get(0);
        for (int i = 1; i < points.size(); i++) {
            long[] pi = points.get(i);
            a = Math.max(a, Math.abs(pi[0] - p0[0]));
            b = Math.max(b, Math.abs(pi[1] - p0[1]));
        }

        return a * b;
    }

    private boolean inRect(long[] p, long[][] rect) {
        if (p[0] >= rect[0][0] && p[0] <= rect[2][0] && p[1] >= rect[0][1] && p[1] <= rect[2][1]) {
            return true;
        }
        return false;
    }



    // much easier solution
    // find the coverX and coverY
    int computeArea2(int A, int B, int C, int D, int E, int F, int G, int H) {
        int area1 = (C - A) * (D - B);
        int area2 = (G - E) * (H - F);

        int coverX = getCover(A, C, E, G);
        int coverY = getCover(B, D, F, H);

        return area1 + area2 - coverX * coverY;
    }

    private int getCover(int A, int C, int E, int G) {
        int cover = 0;
        if (C <= E || G <= A) {
            cover = 0;
        } else {
            int[] arr = new int[]{A, C, E, G};
            Arrays.sort(arr);
            cover = arr[2] - arr[1];
        }
        return cover;
    }


    public static void main(String[] args) {

    }

}

