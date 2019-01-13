package com.leetcode;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class P963_MinimumAreaRectangleII {


    double area = 0.0;
    public double minAreaFreeRect(int[][] points) {
        double ans = Double.MAX_VALUE;

        int m = points.length;

        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                for (int k = j + 1; k < m; k++) {
                    if (!vertical(points[i], points[j], points[k])) continue;
                    if (sameEdge(points[i], points[j], points[k])) continue;
                    for (int z = k + 1; z < m; z++) {
                        if (isRect(points[i], points[j], points[k], points[z])) {
                            ans = Math.min(ans, area);
                        }
                    }
                }
            }
        }

        return ans == Double.MAX_VALUE ? 0.0 : ans;
    }

    private boolean vertical(int[] a, int[] b, int[] c) {
        if ((b[0] - a[0]) * (c[0] - a[0]) + (b[1] - a[1]) * (c[1] - a[1]) == 0) return true;

        if ((b[0] - c[0]) * (a[0] - c[0]) + (b[1] - c[1]) * (a[1] - c[1]) == 0) return true;

        if ((a[0] - b[0]) * (c[0] - b[0]) + (a[1] - b[1]) * (c[1] - b[1]) == 0) return true;
        return false;
    }

    private boolean isRect(int[] aa, int[] bb, int[] cc, int[] dd) {

        if (sameEdge(aa, bb, cc)) return false;
        if (sameEdge(aa, bb, dd)) return false;
        if (sameEdge(bb, cc, dd)) return false;


        int[][] now = new int[4][];
        now[0] = aa;
        now[1] = bb;
        now[2] = cc;
        now[3] = dd;

        Map<Long, Integer> map = new TreeMap<>();

        for (int i = 0; i < 4; i++) {
            for (int j = i + 1; j < 4; j++) {
                long dist = dist2(now[i], now[j]);
                map.put(dist, map.getOrDefault(dist, 0) + 1);
            }
        }

        long[] edges = new long[3];
        if (map.size() == 3) {
            for (int val : map.values()) {
                if (val != 2) return false;
            }
            int cnt = 0;
            for (long key : map.keySet()) {
                edges[cnt++] = key;
            }
        } else if (map.size() == 2) {
            for (int val : map.values()) {
                if (val == 2 || val == 4) {}
                else return false;
            }

            for (long key : map.keySet()) {
                if (map.get(key) == 2) {
                    edges[2] = key;
                } else {
                    edges[0] = key;
                    edges[1] = key;
                }
            }
        } else {
            return false;
        }


        Arrays.sort(edges);
        area = Math.sqrt(edges[0]) * Math.sqrt(edges[1]);

        return edges[0] + edges[1] == edges[2];
    }

    private boolean sameEdge(int[] aa, int[] bb, int[] cc) {
        int[] y = new int[]{bb[0] - aa[0], bb[1] - aa[1]};
        int[] z = new int[]{cc[0] - aa[0], cc[1] - aa[1]};


        return y[0] * z[1] == y[1] * z[0];
    }

    private long dist2(int[] aa, int[] bb) {
        return (aa[0] - bb[0]) * (aa[0] - bb[0]) + (aa[1] - bb[1]) * (aa[1] - bb[1]);
    }


    public static void main(String[] args) {
        System.out.println(new P963_MinimumAreaRectangleII().minAreaFreeRect(new int[][]{
//                {2,4},{4,2},{1,0},{3,4},{4,4},{2,2},{1,1},{3,0},{1,4},{0,3},{0,1},{2,1},{4,0}
                {1, 4}, {1, 1}, {2, 1}, {2, 4}
        }));
    }

}
