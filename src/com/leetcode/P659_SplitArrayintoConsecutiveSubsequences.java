package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiaoyuan on 16/08/2017.
 */
public class P659_SplitArrayintoConsecutiveSubsequences {

    /**
     * greedy
     * first check if it can be appened
     * then check if it can be a new start
     * @param nums
     * @return
     */
    public boolean isPossible(int[] nums) {
        if (nums == null || nums.length < 3) return false;

        Map<Integer, Integer> cntMap = new HashMap<>();
        Map<Integer, Integer> tailMap = new HashMap<>();

        for (int d : nums) cntMap.put(d, cntMap.getOrDefault(d, 0) + 1);

        for (int d : nums) {
            if (cntMap.getOrDefault(d, 0) == 0) continue;

            if (tailMap.getOrDefault(d, 0) > 0) {
                tailMap.put(d, tailMap.get(d) - 1);
                cntMap.put(d, cntMap.get(d) - 1);

                tailMap.put(d + 1, tailMap.getOrDefault(d + 1, 0) + 1);
            } else if (cntMap.getOrDefault(d + 1, 0) > 0 && cntMap.getOrDefault(d + 2, 0) > 0) {
                cntMap.put(d, cntMap.get(d) - 1);
                cntMap.put(d + 1, cntMap.get(d + 1) - 1);
                cntMap.put(d + 2, cntMap.get(d + 2) - 1);

                tailMap.put(d + 3, tailMap.getOrDefault(d + 3, 0) + 1);
            } else {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
//        System.out.println(new P659_SplitArrayintoConsecutiveSubsequences().isPossible(new int[]{1,2,3,3,4,5}));
        System.out.println(new P659_SplitArrayintoConsecutiveSubsequences().isPossible(new int[]{1,2,3,3,4,4,5,5}));
    }

}
