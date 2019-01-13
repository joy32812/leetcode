package com.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class P973_KClosestPointstoOrigin {


    /**
     * just sort
     * @param points
     * @param K
     * @return
     */
    public int[][] kClosest(int[][] points, int K) {

        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {

                long aa = (long)o1[0] * o1[0] + (long)o1[1] * o1[1];
                long bb = (long)o2[0] * o2[0] + (long)o2[1] * o2[1];

                if (aa == bb) return 0;
                if (aa < bb) return -1;
                return 1;
            }
        });

        int[][] ans = new int[K][2];
        for (int i = 0; i < K; i++) ans[i] = points[i];
        return ans;
    }




    public static void main(String[] args) {

    }

}
