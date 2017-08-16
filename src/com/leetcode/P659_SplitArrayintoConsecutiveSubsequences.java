package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiaoyuan on 16/08/2017.
 */
public class P659_SplitArrayintoConsecutiveSubsequences {

    public boolean isPossible(int[] nums) {

        Map<Integer, Integer> cntMap = new HashMap<>();
        for (int d : nums) {cntMap.put(d, cntMap.getOrDefault(d, 0) + 1);}

        Map<Integer, Integer> seqMap = new HashMap<>();

        for (int d : nums) {
            if (cntMap.get(d) == 0) {continue;}

            if (seqMap.containsKey(d - 1) && seqMap.get(d - 1) > 0) {
                cntMap.put(d, cntMap.get(d) - 1);

                seqMap.put(d - 1, seqMap.get(d - 1) - 1);
                seqMap.put(d, seqMap.getOrDefault(d, 0) + 1);
            } else if (cntMap.containsKey(d + 1) && cntMap.containsKey(d + 2) && cntMap.get(d + 1) > 0 && cntMap.get(d + 2) > 0) {
                cntMap.put(d, cntMap.get(d) - 1);
                cntMap.put(d + 1, cntMap.get(d + 1) - 1);
                cntMap.put(d + 2, cntMap.get(d + 2) - 1);

                seqMap.put(d + 2, seqMap.getOrDefault(d + 2, 0) + 1);
            } else {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
//        System.out.println(new P659_SplitArrayintoConsecutiveSubsequences().isPossible(new int[]{1,2,3,3,4,5}));
        System.out.println(new P659_SplitArrayintoConsecutiveSubsequences().isPossible(new int[]{1,2,3,3,4,4,5,5}));
//        System.out.println(new P659_SplitArrayintoConsecutiveSubsequences().isPossible(new int[]{1,2,3,4,4,5}));
    }

}
