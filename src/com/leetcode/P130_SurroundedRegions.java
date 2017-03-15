package com.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by xiaoyuan on 15/03/2017.
 * easy traverse
 */
public class P130_SurroundedRegions {

    private int[][] visit;
    private int[] dx;
    private int[] dy;

    private int m;
    private int n;
    public void solve(char[][] board) {
        if (board.length == 0 || board[0].length == 0) {return;}
        m = board.length;
        n = board[0].length;

        dx = new int[]{0, 0, 1, -1};
        dy = new int[]{1, -1, 0, 0};

        visit = new int[m][n];

        for (int i = 0; i < m; i++) {
            if(board[i][0] == 'O') {bfs(board, i, 0);}
        }
        for (int i = 0; i < m; i++) {
            if(board[i][n - 1] == 'O') {bfs(board, i, n - 1);}
        }

        for (int j = 0; j < n; j++) {
            if(board[0][j] == 'O') {bfs(board, 0, j);}
        }
        for (int j = 0; j < n; j++) {
            if(board[m - 1][j] == 'O') {bfs(board, m - 1, j);}
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O' && visit[i][j] != 1) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void bfs(char[][] board, int x, int y) {
        Set<Integer> inQ = new HashSet<Integer>();
        Queue<Integer> Q = new LinkedList<Integer>();
        visit[x][y] = 1;
        Q.add(x * n + y);
        inQ.add(x * n + y);

        while (!Q.isEmpty()) {
            int now = Q.poll();
            inQ.remove(now);

            int nx = now / n;
            int ny = now % n;

            for (int i = 0; i < 4; i++) {
                int zx = nx + dx[i];
                int zy = ny + dy[i];

                if (zx < 0 || zx >=m || zy < 0 || zy >= n || board[zx][zy] != 'O' || visit[zx][zy] == 1) {continue;};

                visit[zx][zy] = 1;
                if (!inQ.contains(zx * n + zy)) {
                    inQ.add(zx * n + zy);
                    Q.add(zx * n + zy);
                }
            }
        }
    }

    private void dfs(char[][] board, int x, int y) {
        if (x < 0 || x >= m || y < 0 || y >= n) {return;}
        if (board[x][y] != 'O') {return;}
        if (visit[x][y] == 1) {return;}

        visit[x][y] = 1;
        for (int i = 0; i < 4; i++) {
            dfs(board, x + dx[i], y + dy[i]);
        }
    }

    public static void main(String[] args) {
        char[][] b = {
                {'O','O','O'},
                {'O','O','O'},
                {'O','O','O'}
        };

        new P130_SurroundedRegions().solve(b);
        System.out.println("h");
    }
}
