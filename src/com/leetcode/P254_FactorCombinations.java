package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoyuan on 14/04/2017.
 */
public class P254_FactorCombinations {

    private int N;
    public List<List<Integer>> getFactors(int n) {
        N = n;
        return dfs(n, 2);
    }

    private List<List<Integer>> dfs(int n, int b) {
        List<List<Integer>> result = new ArrayList<>();
        if (n != N) {
            List<Integer> tmp = new ArrayList<>();
            tmp.add(n);
            result.add(tmp);
        }

        for (int i = b; i * i <= n; i++) {
            if (n % i != 0) {continue;}

            List<List<Integer>> other = dfs(n / i, i);
            for (List<Integer> nowList : other) {
                nowList.add(i);
                result.add(nowList);
            }
        }

        return result;
    }


    public static void main(String[] args) {
        System.out.println(new P254_FactorCombinations().getFactors(12));
    }
}
