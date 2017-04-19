package com.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by xiaoyuan on 19/04/2017.
 */
public class P283_MoveZeroes {

    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {return;}

        int pos = 0;
        for (int d : nums) {
            if (d != 0) {
                nums[pos++] = d;
            }
        }

        while (pos < nums.length) {
            nums[pos++] = 0;
        }
    }

    public static void main(String[] args) {
        new P283_MoveZeroes().moveZeroes(new int[]{0, 1, 0, 3, 12});
    }

}
