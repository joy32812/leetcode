package com.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by xiaoyuan on 26/06/2017.
 */
public class P533_LonelyPixelII {

    char[][] grid;
    int m;
    int n;
    public int findBlackPixel(char[][] picture, int N) {

        if (picture == null || picture.length == 0 || picture[0].length == 0 || N > picture.length || N > picture[0].length) {
            return 0;
        }


        grid = picture;
        m = picture.length;
        n = picture[0].length;


        int[] rowNums = getRowNums();
        int[] colNums = getColNums();

        Set<Integer>[] sameSet = new Set[m];
        for (int i = 0; i < m; i++) {
            if (sameSet[i] != null) {continue;}

            sameSet[i] = new HashSet<>();
            sameSet[i].add(i);
            for (int j = i + 1; j < m; j++) {
                if (isSame(i, j)) {
                    sameSet[i].add(j);
                    sameSet[j] = sameSet[i];
                }
            }
        }


        int ans = 0;
        for (int i = 0; i < m; i++) {
            if (rowNums[i] != N) {continue;}
            for (int j = 0; j < n; j++) {
                if (colNums[j] != N) {continue;}
                if (grid[i][j] != 'B') {continue;}

                Set<Integer> tmpSet = new HashSet<>();
                int randomOne = -1;
                for (int k = 0; k < m; k++) {
                    if (grid[k][j] == 'B') {
                        randomOne = k;
                        tmpSet.add(k);
                    }
                }

                if (sameSet[randomOne].containsAll(tmpSet)) {
                    ans ++;
                }

            }
        }


        return ans;
    }

    private boolean isSame(int a, int b) {
        for (int j = 0; j < n; j++) {
            if (grid[a][j] != grid[b][j]) {return false;}
        }
        return true;
    }

    private int[] getColNums() {
        int[] res = new int[n];
        for (int j = 0; j < n; j++) {
            int total = 0;
            for (int i = 0; i < m; i++) {
                if (grid[i][j] == 'B') {total++;}
            }
            res[j] = total;
        }

        return res;
    }

    public int[] getRowNums() {
        int[] res = new int[m];
        for (int i = 0; i < m; i++) {
            int total = 0;
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'B') {total++;}
            }
            res[i] = total;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new P533_LonelyPixelII().findBlackPixel(new char[][]{
                "WBWBBW".toCharArray(),
                "WBWBBW".toCharArray(),
                "WBWBBW".toCharArray(),
                "WWBWBW".toCharArray(),
        }, 3));
    }
}
