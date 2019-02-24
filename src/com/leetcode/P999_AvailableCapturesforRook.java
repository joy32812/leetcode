package com.leetcode;

public class P999_AvailableCapturesforRook {


    int[] tx = {0, 0, 1, -1};
    int[] ty = {1, -1, 0, 0};

    /**
     * easy, find the ans by four direction
     * @param board
     * @return
     */
    public int numRookCaptures(char[][] board) {

        int m = board.length;
        int n = board[0].length;

        int x = -1;
        int y = -1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'R') {
                    x = i;
                    y = j;
                    break;
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < tx.length; i++) {

            int nx = x + tx[i];
            int ny = y + ty[i];

            while (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                if (board[nx][ny] == 'p') {
                    ans ++;
                    break;
                } else if (board[nx][ny] == 'B') {
                    break;
                }

                nx = nx + tx[i];
                ny = ny + ty[i];
            }

        }

        return ans;

    }

    public static void main(String[] args) {

    }

}
