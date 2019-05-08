package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by xiaoyuan on 01/07/2017.
 */
public class P621_TaskScheduler {

    public int leastInterval(char[] tasks, int n) {
        if (n == 0) {return tasks.length;}

        int[] cnt = new int[26];
        for (char ch : tasks) cnt[ch - 'A'] ++;
        Arrays.sort(cnt);

        int maxVal = cnt[25] - 1;
        int slotNum = maxVal * n;

        for (int i = 24; i >= 0; i--) {
            slotNum -= Math.min(maxVal, cnt[i]);
        }

        return slotNum > 0 ? slotNum + tasks.length : tasks.length;
    }

    public static void main(String[] args) {
        System.out.println(new P621_TaskScheduler().leastInterval(new char[]{'A','A','A','B','B','B'}, 2));
    }

}
