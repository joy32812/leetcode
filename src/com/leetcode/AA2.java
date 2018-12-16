package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class AA2 {


    public int[] prisonAfterNDays(int[] cells, int N) {

        Map<Integer, Integer> ansMap = new HashMap<>();
        int[] states = new int[1 << 10];
        int[][] z = new int[1 << 10][];
        int cnt = 0;
        int begin = 0;
        while (true) {
            if (cnt == N) return cells;

            int num = getNum(cells);
            if (ansMap.containsKey(num)) {
                begin = ansMap.get(num);
                break;
            }
            states[cnt] = num;
            ansMap.put(num, cnt);

            z[cnt] = cells;

            cnt++;

            int[] ncell = new int[8];
            Arrays.fill(ncell, 0);

            for (int i = 1; i < 7; i++) {
                if (cells[i - 1] == cells[i + 1]) ncell[i] = 1;
            }

            cells = ncell;
        }

        if (begin == 0) begin = cnt;
        N -= begin;

        if (begin == cnt) begin = 0;

        int nn = N % (cnt - begin);
        return z[begin + nn];
    }

    private int getNum(int[] cells) {
        int num = 0;
        for (int i = 0; i < cells.length; i++) {
            num = num * 2 + cells[i];
        }
        return num;
    }


    public static void main(String[] args) {

    }
}
