package com.leetcode;

import java.util.Comparator;
import java.util.List;

/**
 * Created by xiaoyuan on 25/06/2017.
 */
public class P524_LongestWordinDictionarythroughDeleting {

    public String findLongestWord(String s, List<String> d) {

        d.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        String ans = "";
        for (String t : d) {
            if (ans.length() < t.length() && isSubSeq(s, t)) {
                ans = t;
            }
        }

        return ans;
    }

    private boolean isSubSeq(String s, String t) {

        int a = 0;
        int b = 0;
        while (true) {
            if (b == t.length()) {return true;}
            if (a == s.length()) {return false;}

            if (s.charAt(a) == t.charAt(b)) {
                a++;
                b++;
            } else {
                a++;
            }
        }
    }

}
