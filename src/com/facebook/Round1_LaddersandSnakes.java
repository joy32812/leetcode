package com.facebook;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

public class Round1_LaddersandSnakes {


    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new FileReader("/Users/xiaoyuan/Downloads/facebook/in.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("/Users/xiaoyuan/Downloads/facebook/out.txt"));

        int T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            work(br, bw, i);
        }

        bw.flush();
        bw.close();
    }

    private static void work(BufferedReader br, BufferedWriter bw, int caseNo) throws Exception {
        int ans = -1;

        String s = br.readLine();
        int n = Integer.parseInt(s.split(" ")[0]);
        int h = Integer.parseInt(s.split(" ")[1]);


        List<int[]> ladders = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String t = br.readLine();

            int x = Integer.parseInt(t.split(" ")[0]);
            int a = Integer.parseInt(t.split(" ")[1]);
            int b = Integer.parseInt(t.split(" ")[2]);

            ladders.add(new int[]{x, a, b});
        }

        boolean zero = false;
        for (int i = 0; i < n; i++) {
            int x = ladders.get(i)[0];
            int a = ladders.get(i)[1];
            int b = ladders.get(i)[2];

            if (a == 0 && b == h) {
                String line = "Case #" + caseNo + ": " + ans;
                System.out.println(line);
                bw.write(line + "\n");
                return;
            }


            if (a == 0) zero = true;
        }

        if (!zero) {
            ans = 0;
            String line = "Case #" + caseNo + ": " + ans;
            System.out.println(line);
            bw.write(line + "\n");
            return;
        }

        int max = 1000000;

        int N = 2 * n + 2;
        int[][] g = new int[N][N];
        for (int i = 0; i < n; i++) {
            g[i][n + i] = max;
        }

        ladders.sort((a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });

        for (int i = 0; i < n; i++) {
            int[] ss = ladders.get(i);

            if (ss[1] == 0) {
                g[2 * n][i] = max;
            }
            if (ss[2] == h) {
                g[n + i][2 * n + 1] = max;
            }

            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                int[] tt = ladders.get(j);
                if (ss[1] >= tt[2] || tt[1] >= ss[2]) continue;
                if (ss[1] == 0 && tt[1] == 0) continue;

                int length = okay(ladders, i, j);
                if (length == 0) continue;

                if (ss[1] == 0) {
                    g[n + i][j] = length;
                } else if (tt[1] == 0) {
                    g[n + j][i] = length;
                } else {
                    g[n + i][j] = g[n + j][i] = length;
                }
            }
        }


        ans = fordFulkerson(g, 2 * n, 2 * n + 1);
        String line = "Case #" + caseNo + ": " + ans;
        System.out.println(line);
        bw.write(line + "\n");
    }


    private static int okay(List<int[]> ladders, int i, int j) {
        int[] ss = ladders.get(i);
        int[] tt = ladders.get(j);

        TreeMap<Integer, Integer> treeMap = new TreeMap<>();

        int aa = Math.max(ss[1], tt[1]);
        int bb = Math.min(ss[2], tt[2]);
        treeMap.put(aa, bb);

        for (int k = 0; k < ladders.size(); k++) {
            if (k == i || k == j) continue;

            int[] zz = ladders.get(k);
            if ((zz[0] - ss[0]) * (zz[0] - tt[0]) >= 0) continue;

            List<int[]> delList = new ArrayList<>();
            List<int[]> insertList = new ArrayList<>();

            for (int start : treeMap.keySet()) {
                int end = treeMap.get(start);

                if (zz[1] >= end || zz[2] <= start) continue;

                if (zz[1] <= start && zz[2] >= end) {
                    delList.add(new int[]{start, end});
                    continue;
                }

                if (start <= zz[1] && end >= zz[2]) {
                    insertList.add(new int[]{start, zz[1]});
                    insertList.add(new int[]{zz[2], end});
                    continue;
                }

                if (start >= zz[1] && start <= zz[2]) {
                    delList.add(new int[]{start, end});
                    insertList.add(new int[]{zz[2], end});
                } else {
                    delList.add(new int[]{start, end});
                    insertList.add(new int[]{start, zz[1]});
                }

            }


            for (int[] seg : delList) treeMap.remove(seg[0]);
            for (int[] seg : insertList) if (seg[0] < seg[1]) treeMap.put(seg[0], seg[1]);
        }

        int ans = 0;
        for (int start : treeMap.keySet()) ans += treeMap.get(start) - start;
        return ans;
    }

    private static int fordFulkerson(int[][] graph, int s, int t) {
        int N = graph.length;
        int G[][] = new int[N][N];

        for (int u = 0; u < N; u++) {
            for (int v = 0; v < N; v++) {
                G[u][v] = graph[u][v];
            }
        }

        int parent[] = new int[N];
        int ans = 0;
        while (bfs(G, s, t, parent)) {
            int u, v;
            int flow = Integer.MAX_VALUE;
            for (v = t; v != s; v = parent[v]) {
                u = parent[v];
                flow = Math.min(flow, G[u][v]);
            }

            for (v = t; v != s; v = parent[v]) {
                u = parent[v];
                G[u][v] -= flow;
                G[v][u] += flow;
            }
            ans += flow;
        }

        return ans;
    }

    private static boolean bfs(int[][] g, int s, int t, int[] parent) {
        int N = g.length;
        boolean visited[] = new boolean[N];
        for (int i = 0; i < N; ++i) visited[i] = false;

        LinkedList<Integer> Q = new LinkedList<>();
        Q.add(s);
        visited[s] = true;
        parent[s] = -1;

        while (Q.size() != 0) {
            int u = Q.poll();
            for (int v = 0; v < N; v++) {
                if (visited[v] == false && g[u][v] > 0) {
                    Q.add(v);
                    parent[v] = u;
                    visited[v] = true;
                }
            }
        }
        return visited[t] == true;
    }


}
