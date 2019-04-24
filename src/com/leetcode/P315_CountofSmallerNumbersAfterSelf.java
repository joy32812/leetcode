package com.leetcode;

import java.util.*;

/**
 * Created by xiaoyuan on 02/05/2017.
 */
public class P315_CountofSmallerNumbersAfterSelf {

    int[] BIT;
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        if (nums == null || nums.length == 0) return ans;

        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int d : nums) treeSet.add(d);

        Map<Integer, Integer> map = new HashMap<>();
        int cnt = 0;
        for (int d : treeSet) map.put(d, ++cnt);
        for (int i = 0; i < nums.length; i++) nums[i] = map.get(nums[i]);

        BIT = new int[treeSet.size() + 1];

        for (int i = nums.length - 1; i >= 0; i--) {
            ans.add(find(nums[i] - 1));
            insert(nums[i]);
        }

        Collections.reverse(ans);

        return ans;
    }

    private void insert(int d) {
        while (d < BIT.length) {
            BIT[d]++;
            d += d & -d;
        }
    }

    private Integer find(int d) {
        int ans = 0;
        while (d > 0) {
            ans += BIT[d];
            d -= d & -d;
        }
        return ans;
    }


    public static void main(String[] args) {
        System.out.println(new P315_CountofSmallerNumbersAfterSelf().countSmaller(new int[]{26, 78, 27, 1, 1}));
//        System.out.println(new P315_CountofSmallerNumbersAfterSelf().countSmaller(new int[]{26,78,27,100,33,67,90,23,66,5,38,7,35,23,52,22,83,51,98,69,81,32,78,28,94,13,2,97,3,76,99,51,9,21,84,66,65,36,100,41}));
    }

}
