package com.leetcode;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by xiaoyuan on 10/05/2017.
 */
public class P351_AndroidUnlockPatterns {

    private int ans;
    private boolean[] used;
    private int tm, tn;

    public int numberOfPatterns(int m, int n) {
        tm = m;
        tn = n;

        ans = 0;
        used = new boolean[9];

        for (int i = 0; i < 9; i++) {
            used[i] = true;
            dfs(i, 1);
            used[i] = false;
        }

        return ans;
    }

    private void dfs(int x, int cnt) {
        if (cnt >= tm && cnt <= tn) {
            ans++;
        }

        if (cnt >= tn) {
            return;
        }

        for (int i = 0; i < 9; i++) {
            if (used[i]) {continue;}

            if (okay(x, i)) {
                used[i] = true;
                dfs(i, cnt + 1);
                used[i] = false;
            }
        }
    }

    private boolean okay(int p, int q) {
        int px = p / 3;
        int py = p % 3;

        int qx = q / 3;
        int qy = q % 3;

        int dx = Math.abs(px - qx);
        int dy = Math.abs(py - qy);
        if (dx <= 1 && dy <= 1) {return true;}


        if ((px + qx) % 2 == 1) {
            return true;
//            mx ++;
//            if (!used[mx * 3 + my]) {return false;}
        } else if((py + qy) % 2 == 1) {
            return true;
//            my ++;
//            if (!used[mx * 3 + my]) {return false;}
        }

        int mx = (px + qx) / 2;
        int my = (py + qy) / 2;
        if (!used[mx * 3 + my]) {return false;}

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new P351_AndroidUnlockPatterns().numberOfPatterns(2, 2));
    }

}
