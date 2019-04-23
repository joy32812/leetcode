package com.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public class P850_RectangleAreaII {

    /**
     * scan by X
     * then merge Y intervel
     * @param rectangles
     * @return
     */
    public int rectangleArea(int[][] rectangles) {
        if (rectangles == null || rectangles.length == 0) return 0;

        TreeSet<Integer> xSet = new TreeSet<>();
        for (int[] rect : rectangles) {
            xSet.add(rect[0]);
            xSet.add(rect[2]);
        }

        Integer[] xArr = xSet.toArray(new Integer[0]);


        long ans = 0;
        long MOD = (long) (1e9 + 7);

        for (int i = 1; i < xArr.length; i++) {
            int from = xArr[i - 1];
            int to = xArr[i];

            List<int[]> yList = new ArrayList<>();
            for (int[] rect : rectangles) {
                if (rect[0] <= from && rect[2] >= to) {
                    yList.add(new int[]{rect[1], rect[3]});
                }
            }
            yList.sort(Comparator.comparingInt(a -> a[0]));
            int[] now = new int[]{-1, -1};

            long edge = 0;
            for (int[] yi : yList) {
                if (now[1] < yi[0]) {
                    if (now[1] != -1) edge += now[1] - now[0];
                    now = yi;
                } else {
                    now[1] = Math.max(now[1], yi[1]);
                }
            }
            if (now[1] != -1) edge += now[1] - now[0];

            ans = (ans + edge * (to - from)) % MOD;
        }

        return (int) ans;
    }


    public static void main(String[] args) {
        System.out.println(new P850_RectangleAreaII().rectangleArea(new int[][]{
                {0, 0, 2, 2},
                {1, 1, 3, 3}
        }));
    }
}
