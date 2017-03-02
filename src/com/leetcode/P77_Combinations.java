package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoyuan on 02/03/2017.
 */
public class P77_Combinations {


    public void dfs(List<List<Integer>> result, boolean[] visit, int pos, int num, int k) {
        if (num == k) {
            List<Integer> tmp = new ArrayList<Integer>();
            for (int i = 0; i < visit.length; i++) {
                if(visit[i]) {
                    tmp.add(i + 1);
                }
            }
            result.add(tmp);
            return;
        }

        if (num >= visit.length) {
            return;
        }

        if (num + visit.length - pos < k) {
            return;
        }

        visit[pos] = false;
        dfs(result, visit, pos + 1, num, k);

        visit[pos] = true;
        dfs(result, visit, pos + 1, num + 1, k);
        visit[pos] = false;
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        boolean[] visit = new boolean[n];
        dfs(result,visit, 0, 0, k);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new P77_Combinations().combine(1, 0));
    }

}
