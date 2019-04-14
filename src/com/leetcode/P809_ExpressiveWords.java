package com.leetcode;


import java.util.ArrayList;
import java.util.List;

public class P809_ExpressiveWords {

    public int expressiveWords(String S, String[] words) {

        List<int[]> sList = getNomralList(S);

        int ans = 0;

        for (String w : words) {
            List<int[]> wList = getNomralList(w);
            if (wList.size() != sList.size()) continue;

            boolean okay = true;
            for (int i = 0; i < sList.size(); i++) {
                int[] ss = sList.get(i);
                int[] ww = wList.get(i);
                if (ss[0] != ww[0] || ss[1] < ww[1] || (ss[1] == 2 && ww[1] == 1 )) {
                    okay = false;
                    break;
                }
            }

            if (okay) ans++;
        }

        return ans;
    }

    private List<int[]> getNomralList(String s) {
        List<int[]> ans = new ArrayList<>();

        int ch = -1;
        int cnt = 0;
        for (char cs : s.toCharArray()) {
            int now = cs - 'a';
            if (ch != now) {
                if (ch != -1) ans.add(new int[]{ch, cnt});

                ch = now;
                cnt = 1;
            } else {
                cnt++;
            }
        }

        if (ch != -1) ans.add(new int[]{ch, cnt});
        return ans;
    }

}
