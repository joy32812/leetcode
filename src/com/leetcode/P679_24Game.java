package com.leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by xiaoyuan on 17/09/2017.
 */
public class P679_24Game {

    public boolean judgePoint24(int[] nums) {
        List<Double> vals = new ArrayList<>();
        for (int d : nums) vals.add(0.0 + d);

        return solve(vals);
    }

    private boolean solve(List<Double> vals) {
        if (vals.size() == 1) {
            return Math.abs(vals.get(0) - 24) <= 1e-6;
        }


        for (int i = 0; i < vals.size(); i++) {
            for (int j = 0;j < vals.size(); j++) {
                if (i == j) continue;
                double x = vals.get(i);
                double y = vals.get(j);

                List<Double> other = copyOther(vals, i, j);
                other.add(x + y);
                if (solve(other)) return true;

                other = copyOther(vals, i, j);
                other.add(x - y);
                if (solve(other)) return true;

                other = copyOther(vals, i, j);
                other.add(x * y);
                if (solve(other)) return true;

                if (y != 0) {
                    other = copyOther(vals, i, j);
                    other.add(x / y);
                    if (solve(other)) return true;
                }
            }
        }
        return false;
    }

    private List<Double> copyOther(List<Double> vals, int i, int j) {
        List<Double> ans = new ArrayList<>();
        for (int x = 0; x < vals.size(); x++) {
            if (x == i || x == j) continue;
            ans.add(vals.get(x));
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new P679_24Game().judgePoint24(new int[]{
                4, 1, 8, 7
        }));
    }


}
