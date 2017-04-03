package com.leetcode;

/**
 * Created by xiaoyuan on 03/04/2017.
 */
public class P215_KthLargestElementinanArray {

    public int findKthLargest(int[] nums, int k) {
        return nums[quickSelect(nums, 0, nums.length - 1, nums.length - k + 1)];
    }

    private int quickSelect(int[] nums, int l, int r, int k) {
        int pivot = nums[r];

        int p = l;
        int ll = l;
        int rr = r;
        while (ll < rr) {
            if (nums[ll] > pivot) {
                swap(nums, ll, rr - 1);
                rr --;
            } else {
                ll ++;
            }
        }
        swap(nums, ll, r);

        int m = ll - l + 1;

        if (m == k) {
            return ll;
        } else if (m > k) {
            return quickSelect(nums, l, ll - 1, k);
        } else {
            return quickSelect(nums, ll + 1, r, k - m);
        }
    }

    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    public static void main(String[] args) {
        System.out.println(new P215_KthLargestElementinanArray().findKthLargest(new int[]{2, 1}, 1));
    }

}
