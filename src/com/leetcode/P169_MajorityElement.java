package com.leetcode;

/**
 * Created by xiaoyuan on 27/03/2017.
 *
 * just remove the two when they are different
 */
public class P169_MajorityElement {

    public int majorityElement(int[] nums) {
        int last = 0;
        int cnt = 0;
        for (int d : nums) {
            if (cnt == 0) {
                last = d;
                cnt = 1;
            } else {
                if (last == d) {
                    cnt++;
                } else {
                    cnt--;
                }
            }
        }

        return last;
    }

    public static void main(String[] args) {
        System.out.println(new P169_MajorityElement().majorityElement(new int[]{1, 2, 2, 2, 5}));
    }

}
