package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoyuan on 07/04/2017.
 */
public class P229_MajorityElementII {

    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        if (nums.length == 0) {return ans;}

        int num1 = nums[0], num2 = nums[0];
        int cnt1 = 1, cnt2 = 0;

        for (int i = 1; i < nums.length; i++) {
            int d = nums[i];
            if (d == num1) {
                cnt1 ++;
            } else if (d == num2) {
                cnt2 ++;
            } else if (cnt1 == 0) {
                cnt1 = 1;
                num1 = d;
            } else if (cnt2 == 0) {
                cnt2 = 1;
                num2 = d;
            } else {
                cnt1 --;
                cnt2 --;
            }
        }

        cnt1 = 0;
        cnt2 = 0;

        for (int d : nums) {
            if (d == num1) {cnt1 ++;}
            else if (d == num2) {cnt2 ++;}
        }

        if (cnt1 > nums.length / 3) {ans.add(num1);}
        if (cnt2 > nums.length / 3) {ans.add(num2);}


        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new P229_MajorityElementII().majorityElement(new int[]{1, 2}));
    }

}
