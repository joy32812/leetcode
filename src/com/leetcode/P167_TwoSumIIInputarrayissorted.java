package com.leetcode;

/**
 * Created by xiaoyuan on 27/03/2017.
 * binary search
 *
 */
public class P167_TwoSumIIInputarrayissorted {

    public int[] twoSum(int[] numbers, int target) {
        int[] ans = new int[2];
        
        int l = 0, r = numbers.length - 1;
        
        while (l < r) {
            if (numbers[l] + numbers[r] == target) {
                ans[0] = l + 1;
                ans[1] = r + 1;
                break;
            } else if (numbers[l] + numbers[r] > target) {
                int p = bSearch(numbers, l + 1, r - 1, target - numbers[l]);
                if (numbers[l] + numbers[p] == target) {
                    ans[0] = l + 1;
                    ans[1] = p + 1;
                    break;
                } else {
                    r = p - 1;
                }
            } else {
                int p = bSearch(numbers, l + 1, r - 1, target - numbers[r]);
                if (numbers[p] + numbers[r] == target) {
                    ans[0] = p + 1;
                    ans[1] = r + 1;
                    break;
                } else {
                    l = p;
                }
            }
        }
        
        return ans;
    }

    private int bSearch(int[] arr, int l, int r, int data) {
        if (arr[l] >= data) {return l;}
        if (arr[r] < data) {return r + 1;}

        while (l < r) {
            int m = (l + r) / 2;
            if (arr[m] >= data) {
                r = m;
            } else {
                l = m + 1;
            }
        }

        return l;
    }

    public static void main(String[] args) {
        int[] ans = new P167_TwoSumIIInputarrayissorted().twoSum(new int[]{3,24,50,79,88,150,345}, 200);
//        int[] ans = new P167_TwoSumIIInputarrayissorted().twoSum(new int[]{1,2,3,4,4,56,90}, 8);
        System.out.println(ans[0]);
        System.out.println(ans[1]);
    }

}
