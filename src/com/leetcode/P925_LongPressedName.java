package com.leetcode;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class P925_LongPressedName {


    /**
     * easy
     * check char and num
     * @param name
     * @param typed
     * @return
     */
    public boolean isLongPressedName(String name, String typed) {

        List<int[]> aa = doWork(name);
        List<int[]> bb = doWork(typed);

        if (aa.size() != bb.size()) return false;

        for (int i = 0; i < aa.size(); i++) {
            int[] ss = aa.get(i);
            int[] tt = bb.get(i);

            if (ss[0] != tt[0]) return false;
            if (ss[1] > tt[1]) return false;
        }

        return true;
    }

    private List<int[]> doWork(String s) {
        List<int[]> ans = new ArrayList<>();
        if (s == null) return ans;

        char now = '\n';
        int cnt = 0;
        for (char ch : s.toCharArray()) {
            if (ch != now) {
                if (now != '\n') ans.add(new int[]{now, cnt});
                now = ch;
                cnt = 1;
            } else {
                cnt ++;
            }
        }

        if (cnt > 0) ans.add(new int[]{now, cnt});
        return ans;
    }


    public static void main(String[] args) {
        System.out.println(new P925_LongPressedName().isLongPressedName("saeed", "ssaaedd"));
        System.out.println(new P925_LongPressedName().isLongPressedName("leelee", "lleeelee"));
        System.out.println(new P925_LongPressedName().isLongPressedName("laiden", "laiden"));
    }

}
