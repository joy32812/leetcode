package com.leetcode;

import java.util.*;

/**
 * Created by xiaoyuan on 01/07/2017.
 */
public class P599_MinimumIndexSumofTwoLists {

    public String[] findRestaurant(String[] list1, String[] list2) {

        Map<String, Integer> oneMap = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            oneMap.put(list1[i], i);
        }

        Map<String, Integer> twoMap = new HashMap<>();
        for (int i = 0; i < list2.length; i++) {
            twoMap.put(list2[i], i);
        }

        int sumMax = Integer.MAX_VALUE;
        List<String> ans = new ArrayList<>();
        for (String rest : oneMap.keySet()) {
            if (!twoMap.containsKey(rest)) {continue;}

            int sum = oneMap.get(rest) + twoMap.get(rest);
            if (sum < sumMax) {
                sumMax = sum;
                ans = new ArrayList<>();
                ans.add(rest);
            } else if (sum == sumMax) {
                ans.add(rest);
            }
        }

        String[] arr = new String[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            arr[i] = ans.get(i);
        }
        return arr;
    }

}
