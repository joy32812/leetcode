package com.leetcode;

/**
 * Created by xiaoyuan on 05/03/2017.
 *
 * 1. find the Pivot
 * 2. binary search twice
 */
public class P81_SearchinRotatedSortedArrayII {

    private int binarySearch(int[] nums, int l, int r, int target) {
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public boolean search(int[] nums, int target) {
        if (nums.length == 0) {return false;}

        int pos = findPivot(nums, 0, nums.length - 1);
        int inA = binarySearch(nums, 0, pos, target);
        int inB = binarySearch(nums, pos + 1, nums.length, target);

//
//        System.out.println(pos);
//        System.out.println(inA);
//        System.out.println(inB);

        if (inA >= 0 && inA < nums.length && nums[inA] == target) {
            return true;
        }
        if (inB >= 0 && inB < nums.length && nums[inB] == target) {
            return true;
        }

        return false;
    }

    private int findPivot(int[] nums, int l, int r) {
        if (l + 1 == r || l == r) {
            return l;
        }
        while (l < r) {
            if (l + 1 == r) {break;}
            int mid = (l + r) / 2;
            if (nums[mid] > nums[r]) {
                l = mid;
            } else if (nums[mid] < nums[r]) {
                r = mid;
            } else {
                int aa = findPivot(nums, l, mid);
                int bb = findPivot(nums, mid, r);

                if (aa + 1 < nums.length && nums[aa] > nums[aa + 1]) {
                    return aa;
                }
                if (bb + 1 < nums.length && nums[bb] > nums[bb + 1]) {
                    return bb;
                }
                return aa;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 1, 1, 1, 1, 1, 3, 1, 1};
        int[] nums2 = {1, 1, 3, 1, 1, 1, 1, 1};
        int[] nums3 = {5, 5, 7, 9, 15, 15, 1, 1, 5, 5};
        int[] nums4 = {1, 1, 1};
        int[] nums5 = {3, 1};
        int[] nums6 = {2, 2, 2, 0, 2, 2};

        System.out.println(new P81_SearchinRotatedSortedArrayII().search(nums1, 3));
        System.out.println(new P81_SearchinRotatedSortedArrayII().search(nums2, 3));
        System.out.println(new P81_SearchinRotatedSortedArrayII().search(nums3, 3));
        System.out.println(new P81_SearchinRotatedSortedArrayII().search(nums4, 3));
        System.out.println(new P81_SearchinRotatedSortedArrayII().search(nums5, 1));
        System.out.println(new P81_SearchinRotatedSortedArrayII().search(nums6, 0));
    }

}
