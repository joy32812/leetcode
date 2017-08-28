package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiaoyuan on 28/08/2017.
 */
public class P411_MinimumUniqueWordAbbreviation {

    int m;
    boolean[] mark;
    public String minAbbreviation(String target, String[] dictionary) {

        m = target.length();
        int n = 1 << m;
        mark = new boolean[n];

        for (String word : dictionary) {
            work( word, target);
        }

        String ans = "";
        int number = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (mark[i] == false) {

                StringBuilder sb = new StringBuilder();
                int cnt = 0;
                int tmp = 0;
                for (int j = 0; j < m; j++) {
                    if ((i & (1 << j)) > 0) {
                        if (tmp > 0) {cnt++;sb.append(tmp);}
                        sb.append(target.charAt(j));
                        cnt++;
                        tmp = 0;
                    } else {
                        tmp++;
                    }
                }
                if (tmp > 0) {cnt++;sb.append(tmp);}

                if (cnt < number) {
                    ans = sb.toString();
                    number = cnt;
                }
            }
        }

        return ans;
    }

    private void work(String word, String target) {
        if (target.length() != word.length()) {return;}
        if (target.equals(word)) {return;}

        mark[0] = true;

        Map<Integer, Integer> posMap = new HashMap<>();
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            if (target.charAt(i) == word.charAt(i)) {
                posMap.put(cnt, i);
                cnt++;
            }
        }

        if (cnt == 0) {return;}

        int total = (1 << cnt) - 1;
        for (int i = 1; i <= total; i++) {
            int z = 0;
            for (int j = 1; j <= cnt; j++) {
                if ((i & (1 << (j - 1))) != 0) {
                    z += (1 << posMap.get(j - 1));
                }
            }

            mark[z] = true;
        }

    }


    public static void main(String[] args) {
        System.out.println(new P411_MinimumUniqueWordAbbreviation().minAbbreviation("leetcode", new String[]{"lyftcode","leetcold","litecode","lietcode","leetccod","lyftcold"}));
//        System.out.println(new P411_MinimumUniqueWordAbbreviation().minAbbreviation("apple", new String[]{"blade"}));
//        System.out.println(new P411_MinimumUniqueWordAbbreviation().minAbbreviation("apple", new String[]{"plain", "amber", "blade"}));
    }

}
