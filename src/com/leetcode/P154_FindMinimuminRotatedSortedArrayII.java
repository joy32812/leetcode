package com.leetcode;

/**
 * Created by xiaoyuan on 21/03/2017.
 */
public class P154_FindMinimuminRotatedSortedArrayII {

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

    public int findMin(int[] nums) {
        if (nums.length == 1) {return nums[0];}

        int p = findPivot(nums, 0, nums.length - 1);

        int ans = nums[p];
        if (p + 1 < nums.length) {
            ans = Math.min(ans, nums[p + 1]);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new P154_FindMinimuminRotatedSortedArrayII().findMin(new int[]{4, 5, 6, 6, 6, 7, 7, 0, 0, 1, 1, 2}));
        System.out.println(new P154_FindMinimuminRotatedSortedArrayII().findMin(new int[]{0,0,0}));
        System.out.println(new P154_FindMinimuminRotatedSortedArrayII().findMin(new int[]{3,3,1,3}));
        System.out.println(new P154_FindMinimuminRotatedSortedArrayII().findMin(new int[]{4, 6, 6, 6, 6, 6, 6, 6 , 1, 1}));
        System.out.println(new P154_FindMinimuminRotatedSortedArrayII().findMin(new int[]{4, 5, 6, 7, 8, 9}));
    }

}


