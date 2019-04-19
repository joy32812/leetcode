package com.leetcode;

import java.util.LinkedList;
import java.util.List;

public class P763_PartitionLabels {

    public List<Integer> partitionLabels(String S) {

        int[] maxPos = new int[30];

        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            maxPos[ch - 'a'] = i;
        }


        List<Integer> ans = new LinkedList<>();

        int total = 0;
        int max = 0;
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            max = Math.max(max, maxPos[ch - 'a']);

            if (max == i) {
                ans.add(max + 1 - total);
                total = max + 1;
            }
        }

        return ans;
    }

}
