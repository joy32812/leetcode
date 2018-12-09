package com.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P955_DeleteColumnstoMakeSortedII {


    /**
     * medium
     * 3 situations
     * a. sort column -> return
     * b. have equal val -> generate another array to check
     * c. no sort -> del
     *
     * @param A
     * @return
     */
    public int minDeletionSize(String[] A) {
        if (A == null || A.length == 0 || A[0].length() == 0) return 0;


        int[][] arr = new int[A.length][A[0].length()];
        for (int i = 0; i < A.length; i++) {
            String word = A[i];
            for (int j = 0; j < A[0].length(); j++) {
                arr[i][j] = word.charAt(j) - 'a';
            }
        }

        return dfs(arr);

    }

    private int dfs(int[][] arr) {

        int n = arr.length;
        if (n <= 1) return 0;

        int m = arr[0].length;
        if (m == 0) return 0;

        boolean order = true;
        for (int i = 1; i < n; i++) {
            if (arr[i][0] < arr[i - 1][0]) order = false;
        }

        if (!order) {
            int[][] na = new int[n][m - 1];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m - 1; j++) {
                    na[i][j] = arr[i][j + 1];
                }
            }

            return 1 + dfs(na);
        }

        Set<Integer> eqSet = new HashSet<>();
        for (int i = 1; i < n; i++) {
            if (arr[i][0] == arr[i - 1][0]) eqSet.add(arr[i][0]);
        }
        if (eqSet.isEmpty()) return 0;

        List<int[]> list = new ArrayList<>();
        int cnt = 0;
        Set<Integer> newSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (eqSet.contains(arr[i][0])) {

                if (!newSet.contains(arr[i][0])) {
                    newSet.add(arr[i][0]);
                    cnt = cnt + 1;
                }

                int[] nn = new int[m - 1];
                for (int j = 0; j < m - 1; j++) {
                    nn[j] = arr[i][j + 1] + cnt * 26;
                }
                list.add(nn);
            }
        }
        int[][] na = new int[list.size()][m - 1];
        for (int i = 0; i < list.size(); i++) {
            na[i] = list.get(i);
        }

        return dfs(na);
    }


    public static void main(String[] args) {

        String[] aa = new String[]{"abx","agz","bgc","bfc"};
        System.out.println(new P955_DeleteColumnstoMakeSortedII().minDeletionSize(aa));

    }


}
