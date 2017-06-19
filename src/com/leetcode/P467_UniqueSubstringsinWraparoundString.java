package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiaoyuan on 10/06/2017.
 */
public class P467_UniqueSubstringsinWraparoundString {


    public int findSubstringInWraproundString(String p) {
        if (p == null || p.length() == 0) {return 0;}

        Map<Character, Integer> map = new HashMap<>();

        int ans = 0;

        int cnt = 1;
        char lastCh = p.charAt(0);
        for (int i = 1; i <= p.length(); i++) {
            if (i == p.length() || (p.charAt(i) - lastCh + 26) % 26 != 1) {
                char begin = (char)(lastCh - cnt + 1);
                map.put(begin, Math.max(map.getOrDefault(begin, 0), cnt));

                cnt = 1;
                lastCh = i != p.length() ? p.charAt(i) : '#';
            } else {
                cnt++;
                lastCh = p.charAt(i);
            }
        }

        for (int d : map.values()) {
            ans += d * (d + 1) / 2;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new P467_UniqueSubstringsinWraparoundString().findSubstringInWraproundString("zaba"));
        System.out.println(new P467_UniqueSubstringsinWraparoundString().findSubstringInWraproundString("cac"));
        System.out.println(new P467_UniqueSubstringsinWraparoundString().findSubstringInWraproundString("zab"));
    }

}
