package com.leetcode;

import java.util.*;

/**
 * Created by xiaoyuan on 26/05/2017.
 */
public class P398_RandomPickIndex {

    class Solution {

        Map<Integer, List<Integer>> posMap;
        Random random;

        public Solution(int[] nums) {
            random = new Random();
            posMap = new HashMap<>();

            for (int i = 0; i < nums.length; i++) {
                posMap.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
            }
        }

        public int pick(int target) {
            List<Integer> indexList = posMap.get(target);
            return indexList.get(random.nextInt(indexList.size()));
        }
    }




    public static void main(String[] args) {
        System.out.println(new P398_RandomPickIndex().work());
    }

    private int work() {
        Solution s = new Solution(new int[]{1, 2, 3, 3, 3});

        System.out.println(s.pick(1));

        return 0;
    }

}
