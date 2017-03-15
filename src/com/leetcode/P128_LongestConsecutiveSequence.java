package com.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by xiaoyuan on 15/03/2017.
 */
public class P128_LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {return 0;}

        Set<Integer> numSet = new HashSet<Integer>();
        for (int n : nums) {numSet.add(n);}

        int ans = 1;
        for (int n : nums) {
            if (numSet.contains(n - 1)) {continue;}
            int cnt = 1;
            n++;
            while (numSet.contains(n)) {
                cnt ++;
                n ++;
            }
            ans = Math.max(ans, cnt);
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new P128_LongestConsecutiveSequence().longestConsecutive(new int[]{100, 1, 3, 2, 4}));
    }

}
