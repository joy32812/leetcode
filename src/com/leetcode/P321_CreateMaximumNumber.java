package com.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

/**
 * Created by xiaoyuan on 05/05/2017.
 */
public class P321_CreateMaximumNumber {

    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int m = nums2.length;
        int[] ans = new int[k];

        for (int i = Math.max(0, k - m); i <= k && i <= n; i++) {
            int[] now = merge(maxArray(nums1, i), maxArray(nums2, k - i));
            if (greater(now, 0, ans, 0)) {ans = now;}
        }

        return ans;
    }

    private boolean greater(int[] A, int i, int[] B, int j) {
        while (i < A.length && j < B.length && A[i] == B[j]) {
            i++;
            j++;
        }

        return (j == B.length) || (i < A.length && A[i] > B[j]);
    }

    private int[] merge(int[] A, int[] B) {
        int[] ans = new int[A.length + B.length];
        for (int i = 0, j = 0, y = 0; y < A.length + B.length; y++) {
            ans[y] = greater(A, i, B, j) ? A[i++] : B[j++];
        }

        return ans;
    }

    private int[] maxArray(int[] nums, int k) {

        int n = nums.length;
        int[] ans = new int[k];
        for (int i = 0, j = 0; i < n; i++) {
            while (j > 0 && n - i + j > k && ans[j - 1] < nums[i]) {j--;}
            if (j < k) {ans[j++] = nums[i];}
        }

        return ans;
    }

    public static void main(String[] args) {

//        System.out.println(new P321_CreateMaximumNumber().maxNumber(
//                new int[]{6, 7, 5},
//                new int[]{4, 8, 1},
//                3));
//        System.out.println(new P321_CreateMaximumNumber().maxNumber(
//                new int[]{3, 9},
//                new int[]{8, 9},
//                3));
//        System.out.println(new P321_CreateMaximumNumber().maxNumber(
//                new int[]{6, 7},
//                new int[]{6, 0, 4},
//                5));
        System.out.println(new P321_CreateMaximumNumber().maxNumber(
                new int[]{3, 4, 6, 5},
                new int[]{9, 1, 2, 5, 8, 3},
                5));
    }

}
