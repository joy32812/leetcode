package com.leetcode;


import java.util.*;

/**
 * Created by xiaoyuan on 13/04/2017.
 */
public class P253_MeetingRoomsII {

    public int minMeetingRooms(int[][] intervals) {
        List<int[]> points = new ArrayList<>();
        for (int[] interval : intervals) {
            points.add(new int[]{0, interval[0]});
            points.add(new int[]{1, interval[1]});
        }

        points.sort((a, b) -> {
            if (a[1] == b[1]) return - (a[0] - b[0]);
            return a[1] - b[1];
        });

        int ans = 0;
        int now = 0;
        for(int[] p : points) {
            if (p[0] == 0) now++;
            else now-- ;

            ans = Math.max(ans, now);
        }

        return ans;
    }

    public static void main(String[] args) {


    }

}
