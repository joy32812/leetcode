package com.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by xiaoyuan on 01/07/2017.
 */
public class P581_ShortestUnsortedContinuousSubarray {

    public int findUnsortedSubarray(int[] nums) {

        if (nums == null || nums.length == 0) {return 0;}

        int n = nums.length;
        int[][] orderArr  = new int[n][2];
        for (int i = 0; i < n; i++) {
            orderArr[i][0] = nums[i];
            orderArr[i][1] = i;
        }


        Arrays.sort(orderArr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int l = n;
        for (int i = 0; i < n; i++) {
            if (orderArr[i][1] != i) {
                l = i;
                break;
            }
        }

        int r = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (orderArr[i][1] != i) {
                r = i;
                break;
            }
        }

        if (l >= r) {
            return 0;
        }

        return (r - l + 1);
    }

    public static void main(String[] args) {
        System.out.println(new P581_ShortestUnsortedContinuousSubarray().findUnsortedSubarray(new int[]{1, 2, 3, 4}));
    }


}
