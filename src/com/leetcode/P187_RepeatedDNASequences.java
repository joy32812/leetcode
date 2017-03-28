package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xiaoyuan on 28/03/2017.
 */
public class P187_RepeatedDNASequences {

    // A C G T -> 0 1 2 3

    public List<String> findRepeatedDnaSequences(String s) {
        List<String> ans = new ArrayList<String>();
        if (s.length() <= 10) {return ans;}

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        Map<Integer, Integer> begin = new HashMap<Integer, Integer>();

        int value = 0;
        for (int i = 0; i < s.length(); i++) {
            int d = getValue(s.charAt(i));
            value = value * 4 + d;

            if (i < 9) {
                continue;
            }
            if (i > 9) {
                value -= getValue(s.charAt(i - 10)) * (int)Math.pow(4, 10);
            }

            if (map.get(value) == null) {
                map.put(value, 1);
                begin.put(value, i - 10 + 1);
            } else {
                map.put(value, 1 + map.get(value));
            }
        }

        for (Integer key : map.keySet()) {
            int num = map.get(key);
            if (num > 1) {
                int from = begin.get(key);
                ans.add(s.substring(from, from + 10));
            }
        }

        return ans;
    }

    private int getValue(char ch) {
        if (ch == 'A') {return 0;}
        if (ch == 'C') {return 1;}
        if (ch == 'G') {return 2;}
        if (ch == 'T') {return 3;}
        return 0;
    }

}
