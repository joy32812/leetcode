package com.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by xiaoyuan on 01/07/2017.
 */
public class P565_ArrayNesting {

    public int arrayNesting(int[] nums) {
        if (nums == null || nums.length == 0) {return 0;}

        Set<Integer> usedSet = new HashSet<>();
        int ans = 1;
        for (int i = 0; i < nums.length; i++) {
            if (usedSet.contains(nums[i])) {continue;}

            int first = nums[i];
            int now = nums[i];
            int cnt = 0;
            while (true) {
                usedSet.add(now);
                cnt++;

                int next = nums[now];
                if (next == first) {break;}
                now = next;
            }

            ans = Math.max(ans, cnt);

        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new P565_ArrayNesting().arrayNesting(new int[]{5, 4, 0, 3, 1, 6, 2}));
    }

}
