package com.leetcode;

import java.util.*;

public class P959_RegionsCutBySlashes {


    /**
     * for every cell, we divide it into 4 small cells
     * then for '/' and '\' and ' ', connect them by edges
     *
     * then use bfs to find the connected parts
     * @param grid
     * @return
     */
    public int regionsBySlashes(String[] grid) {

        int m = grid.length;
        int n = grid[0].length();

        Map<Integer, List<Integer>> edgeMap = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j ++) {
                if (grid[i].charAt(j) == '/') {
                    int aa = (i * n + j) * 4 + 0;
                    int bb = (i * n + j) * 4 + 1;
                    int cc = (i * n + j) * 4 + 2;
                    int dd = (i * n + j) * 4 + 3;

                    List<Integer> aaEdge = edgeMap.computeIfAbsent(aa, k -> new ArrayList<>());
                    aaEdge.add(bb);
                    if (i - 1 >= 0) aaEdge.add(((i - 1) * n + j) * 4 + 2);

                    List<Integer> bbEdge = edgeMap.computeIfAbsent(bb, k -> new ArrayList<>());
                    bbEdge.add(aa);
                    if (j - 1 >= 0) bbEdge.add((i * n + j - 1) * 4 + 3);


                    List<Integer> ccEdge = edgeMap.computeIfAbsent(cc, k -> new ArrayList<>());
                    ccEdge.add(dd);
                    if (i + 1 < m) ccEdge.add(((i + 1) * n + j) * 4 + 0);


                    List<Integer> ddEdge = edgeMap.computeIfAbsent(dd, k -> new ArrayList<>());
                    ddEdge.add(cc);
                    if (j + 1 < n) ddEdge.add((i * n + j + 1) * 4 + 1);

                } else if (grid[i].charAt(j) == '\\') {

                    int aa = (i * n + j) * 4 + 0;
                    int bb = (i * n + j) * 4 + 1;
                    int cc = (i * n + j) * 4 + 2;
                    int dd = (i * n + j) * 4 + 3;

                    List<Integer> aaEdge = edgeMap.computeIfAbsent(aa, k -> new ArrayList<>());
                    aaEdge.add(dd);
                    if (i - 1 >= 0) aaEdge.add(((i - 1) * n + j) * 4 + 2);

                    List<Integer> bbEdge = edgeMap.computeIfAbsent(bb, k -> new ArrayList<>());
                    bbEdge.add(cc);
                    if (j - 1 >= 0) bbEdge.add((i * n + j - 1) * 4 + 3);


                    List<Integer> ccEdge = edgeMap.computeIfAbsent(cc, k -> new ArrayList<>());
                    ccEdge.add(bb);
                    if (i + 1 < m) ccEdge.add(((i + 1) * n + j) * 4 + 0);


                    List<Integer> ddEdge = edgeMap.computeIfAbsent(dd, k -> new ArrayList<>());
                    ddEdge.add(aa);
                    if (j + 1 < n) ddEdge.add((i * n + j + 1) * 4 + 1);

                } else {
                    int aa = (i * n + j) * 4 + 0;
                    int bb = (i * n + j) * 4 + 1;
                    int cc = (i * n + j) * 4 + 2;
                    int dd = (i * n + j) * 4 + 3;

                    List<Integer> aaEdge = edgeMap.computeIfAbsent(aa, k -> new ArrayList<>());
                    aaEdge.add(dd);
                    aaEdge.add(bb);
                    if (i - 1 >= 0) aaEdge.add(((i - 1) * n + j) * 4 + 2);

                    List<Integer> bbEdge = edgeMap.computeIfAbsent(bb, k -> new ArrayList<>());
                    bbEdge.add(cc);
                    bbEdge.add(aa);
                    if (j - 1 >= 0) bbEdge.add((i * n + j - 1) * 4 + 3);


                    List<Integer> ccEdge = edgeMap.computeIfAbsent(cc, k -> new ArrayList<>());
                    ccEdge.add(bb);
                    ccEdge.add(dd);
                    if (i + 1 < m) ccEdge.add(((i + 1) * n + j) * 4 + 0);


                    List<Integer> ddEdge = edgeMap.computeIfAbsent(dd, k -> new ArrayList<>());
                    ddEdge.add(aa);
                    ddEdge.add(cc);
                    if (j + 1 < n) ddEdge.add((i * n + j + 1) * 4 + 1);
                }
            }
        }


        Set<Integer> visit = new HashSet<>();
        int cnt = 0;
        for (int i = 0; i < 2 * m; i++) {
            for (int j = 0; j < 2 * n; j++) {
                if (visit.contains(i * 2 * n + j)) continue;

                cnt++;

                Queue<Integer> Q = new LinkedList<>();
                Q.add(i * 2 * n + j);
                visit.add(i * 2 * n + j);

                while (!Q.isEmpty()) {
                    int now = Q.poll();

                    List<Integer> edge = edgeMap.computeIfAbsent(now, k -> new ArrayList<>());
                    for (int bb : edge) {
                        if (visit.contains(bb)) continue;

                        Q.add(bb);
                        visit.add(bb);
                    }
                }
            }
        }






        return cnt;
    }



    public static void main(String[] args) {

        System.out.println(new P959_RegionsCutBySlashes().regionsBySlashes(new String[]{
                "\\/",
                "/\\"
        }));
    }
}
