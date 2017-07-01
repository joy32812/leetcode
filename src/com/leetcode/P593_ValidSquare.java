package com.leetcode;

import java.util.Arrays;

/**
 * Created by xiaoyuan on 01/07/2017.
 */
public class P593_ValidSquare {

    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {

        long[] distances = new long[6];
        int[][] points = {
                p1,
                p2,
                p3,
                p4
        };

        int cnt = 0;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int[] pa = points[i];
                int[] pb = points[j];
                distances[cnt++] = getDis(pa, pb);
            }
        }

        Arrays.sort(distances);

        if (distances[0] == 0) {return false;}

        for (int i = 1; i <= 3; i++) {
            if (distances[i] != distances[i - 1]) {return false;}
        }

        return distances[4] == 2 * distances[0] && distances[5] == 2 * distances[0];

    }

    private long getDis(int[] pa, int[] pb) {
        return 0l + (pa[0] - pb[0]) * (pa[0] - pb[0]) + (pa[1] - pb[1]) * (pa[1] - pb[1]);
    }

}
