package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoyuan on 27/06/2017.
 */
public class P539_MinimumTimeDifference {

    public int findMinDifference(List<String> timePoints) {
        timePoints.sort((a, b) -> (a.compareTo(b)));

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < timePoints.size(); i++) {
            ans = Math.min(ans, getDiff(timePoints.get(i), timePoints.get((i + timePoints.size() - 1) % timePoints.size())));
        }
        return ans;
    }

    private int getDiff(String a, String b) {
        int TOTAL = 24 * 60;
        int aMin = getMin(a);
        int bMin = getMin(b);
        return Math.min((aMin + TOTAL - bMin) % TOTAL, (bMin + TOTAL - aMin) % TOTAL);
    }

    private int getMin(String s) {
        String[] sArr = s.split(":");
        return Integer.parseInt(sArr[0]) * 60 + Integer.parseInt(sArr[1]);
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("23:59");
        list.add("00:00");
        System.out.println(new P539_MinimumTimeDifference().findMinDifference(list));
    }

}
