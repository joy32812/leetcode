package io.laicode;

import java.util.Random;

public class P218_GenerateRandomMaze {

    int[] dx = {0, 1};
    int[] dy = {1, 0};
    int[][] ans;

    public int[][] maze(int n) {
        ans = new int[n][n];
        if (n <= 1) return ans;

        generate(0, 0, -1, -1);

        sout(ans);
        return ans;
    }

    private void sout(int[][] ans) {
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0;j < ans.length; j++) System.out.print(ans[i][j] + " ");
            System.out.println();
        }
    }

    private void generate(int x, int y, int fx, int fy) {
        if (x == ans.length - 1 && y == ans.length - 1) return;

        // up
        int tx = x - 1;
        int ty = y;
        if (tx >= 0 && ty >= 0) {
            if (!(tx == fx && ty == fy)) ans[tx][ty] = 1;
        }

        // left
        tx = x;
        ty = y - 1;
        if (tx >= 0 && ty >= 0) {
            if (!(tx == fx && ty == fy)) ans[tx][ty] = 1;
        }

        int ind = new Random().nextInt(2);
        tx = x + dx[ind];
        ty = y + dy[ind];
        if (tx < 0 || tx >= ans.length || ty < 0 || ty >= ans.length) {
            tx = x + dx[1 - ind];
            ty = y + dy[1 - ind];
            generate(tx, ty, x, y);
        } else {
            int nx = x + dx[1 - ind];
            int ny = y + dy[1 - ind];
            if (nx >= 0 && nx < ans.length && ny >= 0 && ny < ans.length) ans[nx][ny] = 1;
            generate(tx, ty, x, y);
        }

    }

    public static void main(String[] args) {
        System.out.println(new P218_GenerateRandomMaze().maze(2));
    }

}
