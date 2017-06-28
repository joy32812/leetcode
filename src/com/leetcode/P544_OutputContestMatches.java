package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoyuan on 28/06/2017.
 */
public class P544_OutputContestMatches {

    public String findContestMatch(int n) {

        List<String> now = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            now.add("" + (i + 1));
        }

        while (now.size() >= 2) {
            List<String> tmp = new ArrayList<>();

            int ll = 0;
            int rr = now.size() - 1;
            while (ll < rr) {
                tmp.add("(" + now.get(ll) +  "," + now.get(rr) + ")");
                ll ++;
                rr --;
            }

            now = tmp;
        }

        return now.get(0);

    }

    public static void main(String[] args) {
        System.out.println(new P544_OutputContestMatches().findContestMatch(8));
    }

}
