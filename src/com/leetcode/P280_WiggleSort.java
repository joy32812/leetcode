package com.leetcode;

import java.util.Arrays;

/**
 * Created by xiaoyuan on 18/04/2017.
 */
public class P280_WiggleSort {

    public void wiggleSort(int[] nums) {

        Arrays.sort(nums);

        int n = nums.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[getNewIndex(i, n)] = i;
        }


        for (int i = 0; i < n; i++) {
            if (arr[i] == -1) {continue;}

            int begin = i;
            int value = nums[i];
            int x = i;
            while (arr[x] != -1) {
                if (arr[x] == begin) {break;}
                nums[x] = nums[arr[x]];
                int tmp = arr[x];
                arr[x] = -1;
                x = tmp;
            }

            nums[x] = value;
            arr[x] = -1;
        }

        for (int i = 0; i < n; i++) {
            System.out.println(nums[i]);
        }

    }


    private int getNewIndex(int x, int n) {
        int half = n / 2;

        if (x < half) {
           return 2 * x;
        } else if (x == half) {
            return n - 1;
        } else {
            return (n - x) * 2 - 1;
        }
    }

    public static void main(String[] args) {
        new P280_WiggleSort().wiggleSort(new int[]{3,5,2,1,6,4,11});
    }

}
