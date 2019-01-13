package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class P969_PancakeSorting {



    public List<Integer> pancakeSort(int[] A) {

        List<Integer> ans = new ArrayList<>();

        int now = A.length - 1;
        while (now != 0) {

            int p = getMaxPosition(A, now);

            if (now == p) {
                now --;
                continue;
            }

            if (p != 0) {
                ans.add(p + 1);
                doFlip(A, p);
            }
            ans.add(now + 1);
            doFlip(A, now);

            now --;
        }


        return ans;
    }

    private void doFlip(int[] a, int p) {
        int l = 0;
        int r = p;
        while (l < r) {
            int tmp = a[l];
            a[l] = a[r];
            a[r] = tmp;

            l++;
            r--;
        }
    }

    private int getMaxPosition(int[] a, int now) {

        int p = 0;
        int max = a[0];
        for (int i = 1; i <= now; i++) {
            if (a[i] > max) {
                p = i;
                max = a[i];
            }
        }

        return p;
    }


    public static void main(String[] args) {

        System.out.println(new P969_PancakeSorting().pancakeSort(new int[]{2, 1, 3}));

    }

}
