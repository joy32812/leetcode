package com.leetcode;

import java.util.ArrayList;
import java.util.List;

interface CustomFunction {
    int f(int x, int y);
};

public class First {
    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {

        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 1; i <= 1000; i++) {
            for (int j = 1; j <= 1000; j++) {
                if (customfunction.f(i, j) == z) {
                    List<Integer> now = new ArrayList<>();
                    now.add(i);
                    now.add(j);
                    ans.add(now);
                }
            }
        }

        return ans;
    }
}
