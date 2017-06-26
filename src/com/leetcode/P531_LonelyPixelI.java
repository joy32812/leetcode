package com.leetcode;

/**
 * Created by xiaoyuan on 26/06/2017.
 */
public class P531_LonelyPixelI {

    public int findLonelyPixel(char[][] picture) {
        if (picture == null || picture.length == 0 || picture[0].length == 0) {return 0;}

        int m = picture.length;
        int n = picture[0].length;

        int[] rowNums = new int[m];
        for (int i = 0; i < m; i++) {
            int total = 0;
            for (int j = 0; j < n; j++) {
                if (picture[i][j] == 'B') {total++;}
            }
            rowNums[i] = total;
        }

        int[] colNums = new int[n];
        for (int j = 0; j < n; j++) {
            int total = 0;
            for (int i = 0; i < m; i++) {
                if (picture[i][j] == 'B') {total++;}
            }
            colNums[j] = total;
        }

        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (picture[i][j] == 'B' && rowNums[i] == 1 && colNums[j] == 1) {
                    ans++;
                }
            }
        }

        return ans;
    }

}
