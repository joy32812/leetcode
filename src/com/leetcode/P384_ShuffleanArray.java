package com.leetcode;

import java.util.Random;

/**
 * Created by xiaoyuan on 22/05/2017.
 */
public class P384_ShuffleanArray {

    private class Solution {

        private int[] originNum;
        private Random random;

        public Solution(int[] nums) {
            originNum = nums;
            random = new Random();
        }

        /** Resets the array to its original configuration and return it. */
        public int[] reset() {
            return originNum;
        }

        /** Returns a random shuffling of the array. */
        public int[] shuffle() {
            int n = originNum.length;

            int[] ans = new int[n];
            int[] copy = new int[n];
            for (int i = 0; i < n; i++) {copy[i] = originNum[i];}

            int total = n;
            for (int i = 0; i < n; i++) {
                int pos = random.nextInt(total);
                ans[i] = copy[pos];

                copy[pos] = copy[total - 1];
                total--;
            }

            return ans;
        }
    }

    public static void main(String[] args) {

        P384_ShuffleanArray obj = new P384_ShuffleanArray();
        obj.work();
    }

    private void work() {
        Solution s = new Solution(new int[]{1, 3, 5, 7, 9});

        int[] result = s.shuffle();
        for (int d : result) {
            System.out.print(d + " ");
        }
        System.out.println();
    }


}

