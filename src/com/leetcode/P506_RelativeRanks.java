package com.leetcode;

import java.util.*;

/**
 * Created by xiaoyuan on 21/06/2017.
 */
public class P506_RelativeRanks {

    public String[] findRelativeRanks(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new String[]{};
        }

        int n = nums.length;

        int[][] orderedNums = new int[n][3];
        for (int i = 0; i < n; i++) {
            orderedNums[i][0] = nums[i];
            orderedNums[i][1] = i;
        }

        Arrays.sort(orderedNums, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return -(o1[0] - o2[0]);
            }
        });

        for (int i = 0; i < n; i++) {
            orderedNums[i][2] = i;
        }
        Arrays.sort(orderedNums, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (o1[1] - o2[1]);
            }
        });


        String[] ans = new String[n];
        for (int i = 0; i < n; i++) {
            if (orderedNums[i][2] == 0) {
                ans[i] = "Gold Medal";
            } else if (orderedNums[i][2] == 1) {
                ans[i] = "Silver Medal";
            } else if (orderedNums[i][2] == 2) {
                ans[i] = "Bronze Medal";
            } else {
                ans[i] = "" + (1 + orderedNums[i][2]);
            }
            System.out.println(ans[i]);
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new P506_RelativeRanks().findRelativeRanks(new int[]{5, 4, 3, 2 ,1}));
    }

}
