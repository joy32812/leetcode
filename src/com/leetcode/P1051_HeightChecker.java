package com.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P1051_HeightChecker {

    /**
     * easy
     * sort and compare
     * @param heights
     * @return
     */
    public int heightChecker(int[] heights) {
        List<Integer> data = new ArrayList<>();
        for (int h : heights) data.add(h);

        Collections.sort(data);

        int ans = 0;
        for (int i = 0; i < heights.length; i++) {
            if (data.get(i) != heights[i]) ans ++;
        }

        return ans;
    }



    public static void main(String[] args) {

    }

}
