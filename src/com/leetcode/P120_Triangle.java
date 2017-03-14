package com.leetcode;

import java.util.List;

/**
 * Created by xiaoyuan on 14/03/2017.
 */
public class P120_Triangle {

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 0) {return 0;}

        int size = triangle.size();

        for (int i = size - 2; i >= 0; i--) {
            List<Integer> lineInts = triangle.get(i);
            List<Integer> nextInts = triangle.get(i + 1);
            for (int j = 0; j < triangle.get(i).size(); j++) {
                lineInts.set(j, lineInts.get(j) + Math.min(nextInts.get(j), nextInts.get(j + 1)));
            }
        }

        return triangle.get(0).get(0);
    }

    public static void main(String[] args) {

    }

}
