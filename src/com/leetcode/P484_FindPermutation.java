package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoyuan on 03/08/2017.
 */
public class P484_FindPermutation {

    public int[] findPermutation(String s) {

        List<Integer> ans = new ArrayList<>();
        int now = 0;

        int cnt = 0;
        for (int i = 0; i <= s.length(); i++) {

            cnt++;

            if (i == s.length() || s.charAt(i) == 'I') {
                now += cnt;
                for (int j = now, k = 0; k < cnt; j--, k++) {
                    ans.add(j);
                }

                cnt=0;
            }
        }

        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
//        int[] ans = new P484_FindPermutation().findPermutation("D");
        int[] ans = new P484_FindPermutation().findPermutation("DDDDIDIDIDIDIIIDIDI");
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.println();
    }
}
