package com.leetcode;

/**
 * Created by xiaoyuan on 13/06/2017.
 */
public class P457_CircularArrayLoop {

    public boolean circularArrayLoop(int[] nums) {

        if (nums == null || nums.length <= 1) {return false;}


        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {continue;}

            int pa = next(nums, i);
            int pb = next(nums, i);
            pb = next(nums, pb);

            while (true) {
                if (pa == pb) {
                    if (check(nums, pa)) {return true;}

                    int x = pa;
                    int now = x;
                    while (true) {
                        int y = next(nums, x);
                        nums[x] = 0;
                        if (y == now) {break;}
                        x = y;
                    }

                    break;
                }
                pa = next(nums, pa);
                pb = next(nums, next(nums, pb));
            }

        }

        return false;
    }

    private boolean check(int[] A, int x) {

        if (x == next(A, x)) {return false;}

        int n = A.length;
        int now = x;
        while (true) {
            int y = x + A[x];
            if (y < 0 || y >= n) {return true;}

            if (y == now) {break;}
            x = y;
        }

        return false;
    }

    private int next(int[] A, int x) {
        int n = A.length;
        return (x + (A[x] % n) + n) % n;
    }

    public static void main(String[] args) {
        System.out.println(new P457_CircularArrayLoop().circularArrayLoop(new int[]{2, -1, 1, -2, -2}));
        System.out.println(new P457_CircularArrayLoop().circularArrayLoop(new int[]{-2, 1, -1, -2, -2}));
        System.out.println(new P457_CircularArrayLoop().circularArrayLoop(new int[]{-1, 2}));
        System.out.println(new P457_CircularArrayLoop().circularArrayLoop(new int[]{3, 1, 2}));
        System.out.println(new P457_CircularArrayLoop().circularArrayLoop(new int[]{-1, 2}));
    }

}
