package com.leetcode;

/**
 * Created by xiaoyuan on 05/11/2017.
 */
public class P723_CandyCrush {

    int m, n;
    int[][] B;
    public int[][] candyCrush(int[][] board) {

        B = board;
        m = B.length;
        n = B[0].length;

        while (crash()) {
            drop();
        }


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(B[i][j] + " ");
            }
            System.out.println();
        }
        return B;
    }

    private boolean crash() {

        boolean[][] c = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (B[i][j] == 0) continue;

                int cnt = 1;
                // right
                for (int k = j + 1; k < n; k++) {
                    if (B[i][k] == B[i][j]) cnt++;
                    else break;
                }

                if (cnt >= 3) {
                    for (int k = j; k < n && k < j + cnt; k++) {
                        c[i][k] = true;
                    }
                }



                // down
                cnt = 1;
                for (int k = i + 1; k < m; k++) {
                    if (B[i][j] == B[k][j]) cnt++;
                    else break;
                }

                if (cnt >= 3) {
                    for (int k = i; k < m && k < i + cnt; k++) {
                        c[k][j] = true;
                    }
                }
            }
        }

        boolean crash = false;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (c[i][j]) {
                    crash = true;
                    B[i][j] = 0;
                }
            }
        }

        return crash;
    }

    private void drop() {
        for (int j = 0; j < n; j++) {

            int now = m - 1;
            for (int i = m - 1; i >= 0; i --) {
                if (B[i][j] == 0) continue;
                int tp = B[i][j];
                B[i][j] = B[now][j];
                B[now][j] = tp;
                now--;
            }

        }
    }

    public static void main(String[] args) {
        System.out.println(new P723_CandyCrush().candyCrush(new int[][]{
                {2, 1, 3},
                {2, 2, 2},
                {2, 2, 2},
        }));
    }

}
