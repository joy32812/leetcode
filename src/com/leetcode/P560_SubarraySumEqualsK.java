package com.leetcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by xiaoyuan on 30/06/2017.
 */
public class P560_SubarraySumEqualsK {

    public int subarraySum(int[] nums, int k) {

        Map<Integer, LinkedList<Integer>> cntMap = new HashMap<>();
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
            cntMap.computeIfAbsent(total, p -> new LinkedList<Integer>()).add(i);
        }


        int ans = 0;
        total = 0;
        for (int i = 0; i < nums.length; i++) {
            int val = total + k;

            total += nums[i];
            if (!cntMap.containsKey(val)) {continue;}

            LinkedList<Integer> posList = cntMap.get(val);
            Iterator<Integer> iterator = posList.iterator();
            while (iterator.hasNext()) {
                if (iterator.next() < i) {
                    iterator.remove();
                }
            }

            ans += posList.size();

        }


        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new P560_SubarraySumEqualsK().subarraySum(new int[]{1,2,3}, 3));
    }

}
