package com.leetcode;

import java.util.*;

public class P1036_EscapeaLargeMaze {


    Set<String> blockSet = new HashSet<>();

    /**
     * BFS
     * 1. find connected component
     * 2. check if there is a connected component that can block the two points
     *     2.1 two points not in this area, not block
     *     2.2 if one points in this area, move another near this area
     *     2.3 BFS to find if point B can access point B
     * @param blocked
     * @param source
     * @param target
     * @return
     */
    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        if (blocked == null || blocked.length == 0) return true;

        blockSet = new HashSet<>();
        for (int[] b : blocked) blockSet.add(b[0] + "_" + b[1]);

        int n = blocked.length;
        Map<Integer, List<Integer>> adjMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (neighbor(blocked, i, j)) {
                    adjMap.computeIfAbsent(i, k -> new ArrayList<>()).add(j);
                    adjMap.computeIfAbsent(j, k -> new ArrayList<>()).add(i);
                }
            }
        }

        for (int i = 0; i < n; i++) {

            Queue<Integer> Q = new LinkedList<>();
            Set<Integer> inQ = new HashSet<>();
            Q.add(i);
            inQ.add(i);

            while (!Q.isEmpty()) {
                int s = Q.poll();
                List<Integer> adjList = adjMap.computeIfAbsent(s, k -> new ArrayList<>());
                for (int t : adjList) {
                    if (inQ.contains(t)) continue;
                    inQ.add(t);
                    Q.add(t);
                }
            }

            if (block(blocked, inQ, new int[]{source[0], source[1]}, new int[]{target[0], target[1]})) return true;
        }

        return false;
    }

    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    private boolean block(int[][] blocked, Set<Integer> graph, int[] source, int[] target) {

        int minX = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxY = Integer.MIN_VALUE;
        for (int i : graph) {
            minX = Math.min(minX, blocked[i][0]);
            maxX = Math.max(maxX, blocked[i][0]);
            minY = Math.min(minY, blocked[i][1]);
            maxY = Math.max(maxY, blocked[i][1]);
        }

        int cnt = 0;
        if (!notIn(source, minX, maxX, minY, maxY)) cnt++;
        if (!notIn(target, minX, maxX, minY, maxY)) cnt++;
        if (cnt == 0) return true;

        if (cnt == 1) {
            for (int j = Math.max(0, minY - 1); j <= maxY + 1; j++) {
                int x = maxX + 1;
                int y = j;
                if (blockSet.contains(x + "_" + y)) continue;
                if (notIn(source, minX, maxX, minY, maxY)) {
                    source = new int[]{x, y};
                } else {
                    target = new int[]{x, y};
                }
                break;
            }
        }


        Queue<String> Q = new LinkedList<>();
        Set<String> inQ = new HashSet<>();
        Q.add(source[0] + "_" + source[1]);
        inQ.add(source[0] + "_" + source[1]);

        while (!Q.isEmpty()) {
            String now = Q.poll();
            String[] ss = now.split("_");

            int x = Integer.parseInt(ss[0]);
            int y = Integer.parseInt(ss[1]);

            for (int k = 0; k < dx.length; k++) {
                int tx = x + dx[k];
                int ty = y + dy[k];

                if (tx < 0 || ty < 0) continue;

                if (tx < minX - 1 || tx > maxX + 1 || ty < minY - 1 || ty > maxY + 1) continue;
                if (blockSet.contains(tx + "_" + ty)) continue;
                if (inQ.contains(tx + "_" + ty)) continue;
                if (tx == target[0] && ty == target[1]) return true;

                inQ.add(tx + "_" + ty);
                Q.add(tx + "_" + ty);
            }
        }

        return false;
    }

    private boolean notIn(int[] source, int minX, int maxX, int minY, int maxY) {
        return source[0] < minX || source[0] > maxX || source[1] < minY || source[1] > maxY;
    }

    private boolean neighbor(int[][] blocked, int i, int j) {

        return Math.abs(blocked[i][1] - blocked[j][1]) <= 1 && Math.abs(blocked[i][0] - blocked[j][0]) <= 1;
    }


    public static void main(String[] args) {

        System.out.println(new P1036_EscapeaLargeMaze().isEscapePossible(new int[][]{
                {691938,300406},{710196,624190},{858790,609485},{268029,225806},{200010,188664},{132599,612099},{329444,633495},{196657,757958},{628509,883388}
        }, new int[]{655988, 180910}, new int[]{267728,840949}));

    }

}
