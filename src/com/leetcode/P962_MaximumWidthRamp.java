package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class P962_MaximumWidthRamp {


    int[] N;
    public int maxWidthRamp(int[] A) {
        N = A;

        int ans = 0;
        int n = A.length;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (list.isEmpty()) list.add(i);
            else {
                if (A[i] < A[list.get(list.size() - 1)]) list.add(i);
                else {
                    ans = Math.max(ans, getMathDis(list, A[i], i));
                }
            }
        }

        return ans;

    }

    private int getMathDis(List<Integer> list, int now, int pos) {
        if (now >= N[list.get(0)]) return pos - list.get(0);

        int l = 0;
        int r = list.size() - 1;
        while (l < r) {
            int m = (l + r) / 2;
            if (N[list.get(m)] > now) l = m + 1;
            else r = m;
        }

        return pos - list.get(l);
    }


    public static void main(String[] args) {
        System.out.println(new P962_MaximumWidthRamp().maxWidthRamp(new int[]{3, 4, 1, 2}));

        System.out.println(new P962_MaximumWidthRamp().maxWidthRamp(new int[]{6,0,8,2,1,5}));

        System.out.println(new P962_MaximumWidthRamp().maxWidthRamp(new int[]{9,8,1,0,1,9,4,0,4,1}));
    }

}
