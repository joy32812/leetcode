package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xiaoyuan on 29/06/2017.
 */
public class P548_SplitArraywithEqualSum {

    public boolean splitArray(int[] nums) {
        if (nums == null || nums.length < 7) {return false;}

        int n = nums.length;
        int[] sum = new int[n];

        Map<Integer, List<Integer>> posMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            sum[i] = nums[i] + (i - 1 >= 0 ? sum[i - 1] : 0);
            posMap.computeIfAbsent(sum[i], k -> new ArrayList<Integer>()).add(i);
        }

        for (int i = nums.length - 2; i >= 5; i--) {
            int four = sum[nums.length - 1] - sum[i];
            if (!posMap.containsKey(four)) {continue;}

            List<Integer> posList = posMap.get(four);
            for (int p : posList) {
                p++;

                if (p + 4 > i) {continue;}
                int twoSum = sum[p] + four;
                if (!posMap.containsKey(twoSum)) {continue;}

                List<Integer> twoList = posMap.get(twoSum);
                for (int t : twoList) {
                    t++;
                    if (t < p + 1 || t > i - 1) {continue;}

                    if (sum[i - 1] - sum[t] == four) {return true;}
                }


            }

        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(new P548_SplitArraywithEqualSum().splitArray(new int[]{1,2,1,2,1,2,1}));
    }

}
