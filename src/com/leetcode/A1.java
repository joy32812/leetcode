package com.leetcode;

public class A1 {


    public int dominantIndex(int[] nums) {

        int max = Integer.MIN_VALUE;
        int p = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                p = i;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (p == i) continue;

            if (nums[i] * 2 > max) return -1;
        }
        return p;
    }




    public static void main(String[] args) {

        System.out.println(new A1().dominantIndex(new int[]{3, 6, 1, 0}));
        System.out.println(new A1().dominantIndex(new int[]{3, 1, 2, 4}));
    }


}
