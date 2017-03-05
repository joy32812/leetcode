package com.leetcode;

/**
 * Created by xiaoyuan on 05/03/2017.
 */
public class P88_MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int pos = m + n - 1;
        int a = m - 1;
        int b = n - 1;
        while (true) {
            if (a < 0 && b < 0) {
                break;
            }

            if (a < 0) {
                nums1[pos--] = nums2[b--];
            } else if (b < 0) {
                nums1[pos--] = nums1[a--];
            } else {
                if (nums1[a] < nums2[b]) {
                    nums1[pos--] = nums2[b--];
                } else {
                    nums1[pos--] = nums1[a--];
                }
            }
        }
    }

    public static void main(String[] args) {

    }

}
