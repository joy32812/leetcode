package com.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by xiaoyuan on 14/05/2017.
 */
public class P356_LineReflection {

    public boolean isReflected(int[][] points) {

        if (points.length <= 1) {return true;}


        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int[] ll = points[0];
        int[] rr = points[points.length - 1];
        if (ll[0] == rr[0]) {return true;}
        final int y2 = ll[0] + rr[0];

        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    if (2 * o1[0] < y2) {
                        return o1[1] - o2[1];
                    } else {
                        return o2[1] - o1[1];
                    }
                }

                return o1[0] - o2[0];
            }
        });


        int[][] np = new int[points.length][2];
        int cnt = 0;
        np[cnt++] = points[0];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] == points[i - 1][0] && points[i][1] == points[i - 1][1]) {continue;}

            np[cnt++] = points[i];
        }

        int l = 0;
        int r = cnt - 1;

        points = np;


        while (l <= r) {
            int[] left = points[l];
            int[] right = points[r];

            if (left[0] * 2 == y2 && right[0] * 2 == y2) {
            } else if (left[1] == right[1] && left[0] + right[0] == y2) {
            } else {
                return false;
            }


            l++;
            r--;
        }


        return true;

    }

    public static void main(String[] args) {
        System.out.println(new P356_LineReflection().isReflected(new int[][]{
                {1, 2},
                {2, 2},
                {1, 4},
                {2, 4}
        }));
    }

}
