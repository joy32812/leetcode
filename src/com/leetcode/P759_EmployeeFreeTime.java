package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class P759_EmployeeFreeTime {

    public int[][] employeeFreeTime(int[][][] schedule) {
        List<int[]> ansList = new ArrayList<>();
        if (schedule == null || schedule.length == 0) return null;

        List<int[]> ends = new ArrayList<>();
        for (int[][] em : schedule) {
            for (int[] time : em) {
                // start
                ends.add(new int[]{time[0], 0});
                // end
                ends.add(new int[]{time[1], 1});
            }
        }

        ends.sort((a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });

        int start = -1;
        int cnt = 0;
        for (int[] time : ends) {
            if (time[1] == 0) {
                if (cnt == 0 && start != -1 && start != time[0]) {
                    ansList.add(new int[]{start, time[0]});
                }
                cnt++;
            } else {
                cnt--;

                if (cnt == 0) start = time[0];
            }
        }

        int[][] ans = new int[ansList.size()][2];
        for (int i = 0; i < ansList.size(); i++) ans[i] = ansList.get(i);

        return ans;
    }

}
