package com.leetcode;

public class P912_SortanArray {

    public int[] sortArray(int[] nums) {

        int delta = 50000;
        int high = 100000;
        int[] bucket = new int[high + 10];

        for (int d : nums) bucket[delta + d]++;

        int ind = 0;
        for (int i = 0; i <= high; i++) {
            if (bucket[i] == 0) continue;

            for (int j = 0; j < bucket[i]; j++) {
                nums[ind++] = i - delta;
            }
        }

        return nums;
    }

}
