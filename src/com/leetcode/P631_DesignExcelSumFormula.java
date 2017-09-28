package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiaoyuan on 28/09/2017.
 */

class Excel {


    private Map<Integer, Map<Integer, Integer>> sumMap;
    private Map<Integer, Integer> valueMap;
    int R;
    int C;

    public Excel(int H, char W) {
        R = H;
        C = (W - 'A') + 1;

        sumMap = new HashMap<>();
        valueMap = new HashMap<>();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                valueMap.put(i * C + j, 0);
            }
        }
    }

    public void set(int r, char c, int v) {
        int key = (r - 1) * C + (c - 'A');
        if (sumMap.containsKey(key)) sumMap.remove(key);
        valueMap.put(key, v);
    }

    private Map<Integer, Integer> nowMap;
    private int dfs(int key) {
        if (nowMap.containsKey(key)) return nowMap.get(key);

        if (valueMap.containsKey(key)) {
            nowMap.put(key, valueMap.get(key));
            return nowMap.get(key);
        }

        int sum = 0;
        Map<Integer, Integer> cntMap = sumMap.get(key);
        for (int k : cntMap.keySet()) {
            sum += cntMap.get(k) * dfs(k);
        }

        nowMap.put(key, sum);
        return nowMap.get(key);
    }

    public int get(int r, char c) {
        int key = (r - 1) * C + (c - 'A');
        nowMap = new HashMap<>();
        return dfs(key);
    }


    public int sum(int r, char c, String[] strs) {
        int key = (r - 1) * C + (c - 'A');
        Map<Integer, Integer> cntMap = new HashMap<>();
        for (String s : strs) {
            if (s.indexOf(":") == -1) {
                int[] p = getPostion(s);
                cntMap.put(p[2], cntMap.getOrDefault(p[2], 0) + 1);
            } else {
                String[] range = s.split(":");
                int[] p = getPostion(range[0]);
                int[] q = getPostion(range[1]);

                for (int i = p[0]; i <= q[0]; i++) {
                    for (int j = p[1]; j<= q[1]; j++) {
                        int k = i * C + j;
                        cntMap.put(k, cntMap.getOrDefault(k, 0) + 1);
                    }
                }
            }
        }

        if (valueMap.containsKey(key)) valueMap.remove(key);
        sumMap.put(key, cntMap);

        return get(r, c);
    }

    private int[] getPostion(String s) {
        int c = s.charAt(0) - 'A';
        int r = Integer.parseInt(s.substring(1)) - 1;
        return new int[]{r, c, r * C + c};
    }
}

public class P631_DesignExcelSumFormula {


    public static void main(String[] args) {
        Excel e = new Excel(3, 'C');

        System.out.println(e.sum(1, 'A', new String[]{"A2"}));

        e.set(2, 'A', 1);

        System.out.println(e.get(1, 'A'));
    }

}
