package com.leetcode;

import java.util.*;

/**
 * Created by xiaoyuan on 10/09/2017.
 */
public class P675_CutOffTreesforGolfEvent {

    private class Cell {
        int x;
        int y;
        int h;

        public Cell(int x, int y, int h) {
            this.x = x;
            this.y = y;
            this.h = h;
        }
    }
    public int cutOffTree(List<List<Integer>> forest) {
        if (forest == null || forest.size() == 0 || forest.get(0).size() == 0 || forest.get(0).get(0) == 0) {return -1;}

        List<Cell> cellList = new ArrayList<>();
        for (int i = 0; i < forest.size(); i++) {
            for (int j = 0; j < forest.get(i).size(); j++) {
                if (forest.get(i).get(j) > 1) {
                    cellList.add(new Cell(i, j, forest.get(i).get(j)));
                }
            }
        }

        Collections.sort(cellList, new Comparator<Cell>() {
            @Override
            public int compare(Cell o1, Cell o2) {
                return o1.h - o2.h;
            }
        });

        int sx = 0;
        int sy = 0;
        int ans = 0;

        for (int i = 0; i < cellList.size(); i++) {
            Cell nowCell = cellList.get(i);

            int dis = bfs(forest, sx, sy, nowCell.x, nowCell.y);
            if (dis == -1) {return -1;}

            ans += dis;

            sx = nowCell.x;
            sy = nowCell.y;
        }


        return ans;
    }


    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};

    int bfs(List<List<Integer>> forest, int sx, int sy, int ex, int ey) {

        if (sx == ex && sy == ey) {
            return forest.get(sx).get(sy) > 0 ? 0 : -1;
        }

        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < forest.size(); i++) {
            List<Integer> tmp = new ArrayList<>();
            for (int j = 0; j < forest.get(i).size(); j++) {
                tmp.add(-1);
            }

            res.add(tmp);
        }
        res.get(sx).set(sy, 0);

        Queue<Cell> Q = new LinkedList<>();
        Q.add(new Cell(sx, sy, 0));

        while (!Q.isEmpty()) {
            Cell top = Q.poll();

            int nx = top.x;
            int ny = top.y;

            for (int i = 0; i < dx.length; i++) {
                int tx = nx + dx[i];
                int ty = ny + dy[i];

                if (tx < 0 || tx >= forest.size() || ty < 0 || ty >= forest.get(tx).size() || forest.get(tx).get(ty) == 0 || res.get(tx).get(ty) != -1) {continue;}
                if (tx == ex && ty == ey) {return top.h + 1;}

                res.get(tx).set(ty, top.h + 1);
                Q.add(new Cell(tx, ty, top.h + 1));
            }

        }

        return -1;
    }

    public static void main(String[] args) {
        List<List<Integer>> param = new ArrayList<>();
        List<Integer> l1 = new ArrayList<>();
        l1.add(2);
        l1.add(3);
        l1.add(4);
        List<Integer> l2 = new ArrayList<>();
        l2.add(0);
        l2.add(0);
        l2.add(5);
        List<Integer> l3 = new ArrayList<>();
        l3.add(8);
        l3.add(7);
        l3.add(6);

        param.add(l1);
        param.add(l2);
        param.add(l3);

        System.out.println(new P675_CutOffTreesforGolfEvent().cutOffTree(param));

    }

}
