package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiaoyuan on 29/06/2017.
 */
public class P553_OptimalDivision {

    Map<String, String> ansMap;
    Map<String, Double> resMap;

    public String optimalDivision(int[] nums) {

        ansMap = new HashMap<>();
        resMap = new HashMap<>();

        return (String)(work(nums, 0, nums.length - 1)[1]);
    }

    private Object[] work(int[] nums, int l, int r) {

        String minKey = l + "_" + r + "_MIN";
        String maxKey = l + "_" + r + "_MAX";

        if (ansMap.containsKey(minKey)) {
            return new Object[]{resMap.get(maxKey), ansMap.get(maxKey), resMap.get(minKey), ansMap.get(minKey)};
        }

        if (l == r) {
            resMap.put(maxKey, 0.0 + nums[l]);
            ansMap.put(maxKey, "" + nums[l]);
            resMap.put(minKey, 0.0 + nums[l]);
            ansMap.put(minKey, "" + nums[l]);
            return new Object[]{resMap.get(maxKey), ansMap.get(maxKey), resMap.get(minKey), ansMap.get(minKey)};
        }

        if (l + 1 == r) {
            resMap.put(maxKey, (0.0 + nums[l]) / nums[r]);
            ansMap.put(maxKey, "" + nums[l] + "/" + nums[r]);
            resMap.put(minKey, (0.0 + nums[l]) / nums[r]);
            ansMap.put(minKey, "" + nums[l] + "/" + nums[r]);
            return new Object[]{resMap.get(maxKey), ansMap.get(maxKey), resMap.get(minKey), ansMap.get(minKey)};
        }

        double maxVal = 0.0;
        String maxAns = "";
        double minVal = Double.MAX_VALUE;
        String minAns = "";

        for (int i = l; i < r; i++) {
            Object[] left = work(nums, l, i);
            Object[] right = work(nums, i + 1, r);

            if (maxVal < (Double)left[0] / (Double)right[2]) {
                maxVal = (Double)left[0] / (Double)right[2];
                maxAns = left[1] + "/" + (i + 1 == r ? "" : "(") + right[3] + (i + 1 == r ? "" : ")");
            }

            if (minVal > (Double)left[2] / (Double)right[0]) {
                minVal = (Double)left[2] / (Double)right[0];
                minAns = left[3] + "/" + (i + 1 == r ? "" : "(") + right[1] + (i + 1 == r ? "" : ")");
            }
        }

        resMap.put(maxKey, maxVal);
        ansMap.put(maxKey, maxAns);
        resMap.put(minKey, minVal);
        ansMap.put(minKey, minAns);


        return new Object[]{resMap.get(maxKey), ansMap.get(maxKey), resMap.get(minKey), ansMap.get(minKey)};
    }

    public static void main(String[] args) {
        System.out.println(new P553_OptimalDivision().optimalDivision(new int[]{1000, 100, 10, 2}));
    }
}
