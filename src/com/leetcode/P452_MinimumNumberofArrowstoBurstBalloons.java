package com.leetcode;

import java.util.Arrays;

/**
 * Created by xiaoyuan on 08/06/2017.
 */
public class P452_MinimumNumberofArrowstoBurstBalloons {

    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) {return 0;}

        Arrays.sort(points, (a, b) -> (a[1] - b[1]));

        int ans = 1;
        int now = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] <= now) {continue;}

            ans++;
            now = points[i][1];
        }

        return ans;
    }

}
