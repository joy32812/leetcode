package com.leetcode;

import java.util.*;

public class P749_ContainVirus {


    int m;
    int n;

    int[][] mark;
    int flag;


    int[][] G;
    public int containVirus(int[][] grid) {

        m = grid.length;
        n = grid[0].length;

        G = grid;

        mark = new int[m][n];
        flag = -1;

        int ans = 0;
        while (canInfect()) {

            ans += findMax();

            mark = new int[m][n];
            flag = -1;
        }


        return ans;

    }

    private int findMax() {


        Map<Integer, Set<Integer>> cntMap = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (mark[i][j] > 0) {
                    for (int k = 0; k < dx.length; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];

                        if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                        if (G[nx][ny] == 0) {
                            cntMap.computeIfAbsent(mark[i][j], z -> new HashSet<>()).add(nx * n + ny);
                        }

                    }
                }

            }
        }

        int res = 0;
        int num = 0;
        for (int key : cntMap.keySet()) {
            if (cntMap.get(key).size() > num) {
                num = cntMap.get(key).size();
                res = key;
            }
        }






        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (mark[i][j] == res) {
                    for (int k = 0; k < dx.length; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];

                        if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                        if (mark[nx][ny] != res && G[nx][ny] == 0) {
                            ans++;
                        }
                    }


                    G[i][j] = -1;
                }

            }
        }


        for (int key : cntMap.keySet()) {
            if (key == res) {
                continue;
            }

            Set<Integer> theSet = cntMap.get(key);
            for (int z : theSet) {
                int x = z / n;
                int y = z % n;

                G[x][y] = 1;
            }
        }



        return ans;
    }


    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    private boolean canInfect() {


        boolean can = false;
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (G[i][j] == 1 && mark[i][j] == 0) {

                    cnt++;

                    Queue<Integer> Q = new LinkedList<>();
                    Set<Integer> inQ = new HashSet<>();
                    Q.add(i * n + j);
                    inQ.add(i * n + j);

                    while (!Q.isEmpty()) {
                        int tp = Q.poll();
                        inQ.remove(tp);
                        mark[i][j] = cnt;

                        int x = tp / n;
                        int y = tp % n;

                        for (int k = 0; k < dx.length; k++) {
                            int nx = x + dx[k];
                            int ny = y + dy[k];

                            if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                            if (G[nx][ny] == 0) {
                                can = true;
                                continue;
                            }
                            if (G[nx][ny] != 1) continue;
                            if (mark[nx][ny] == cnt) continue;

                            mark[nx][ny] = cnt;
                            int key = nx * n + ny;
                            if (!inQ.contains(key)) {
                                Q.add(key);
                                inQ.add(key);
                            }
                        }
                    }

                }
            }
        }

        return can;
    }


    public static void main(String[] args) {

//        System.out.println(new A4().containVirus(new int[][]{
//                {0,1,0,0,0,0,0,1},
//                {0,1,0,0,0,0,0,1},
//                {0,0,0,0,0,0,0,1},
//                {0,0,0,0,0,0,0,0},
//        }));
//
//
//        System.out.println(new A4().containVirus(new int[][]{
//                {1, 1, 1},
//                {1, 0, 1},
//                {1, 1, 1},
//        }));

        System.out.println(new P749_ContainVirus().containVirus(new int[][]{
                {1,1,1,0,0,0,0,0,0},
                {1,0,1,0,1,1,1,1,1},
                {1,1,1,0,0,0,0,0,0}
        }));
    }

}
