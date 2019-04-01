package com.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P989_AddtoArrayFormofInteger {

    /**
     * easy
     * big integer add
     * @param A
     * @param K
     * @return
     */
    public List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> ans = new ArrayList<>();

        int flag = 0;
        int p = A.length - 1;
        while (p >= 0 || K > 0) {
            int now = (p >= 0 ? A[p] : 0) + (K % 10) + flag;

            p--;
            K /= 10;

            flag = now / 10;
            ans.add(now % 10);
        }

        if (flag > 0) ans.add(1);
        Collections.reverse(ans);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new P989_AddtoArrayFormofInteger().addToArrayForm(new int[]{1, 2, 0, 0}, 34));
        System.out.println(new P989_AddtoArrayFormofInteger().addToArrayForm(new int[]{9, 9, 9}, 1));
    }

}
