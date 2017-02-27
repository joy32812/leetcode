package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoyuan on 27/02/2017.
 * Just search
 */
public class P52_NQueensII {

    public void dfs(List<List<String>> result, int[] pos, int ind) {
        if (ind == pos.length) {
            List<String> oneSolution = new ArrayList<String>();
            for(int i = 0; i < pos.length; i++) {
                int col = pos[i];
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < pos.length;j++) {
                    if (j != col) {
                        sb.append('.');
                    } else {
                        sb.append('Q');
                    }
                }
                oneSolution.add(sb.toString());
            }

            result.add(oneSolution);
            return;
        }


        for (int j = 0; j < pos.length; j++){
            if (okay(j, pos, ind)) {
                pos[ind] = j;
                dfs(result, pos, ind + 1);
            }
        }
    }

    private boolean okay(int j, int[] pos, int ind) {
        for (int i = 0; i < ind; i++) {
            if (j == pos[i] || i + pos[i] == ind + j || i - pos[i] == ind - j) {
                return false;
            }
        }

        return true;
    }


    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<List<String>>();
        int[] pos = new int[n];

        dfs(result, pos, 0);

        return result;
    }

    public int totalNQueens(int n) {
        return solveNQueens(n).size();
    }

    public static void main(String[] args) {
        System.out.println(new P52_NQueensII().solveNQueens(10));
    }

}
