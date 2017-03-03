package com.leetcode;

/**
 * Created by xiaoyuan on 03/03/2017.
 * brute search
 */
public class P79_WordSearch {

    public boolean okay(char[][] board, boolean[][] visit, int x, int y, String word, int pos) {
        if (board[x][y] != word.charAt(pos)) {
            return false;
        }
        if (pos == word.length() - 1) {
            return true;
        }

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < board.length && ny >= 0 && ny < board[0].length && !visit[nx][ny]) {
                visit[x][y] = true;
                if (okay(board, visit, nx, ny, word, pos + 1)) {
                    return true;
                }
                visit[x][y] = false;
            }
        }

        return false;
    }

    public boolean exist(char[][] board, String word) {
        if (word.length() == 0) {return true;}
        if (board.length == 0 || board[0].length == 0) {return false;}


        int m = board.length;
        int n = board[0].length;
        boolean[][] visit = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (okay(board, visit, i, j, word, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        System.out.println(new P79_WordSearch().exist(board, "ABCCED"));
        System.out.println(new P79_WordSearch().exist(board, "SEE"));
        System.out.println(new P79_WordSearch().exist(board, "ABCB"));
    }

}
