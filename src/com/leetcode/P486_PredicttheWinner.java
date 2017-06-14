package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiaoyuan on 14/06/2017.
 */
public class P486_PredicttheWinner {


    private Map<Integer, Integer> ansMap;
    public boolean PredictTheWinner(int[] nums) {

        ansMap = new HashMap<>();
        return work(nums, 0, nums.length - 1) >= 0;
    }

    private int work(int[] nums, int l, int r) {
        int key = 1000 * l + r;
        if (ansMap.containsKey(key)) {return ansMap.get(key);}
        if (l == r) {
            ansMap.put(key, nums[l]);
            return ansMap.get(key);
        }

        int left = nums[l] - work(nums, l + 1, r);
        int right = nums[r] - work(nums, l, r - 1);


        ansMap.put(key, Math.max(left, right));
        return ansMap.get(key);
    }


    public static void main(String[] args) {
        System.out.println(new P486_PredicttheWinner().PredictTheWinner(new int[]{10,17,11,16,17,9,14,17,18,13,11,4,17,18,15,3,13,10,6,10}));
        System.out.println(new P486_PredicttheWinner().PredictTheWinner(new int[]{1, 5, 2}));
        System.out.println(new P486_PredicttheWinner().PredictTheWinner(new int[]{1, 5, 233, 7}));
    }
}
